/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.Arrays;
import poo.io.IO;

/**
 *
 * @author nacho
 */
public class ProyectoJava {

    /**
     * @param args the command line arguments
     */
    public static vehiculo[] listaVehiculos = new vehiculo[3];

    public static void main(String[] args) throws compruebaMatricula {
//Prueba de la excepcion poniendo como ejemplo la implementada en la clase vehiculo  
        System.out.println("----------Prueba excepciones--------");
        vehiculo coche = new vehiculo("6781 ahj", "Renault Clio", "Gris", 11092021, "4889725343H", 81);
        try {
            vehiculo coche1 = new vehiculo("6781 ahj", "Renault Clio", "Gris", 11092021, "4889725343H", 81);
            System.out.println("NO HAY EXCEPCION");
        } catch (compruebaMatricula cm) {
            System.out.print("Excepcion: ");
            System.out.println(cm.getMessage());
        }
        //Segunda prueba
        try {
            String[] muebles = {"silla", "silla", "armaio"};
            caravana c = new caravana("abc 12345", 1, 1, 1, 1, 1, muebles);
            System.out.println(c.getIdentificador());
        } catch (compruebaMatricula cm) {
            System.out.print("Excepcion: ");
            System.out.println(cm.getMessage());
            //cm.printStackTrace(); me interesa mas verlo como la forma de arriba
        }
        


//Prueba de los metodos toString de algunas clases
        System.out.println("\n----------Prueba toString--------");
        autoCaravana ac = new autoCaravana("3809 lwg", "Scenic a41", "Blanco", 28012022, "45629823E", 101, 40, 200, 20, 7, 17);
        System.out.println("toString de vehiculo: " + coche.toString());
        System.out.println("toString de autoCaravana: " + ac.toString()); //Observese el uso de super.toString() en el metodo toString() de la clase autoCaravana

//Prueba del metodo equals en la clase vehiculo (por ejemplo)
        System.out.println("\n----------Prueba equals--------");
        IVehiculo skoda = new vehiculo("1235 dhg", "Skoda Fabia", "Rojo", 21072022, "48999823E", 80); // compara por matriculas
        System.out.println("Como la matricula vel vehiculo es unica, al usar el metodo equals, SON IGUALES LOS COCHES?: " + coche.equals(skoda));

//Uso del atributo array de tipo vehiculo para llamar a un metodo estatico cuyo objetivo es la venta de vehiculos
        System.out.println("\n----------Prueba metodo estatico que usa array--------");
        listaVehiculos[0] = ac;
        listaVehiculos[1] = coche;
        listaVehiculos[2] = (vehiculo) skoda;
        escaparateVehiculos(listaVehiculos);

//Prueba de la clase comparable implementada en vehiculo, autoCaravana y camper
        System.out.println("\n----------Prueba de la interfaz comparable que implementa vehiculo--------");
        vehiculo[] v1 = new vehiculo[3];
        v1[0] = new vehiculo("abc defc", "", "", 3, "", 4);
        v1[1] = new vehiculo("abc defb", "", "", 3, "", 4);
        v1[2] = new vehiculo("abc defa", "", "", 3, "", 4);

        int i;
        for (i = 0; i < v1.length; i++) {
            System.out.println(v1[i].getPermisoCirculacion().getMatricula());
        }
        Arrays.sort(v1); //Deberia quedar un orden tal que el vehiculo 2-1-0
        System.out.println("");
        for (i = 0; i < v1.length; i++) {
            System.out.println(v1[i].getPermisoCirculacion().getMatricula());
        }

//Prueba de la clase comparator que vamos a usar para ordenar autocaravanas por su tamanyo
        System.out.println("\n----------Prueba de la interfaz comparator--------");
        autoCaravana[] a = new autoCaravana[2];
        a[0] = new autoCaravana("3809 lwg", "Scenic a41", "Blanco", 28012022, "45629823E", 101, 40, 200, 20, 7, 22);
        a[1] = new autoCaravana("3811 lwg", "Scenic a101", "Gris", 03112023, "451234523E", 101, 40, 200, 20, 7, 17);
        System.out.println("Array de autocaravanas ANTES de ordenar con la clase comparadorTamanyo: ");
        for (i = 0; i < a.length; i++) {
            System.out.println("Autocaravana " + (i + 1) + " : " + a[i].toString());
        }
        Arrays.sort(a, new comparadorTamanyo());
        System.out.println("Array de autocaravanas DESPUES de ordenar con la clase comparadorTamanyo: ");
        for (i = 0; i < a.length; i++) {
            System.out.println("Autocaravana " + (i + 1) + " : " + a[i].toString());
        }

//AHORA, VOY A HACER USO DE LAS CLASES
        System.out.println("\n----------Uso de clases (no hay apenas interaccion con  la consola)--------");
        IVehiculo pruebaVehiculo = new vehiculo("2345 dkn", "Bmw Series 3", "Negro", 21072022, "89017342R", 85); //Desde la interfaz IVehiculo
        pruebaVehiculo.getPermisoCirculacion().pasarITV(); //Probamos como en el objeto pruebaVehiculo podemos llamar al metodo getPermisoCirculacion() para obtener una referencia del objeto permisoCirculacion, el cual puede llamar al pasareITv, que es un metodo 
        IVehiculo pruebaCamper = new camper("1344 def", "volkswagen camper", "Blanco y rojo", 21072022, "8873432R", 76, false, true);
        pruebaCamper.getPermisoCirculacion(); //Observamos como podemos llamar al metodo de la clase padre gracias a la herencia
        pruebaCamper.avanzar(34, 34);         //Observamos como podemos llamar al metodo creado en camper
        //String[] muebles = {"armario", "mesita de noche", "sofa"};
        String[] electrodomesticos = {"microondas", "frigorifico", "hornilla de gas"};
        String[] muebles = {"silla", "silla", "armaio"};
        IHabitable bunga = new bungalow("34342S", 23, 1, 34, 3, 1, muebles, electrodomesticos);
        bunga.cocinar(15); //Observamos como funciona la redefinicion en la clase hija bungalow que implementa de la clase padre habitaculo

    }

