/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 * Clase para instanciar caravanas.
 *
 * @author nacho
 */
public class autoCaravana extends vehiculo implements IHabitable, Comparable {

    private int capacidadAgua;
    private int capacidadBateria; //Diferente a la que tiene un vehiculo (en la clase vehiculo no he hablado de bateria, pero para aclarar que no es la misma)
    private double capacidadButano;
    private int numeroCamas;
    private int tamanyoEnM2; //Tamanyo en metros cuadrados

    /**
     *
     * @param matricula
     * @param marcaYmodelo
     * @param color
     * @param fechaPasarItv
     * @param dniDuenyo
     * @param capacidadDeposito
     * @param capacidadAgua capacidad del deposito de agua de la autocaravana.
     * Para la ducha, fregar los platos, el parabrisas...
     * @param capacidadBateria capacidad del bateria de la autocaravana
     * @param capacidadButano capacidad del butano (para cocinar y ducharnos)
     * @param numeroCamas numero de camas disponibles
     * @param tam tamanyo del interior
     */
    public autoCaravana(String matricula, String marcaYmodelo, String color, int fechaPasarItv, String dniDuenyo, int capacidadDeposito, int capacidadAgua, int capacidadBateria, double capacidadButano, int numeroCamas, int tam) throws compruebaMatricula {
        super(matricula, marcaYmodelo, color, fechaPasarItv, dniDuenyo, capacidadDeposito);
        this.capacidadAgua = capacidadAgua;
        this.capacidadBateria = capacidadBateria;
        this.capacidadButano = capacidadButano;
        this.numeroCamas = numeroCamas;
        tamanyoEnM2 = tam;
    }

    /**
     * Constructor que vamos a usar para instanciar objetos. Estos objetos, los
     * vamos a ver mediante la interfaz IVehiculo, por lo que solo nos interesan
     * los atributos de un vehiculo ( o los del interior de la autocaravana)
     *
     * @param matricula
     * @param marcaYmodelo
     * @param color
     * @param fechaPasarItv
     * @param dniDuenyo
     * @param capacidadDeposito
     */
    public autoCaravana(String matricula, String marcaYmodelo, String color, int fechaPasarItv, String dniDuenyo, int capacidadDeposito) throws compruebaMatricula {
        super(matricula, marcaYmodelo, color, fechaPasarItv, dniDuenyo, capacidadDeposito);
    }

    /**
     * Redefinimos avanzar, limitando la velocidad a 110 (en lugar de 125, que
     * fue lo indicado en permisoCirculacion - vehiculo)
     *
     * @param km
     * @param velocidad
     */
    @Override
    public void avanzar(int km, int velocidad) {
        int repostar;
        if (km / 12 > super.getGasolina()) {
            repostar = km / 12 - super.getGasolina();
            System.out.println("Antes de salir, reposte minimo " + repostar + " litros en la gasolinera mas cercana.");
        } else {
            System.out.println("*Conduciendo " + km + " kilometros hasta su destino*");
        }
        if (velocidad > 0 && velocidad <= 110) {
            this.velocidadActual = (double) velocidad;
            System.out.println("Usted ha adquirido una velocidad de " + velocidad + " km/hora.");
        } else {
            System.out.print("Velocidad no valida!");
        }
    }

    /**
     * Introduce la capacidad de agua
     *
     * @param agua
     */
    @Override
    public void setCapacidadAgua(int agua) {
        capacidadAgua = agua;
    }

    /**
     *
     * @return la capacidad de agua
     */
    @Override
    public int getCapacidadAgua() {
        return capacidadAgua;
    }

    /**
     * Introduce la capacidad de la bateria
     *
     * @param bat cantidad de bateria
     */
    @Override
    public void setCapacidadBateria(int bat) {
        capacidadBateria = bat;
    }

    /**
     *
     * @return la capacidad de la bateria
     */
    @Override
    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    /**
     * Introducir la capacidad del butano actual
     *
     * @param butano
     */
    @Override
    public void setCapacidadButano(double butano) {
        capacidadButano = butano;
    }

