/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.Arrays;

/**
 * Crearemos caravanas, las cuales implementaran la interfaz IHabitaculo
 *
 * @author nacho
 */
public class caravana extends Habitaculo implements Comparable {

    private String identificador;

    public caravana(String id, int agua, int bat, double but, int numCam, int tam, String[] muebles)
            throws compruebaMatricula {
        super(agua, bat, but, numCam, tam, muebles);
        try {
            setIdentificador(id);
        } catch (compruebaMatricula cm) {
            System.out.print("Excepcion NASHEEE: ");
            System.out.println(cm.getMessage());
        }

    }

    /**
     * Introduce el identificador de la caravana. Las caravanas no tienen una
     * matricula comparable a la de los vehiculos, por ello tendremos que usar
     * esto.
     *
     * @param id identificador
     */
    public void setIdentificador(String id) throws compruebaMatricula {
        if (id.length() != 8) {
            throw new compruebaMatricula("El formato de matriculacion no es correcto");
        } else {
            this.identificador = id;
        }

    }

    /**
     * Devuelve el identificador
     *
     * @return
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Introduce la capacidad de agua
     *
     * @param agua
     */
    @Override
    public void setCapacidadAgua(int agua) {
        if (agua > 0) {
            super.setCapacidadAgua(agua);
        } else {
            System.out.println("Ha introducido una cantidad incorrecta. El deposito se quedara como antes.");
        }

    }

    /**
     * Obtener la capacidad de agua de la caravana
     *
     * @return
     */
    @Override
    public int getCapacidadAgua() {
        return super.getCapacidadAgua();
    }

    /**
     * Introducir la capacidad de bateria de la caravama
     *
     * @param bat
     */
    @Override
    public void setCapacidadBateria(int bat) {
        super.setCapacidadBateria(bat);
    }

    /**
     * Obtener la capacidad de bateria
     *
     * @return bateria
     */
    @Override
    public int getCapacidadBateria() {
        return super.getCapacidadBateria();
    }

    /**
     * Introducir el butano
     *
     * @param butano
     */
    @Override
    public void setCapacidadButano(double butano) {
        super.setCapacidadButano(butano);
    }

    /**
     *
     * @return cantidad butano
     */
    @Override
    public double getCapacidadButano() {
        return super.getCapacidadButano();
    }

    /**
     * Introducir el numero de camas
     *
     * @param numCamas
     */
    @Override
    public void setNumeroCamas(int numCamas) {
        super.setNumeroCamas(numCamas);
    }

    /**
     *
     * @return numero de camas de la caravana
     */
    @Override
    public int getNumeroCamas() {
        return super.getNumeroCamas();
    }

    /**
     * Introducir el tamanyo de la caravana
     *
     * @param tam
     */
    @Override
    public void setTamanyoEnM2(int tam) {
        super.setTamanyoEnM2(tam);
    }

    /**
     *
     * @return tamanyo en metros cuadrados
     */
    @Override
    public int getTamanyoEnM2() {
        return super.getTamanyoEnM2();
    }

    /**
     * Este metodo recibe una cadena de Strings con muebles y los introduce en
     * el atributo muebles
     *
     * @param muebles
     */
    @Override
    public void setMuebles(String[] muebles) {
        super.setMuebles(muebles);
    }

    /**
     * Devuelve un string con los muebles de la caravana
     *
     * @return muebles
     */
    @Override
    public String[] getMuebles() {
        return super.getMuebles();
    }

    /**
     * Metodo para simular una ducha. Tiene en cuenta que haya agua suficiente
     * para tomar una ducha de x tiempo
     *
     * @param tiempo tiempo de la ducha
     */
    @Override
    public void ducharse(int tiempo) {
        int agua = 10 * tiempo; //(En minutos) A una presion normal, unos 10 litros por minuto de grifo abierto
        if (super.getCapacidadAgua() - agua <= 0) {
            System.out.println("Se ha quedado sin agua. Rellene el deposito.");
            super.setCapacidadAgua(0);
        } else {
            System.out.println("*Sacando la manguera de la caravana* ... *Instalando la ducha portatil fuera* ... *Duchandose durante " + tiempo + " minutos*");
            super.setCapacidadAgua(super.getCapacidadAgua() - agua);
        }
    }

    /**
     * Metodo para simular cocinar. Tiene en cuenta el tiempo que se va a
     * tardar, para que muestre cuando se acaba el butano
     *
     * @param tiempo
     */
    @Override
    public void cocinar(int tiempo) {
        double butano = 0.01 * (double) tiempo; //(En minutos) A una presion normal, unos 10 litros por minuto de grifo abierto
        if (getCapacidadButano() - butano <= 0) {
            System.out.println("Se ha quedado sin butano. Rellene el deposito.");
            setCapacidadButano(0);
        } else {
            System.out.println("*Cocinando durante " + tiempo + " minutos*");
            setCapacidadButano(getCapacidadButano() - butano);
        }
    }

    /**
     * Simula dormir teniendo en cuenta el numero de personas que hay. Da
     * recomendaciones
     *
     * @param numPers
     */
    @Override
    public void dormir(int numPers) {
        if (numPers > getNumeroCamas()) {
            System.out.println("Se recomienda sacar la tienda de campanya del maletero. Hay mas personas que camas.");
        } else {
            System.out.println("*Durmiendo*");
        }
    }

    @Override
    public String toString() {
        return "El identificador (matricula) de esta caravana es " + identificador + super.toString();
    }

    /**
     * Redefincion del metodo equals. Compararemos lo que difiere a cada camper:
     * la matricula
     *
     * @param o objeto generico. Lo convertiremos en el objeto tipo que vayamos
     * a usar
     * @return true en caso de que sean iguales
     */
    @Override
    public boolean equals(Object o) {
        caravana c = (caravana) o;
        return identificador.equals(c.getIdentificador());
    }

    @Override
    public int compareTo(Object o) {
        caravana c = (caravana) o;
        if (this.getIdentificador().compareTo(c.getIdentificador()) > 0) {
            return 1;

        } else {
            return -1;
        }
    }
}