    /**
     * Metodo estatico para simular una conduccion
     *
     * @param v v va a ser un vehiculo. Puede ser cualquier tipo de vehiculo
     * contemplado en la relacion de herencia: vehiculo, camper o autocaravana.
     * Esto lo logramos gracias a la interfaz.
     */
    public static void conducir(IVehiculo v) {
        System.out.println("Conduciendo " + v.getPermisoCirculacion().getMarcaYmodelo());
        v.setGasolina(32);
        v.setHoraArranque(21);
        v.setEncendido(true);
        v.setLuces(true);
        v.avanzar(18, 145);
        System.out.println();

    }

    public static void escaparateVehiculos(vehiculo[] lista) {
        int i;
        int compra;
        vehiculo aux;
        System.out.println("Bienvenido a nuestra tienda de vehiculos. A continuacion se le mostrara la lista de vehiculos que tenemos disponible:");
        for (i = 0; i < lista.length; i++) {
            System.out.println("Vehiculo " + (i + 1) + ": " + lista[i]);
        }
        System.out.println("Selecciona que vehiculo quieres comprar: ");
        compra = (int) IO.readNumber() - 1;
        for (i = compra; i < lista.length - 1; i++) {
            aux = lista[i];
            lista[i] = lista[i + 1];
            lista[i + 1] = aux;
        }

        System.out.println("Nuestra lista de vehiculos queda asi:");
        for (i = 0; i < lista.length - 1; i++) {
            System.out.println("Vehiculo " + (i + 1) + ": " + lista[i]);
        }
        System.out.println("Espero que la compra haya sido satisfactoria!");

    }
}
