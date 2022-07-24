/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import poo.io.IO;

/**
 * Esta clase va a ser usada como atributo para la clase vehiculo.
 *
 * @author nacho
 */
public class PermisoCirculacion {

    private String matricula;
    private String marcaYmodelo; //Se usara de la siguiente manera: "Seat ibiza" --> Marca: seat Modelo: ibiza
    private String color;
    private int fechaPasarItv; //Se usara de la siguiente manera: 29052021 (29/05/2021)
    private String dniDuenyo;
    private int capacidadDeposito;

    /**
     *
     * @param matricula matricula del vehiculo
     * @param marcaYmodelo ejemplo: skodafabia
     * @param color color del vehiculo
     * @param fechaPasarItv fecha en la que el vehiculo debe pasar la inspeccion
     * tecnica
     * @param dniDuenyo dni del duenyo del vehiculo
     * @param capacidadDeposito capacidad del deposito de gasolina del vehiculo
     */
    public PermisoCirculacion(String matricula, String marcaYmodelo, String color, int fechaPasarItv, String dniDuenyo, int capacidadDeposito) throws compruebaMatricula {
        setMatricula(matricula);
        this.capacidadDeposito = capacidadDeposito;
        this.marcaYmodelo = marcaYmodelo;
        this.fechaPasarItv = fechaPasarItv;
        this.color = color;
        this.capacidadDeposito = capacidadDeposito;

    }

    /**
     * Introducir la matricula como atributo
     *
     * @param matricula matricula del vehiculo
     */
    public void setMatricula(String matricula) throws compruebaMatricula {
        if (matricula.length() != 8) {
            throw new compruebaMatricula("El formato de matriculacion no es correcto");
        } else {
            this.matricula = matricula;
        }
    }

    /**
     * Devuelve la matricula del vehiculo referenciado
     *
     * @return string con la matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Introduce como atributo la marca y el modelo del vehiculo referenciado
     *
     * @param marcaYmodelo string
     */
    public void setMarcaYmodelo(String marcaYmodelo) {
        this.marcaYmodelo = marcaYmodelo;
    }

    /**
     * Devuelve la marca y el modelo del vehiculo referenciado
     *
     * @return marca y modelo
     */
    public String getMarcaYmodelo() {
        return marcaYmodelo;
    }

    /**
     * Introduce el color del vehiculo
     *
     * @param color va a ser el que se va a indicar como atributo del objeto
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtener el color del vehiculo
     *
     * @return el color
     */
    public String getColor() {
        return color;
    }

    /**
     * Fecha en la que el vehiculo referenciado tiene que pasar la itv
     *
     * @param fechaPasarItv
     */
    public void setFechaPasarItv(int fechaPasarItv) {
        this.fechaPasarItv = fechaPasarItv;
    }

    /**
     * Metodo que nos va a devolver la fecha de ITV
     *
     * @return La devuelve asi: 23052023 (23/05/2023)
     */
    public int getFechaPasarItv() {
        return fechaPasarItv;

    }

    /**
     * Introducir el dni del duenyo del vehiculo
     *
     * @param dniDuenyo string con el dni
     */
    public void setDniDuenyo(String dniDuenyo) {
        this.dniDuenyo = dniDuenyo;
    }

    /**
     * Obtener el dni del duenyo actual del vehiculo
     *
     * @return un string con el dni
     */
    public String getDniDuenyo() {
        return dniDuenyo;
    }

    /**
     * Introduce la capacidad del vehiculo
     *
     * @param capacidadDeposito entero que indica la cantidad
     */
    public void setCapacidadDeposito(int capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }

    /**
     * Para obtener la cantidad del deposito del vehiculo
     *
     * @return un entero con la cantidad
     */
    public int getCapacidadDeposito() {
        return capacidadDeposito;
    }

    /**
     * Metodo para renovar le identidad del duenyo del vehiculo. Esto se suelce
     * hacer al venderlo
     */
    public void renovarPc() {
        System.out.print("Introduce el dni del nuevo duenyo del vehiculo: ");
        this.dniDuenyo = IO.readLine();
    }

    public void pasarITV() {
        int fecha;
        System.out.print("Introduce la fecha en la que tiene que volver a realizar la inspeccion tecnica del vehiculo: ");
        fecha = (int) IO.readNumber();           //recuerdo que el formato usado es del tipo 23052021 (que es 23/05/2021). La voy a usar para renovar la fecha del siguiente anyo;
        this.fechaPasarItv = fecha;
    }

}
