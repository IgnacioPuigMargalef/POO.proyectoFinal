/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.Arrays;

/**
 *
 * @author nacho
 */
public abstract class Habitaculo implements IHabitable {

    private int capacidadAgua;
    private int capacidadBateria; //Diferente a la que tiene un vehiculo (en la clase vehiculo no he hablado de bateria, pero para aclarar que no es la misma)
    private double capacidadButano;
    private int numeroCamas;
    private int tamanyoEnM2; //Tamanyo en metros cuadrados
    private String muebles[];

    public Habitaculo(int agua, int bat, double but, int numCam, int tam, String[] muebles) {
        capacidadAgua = agua;
        capacidadBateria = bat;
        capacidadButano = but;
        numeroCamas = numCam;
        tamanyoEnM2 = tam;
        this.muebles = Arrays.copyOf(muebles, muebles.length); //preguntar

    }

    /**
     * Introduce la capacidad de agua
     *
     * @param agua
     */
    @Override
    public void setCapacidadAgua(int agua) {
        if (agua > 0) {
            this.capacidadAgua = agua;
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
        return capacidadAgua;
    }

    /**
     * Introducir la capacidad de bateria de la caravama
     *
     * @param bat
     */
    @Override
    public void setCapacidadBateria(int bat) {
        capacidadBateria = bat;
    }

    /**
     * Obtener la capacidad de bateria
     *
     * @return bateria
     */
    @Override
    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    /**
     * Introducir el butano
     *
     * @param butano
     */
    @Override
    public void setCapacidadButano(double butano) {
        capacidadButano = butano;
    }

    /**
     *
     * @return cantidad butano
     */
    @Override
    public double getCapacidadButano() {
        return capacidadButano;
    }

    /**
     * Introducir el numero de camas
     *
     * @param numCamas
     */
    @Override
    public void setNumeroCamas(int numCamas) {
        numeroCamas = numCamas;
    }

    /**
     *
     * @return numero de camas de la caravana
     */
    @Override
    public int getNumeroCamas() {
        return numeroCamas;
    }

    /**
     * Introducir el tamanyo de la caravana
     *
     * @param tam
     */
    @Override
    public void setTamanyoEnM2(int tam) {
        tamanyoEnM2 = tam;
    }

    /**
     *
     * @return tamanyo en metros cuadrados
     */
    @Override
    public int getTamanyoEnM2() {
        return tamanyoEnM2;
    }

    /**
     * Este metodo recibe una cadena de Strings con muebles y los introduce en
     * el atributo muebles
     *
     * @param muebles
     */
    public void setMuebles(String[] muebles) {
        this.muebles = Arrays.copyOf(muebles, muebles.length);
    }

    /**
     * Devuelve un string con los muebles de la caravana
     *
     * @return muebles
     */
    public String[] getMuebles() {
        return muebles;
    }

    /**
     * Metodo abstracto, cuya implementacion se dara en clases hijas
     *
     * @param tiempo tiempo de la ducha
     */
    @Override
    public abstract void ducharse(int tiempo);

    /**
     * Metodo abstracto, cuya implementacion se dara en clases hijas
     *
     * @param tiempo tiempo de cocina
     */
    @Override
    public abstract void cocinar(int tiempo);

    /**
     * Metodo abstracto, cuya implementacion se dara en clases hijas
     *
     * @param numPers numero de personas que duermen
     */
    @Override
    public abstract void dormir(int numPers);

    @Override
    public String toString() {
        return "Su habitaculo, posee " + numeroCamas + " numero de camas, " + tamanyoEnM2 + " metros cuadrados de espacio por dentro, un grifo exterior para abrir una ducha portatil, cocina, mesa, sofa, television, internet, muebles... entre otras muchas cosas!\n";
    }

}