    /**
     *
     * @return la capacidad del butano
     */
    @Override
    public double getCapacidadButano() {
        return capacidadButano;
    }

    /**
     * Introduce el numero de camaas de la autocaravana
     *
     * @param numCamas
     */
    @Override
    public void setNumeroCamas(int numCamas) {
        numeroCamas = numCamas;
    }

    /**
     *
     * @return devuelve el numero de camas disponibles
     */
    @Override
    public int getNumeroCamas() {
        return numeroCamas;
    }

    /**
     * Introducir el tamanyo del interior de la autocaravana
     *
     * @param tam tamanyo
     */
    @Override
    public void setTamanyoEnM2(int tam) {
        tamanyoEnM2 = tam;
    }

    /**
     *
     * @return
     */
    @Override
    public int getTamanyoEnM2() {
        return tamanyoEnM2;
    }

    /**
     *
     * @param tiempo
     */
    @Override
    public void ducharse(int tiempo) {
        int agua = 10 * tiempo; //(En minutos) A una presion normal, unos 10 litros por minuto de grifo abierto
        if (capacidadAgua - agua <= 0) {
            System.out.println("Se ha quedado sin agua. Rellene el deposito.");
            capacidadAgua = 0;
        } else {
            System.out.println("*Duchandose durante " + tiempo + " minutos*");
            capacidadAgua = capacidadAgua - agua;
        }
    }

    /**
     *
     * @param tiempo
     */
    @Override
    public void cocinar(int tiempo) {
        double butano = 0.01 * (double) tiempo; //(En minutos) A una presion normal, unos 10 litros por minuto de grifo abierto
        if (capacidadButano - butano <= 0) {
            System.out.println("Se ha quedado sin butano. Rellene el deposito.");
            capacidadButano = 0;
        } else {
            System.out.println("*Cocinando durante " + tiempo + " minutos*");
            capacidadButano = capacidadButano - butano;
        }
    }

    /**
     * Metodo para dormiur. Tiene en cuyenta que la autocaravana este apagada,
     * el numero de camas y el numero de personas que quieren dormir en las
     * camas. Ademas, da algunas recomendaciones
     *
     * @param numPers numero de personas que van a dormir
     */
    @Override
    public void dormir(int numPers) {
        if (numPers > numeroCamas && super.getEncendido() == false) {
            System.out.println("Hay mas personas que camas. Sacad la tienda de campanya del maletero.");
        } else if (super.getEncendido() == true && numPers > numeroCamas) {
            System.out.println("Se ha procedido a apagar la autocaravana para dormir.");
            super.setEncendido(false);
        } else if (super.getEncendido() == true && numPers > numeroCamas) {
            System.out.println("Se ha procedido a apagar la autocaravana para dormir. Se recomienda sacar la tienda de campanya del maletero, ya que faltan camas.");
            super.setEncendido(false);
        } else {
            System.out.println("Duermiento... Zzz");
        }
    }

    /**
     * Redefinicion del metodo toString para que el objeto te devuelva una
     * cadena de caracteres personalizada
     *
     * @return el mensaje personalizado
     */
    @Override
    public String toString() {
        return super.toString() + "Esta autocaravana posee " + numeroCamas + " numero de camas, " + tamanyoEnM2 + " metros cuadrados de espacio, ducha, cocina, maletero, antena de internet...";
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
        autoCaravana c = (autoCaravana) o;
        return getPermisoCirculacion().getMatricula().equals(c.getPermisoCirculacion().getMatricula());
    }

    @Override
    public int compareTo(Object o) {
        autoCaravana ac = (autoCaravana) o;
        if (this.getPermisoCirculacion().getMatricula().compareTo(ac.getPermisoCirculacion().getMatricula()) > 0) {
            return 1;

        } else {
            return -1;
        }
    }

}
