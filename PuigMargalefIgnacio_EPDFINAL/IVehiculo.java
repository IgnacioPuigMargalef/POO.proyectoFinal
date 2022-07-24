/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 * Interfaz para vehiculo. Los metodos vienen documentados en la clase vehiculo.
 *
 * @author nacho
 */
public interface IVehiculo {

    public void setGasolina(int gasolina);

    public int getGasolina();

    public void setLuces(boolean luces);

    public boolean getLuces();

    public void setEncendido(boolean encendido);

    public boolean getEncendido();

    public void setHoraArranque(int hora);

    public int getHoraArranque();

    void avanzar(int km, int velocidad);

    void frenar(int deceleracion);

    PermisoCirculacion getPermisoCirculacion();

}
