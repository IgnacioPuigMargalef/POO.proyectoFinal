/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 * Clase para instanciar objetos camper. Obtiene todos los atributos y metodos
 * de vehiculo, ya que es un vehiculo camperizado.
 *
 * @author nacho
 */
public class camper extends vehiculo implements Comparable {

    private boolean cama, mesa;

    /**
     *
     * @param matricula matricula de la camper
     * @param marcaYmodelo marca y modelo de la camper
     * @param color color de la camper
     * @param fechaPasarItv de la camper
     * @param dniDuenyo de la camper
     * @param capacidadDeposito de la camper
     */
    public camper(String matricula, String marcaYmodelo, String color, int fechaPasarItv, String dniDuenyo, int capacidadDeposito) throws compruebaMatricula {
        super(matricula, marcaYmodelo, color, fechaPasarItv, dniDuenyo, capacidadDeposito);
    }

    /**
     * Mismo constructor, pero podemos especificar el estado de los atributos
     *
     * @param matricula
     * @param marcaYmodelo
     * @param color
     * @param fechaPasarItv
     * @param dniDuenyo
     * @param capacidadDeposito
     * @param cama
     * @param mesa
     */
    public camper(String matricula, String marcaYmodelo, String color, int fechaPasarItv, String dniDuenyo, int capacidadDeposito, boolean cama, boolean mesa) throws compruebaMatricula {
        super(matricula, marcaYmodelo, color, fechaPasarItv, dniDuenyo, capacidadDeposito);
        this.mesa = mesa;
        this.cama = cama;
        if (cama == mesa && cama == true) {
            System.out.println("No pueden estar la mesa y la cama abiertas a la vez. Ambos estaran cerrados para evitar problemas.");
            this.cama = false;
            this.mesa = false;
        }
    }

    /**
     * Introduce el estado de la cama (true abierta, false cerrada). Tiene en
     * cuenta al atributo mesa
     *
     * @param cama estado
     */
    public void setCama(boolean cama) {
        if (mesa == false) {
            this.cama = cama;
        } else {
            System.out.println("No se puede abrir la cama. La mesa esta siendo usada.");
        }

    }

    /**
     * Devuelve el estado de la cama (abierta o cerrada)
     *
     * @return
     */
    public boolean getCama() {
        return cama;
    }

    /**
     * Introduce el estado de la cama teniendo en cuenta las restricciones
     *
     * @param mesa
     */
    public void setMesa(boolean mesa) {
        if (cama == false) {
            this.mesa = mesa;
        } else {
            System.out.println("No se puede abrir la mesa. La cama esta siendo usada.");
        }
    }

    /**
     * Obtiene el estado de la mesa teniendo en cuenta las restricciones
     *
     * @return
     */
    public boolean getMesa() {
        return mesa;
    }

    /**
     * El metodo dormir abre la cama para que puedan dormir los (maximo) 3
     * integrantes. No pueden mas porque la camper solo tiene 3 plazas. No se
     * tendran en cuenta las restrcciones, a diferencia de en la autocaravama y
     * caravana.
     */
    public void dormir() {
        if (super.getEncendido() == false) {
            System.out.println("*Abriendo cama*");
            cama = true;
        }
    }

    /**
     * Metodo comer, abre la mesa y simula una comida.
     */
    public void comer() {
        if (super.getEncendido() == false) {

            if (cama == true) {
                cama = false;
                mesa = true;
                System.out.println("Su cama esta plegada y su mesa lista para ser usada.");
            } else {
                mesa = true;
                System.out.println("Listo para comer.");

            }
        }
    }

    /**
     * Plegar el interior, este lo que este plegado, quitalo para poder
     * continuar el viaje.
     */
    public void plegarInterior() {
        if (super.getEncendido() == false) {
            cama = false;
            mesa = false;
            System.out.println("Se ha plegado el interior para poder usarlo como asientos.");
        }
    }

    /**
     * Redefinicion del metodo toString para que el objeto te devuelva una
     * cadena de caracteres personalizada
     *
     * @return el mensaje personalizado
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "Esta camper posee una mesa para poder comer. Al plegar esta, podemos extender una cama para 3 personas. Podemos acampar con vistas al mar en cualquier lugar del mundo.";
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
        camper c = (camper) o;
        return getPermisoCirculacion().getMatricula().equals(c.getPermisoCirculacion().getMatricula());
    }

    @Override
    public int compareTo(Object o) {
        camper ac = (camper)o;
        if (this.getPermisoCirculacion().getMatricula().compareTo(ac.getPermisoCirculacion().getMatricula()) > 0) {
            return 1;

        } else {
            return -1;
        }
    }

}
