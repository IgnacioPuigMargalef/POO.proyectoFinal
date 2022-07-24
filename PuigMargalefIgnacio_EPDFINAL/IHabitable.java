/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 * Solo va a tener los metodos referentes al habitaculo. Algunos como consultar
 * datos del vehiculo (en el caso de la autocaravana) o de enganchar al vehiculo
 * (caso de caravana), no seran visibles en esta interfaz. Los metodos estan
 * documentados en las clases caravana y autocaravana.
 *
 * @author nacho
 */
public interface IHabitable {

    public void setCapacidadAgua(int agua);

    public int getCapacidadAgua();

    void setCapacidadBateria(int bat);

    int getCapacidadBateria();

    void setCapacidadButano(double butano);

    double getCapacidadButano();

    void setNumeroCamas(int numCamas);

    int getNumeroCamas();

    void setTamanyoEnM2(int tam);

    int getTamanyoEnM2();

    public void ducharse(int tiempo);

    public void cocinar(int tiempo);

    public void dormir(int numPers);

}
