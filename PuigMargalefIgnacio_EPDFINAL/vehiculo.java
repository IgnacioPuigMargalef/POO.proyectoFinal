/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 * Clase vehiculo
 *
 * @author nacho
 */
public class vehiculo implements IVehiculo, Comparable {

    private PermisoCirculacion pc;
    private boolean encendido, luces;
    private int horaArranque;
    private int gasolina;
    public double velocidadActual;

    /**
     * Constructor de vehiculo - va a instanciar objetos de tipo vehiculo
     *
     * @param matricula cadena de caracteres con la info de la matricula
     * @param marcaYmodelo ejemplo: skodafabia
     * @param color string que indica el color del vehiculo
     * @param fechaPasarItv fecha en la que el vehiculo debe pasar la inspeccion
     * tecnica
     * @param dniDuenyo dni del duenyo del vehiculo
     * @param capacidadDeposito capacidad del deposito de gasolina del vehiculo
     */
    public vehiculo(String matricula, String marcaYmodelo, String color, int fechaPasarItv, String dniDuenyo, int capacidadDeposito) throws compruebaMatricula {

        pc = new PermisoCirculacion(matricula, marcaYmodelo, color, fechaPasarItv, dniDuenyo, capacidadDeposito);

    }

    public vehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Introducir la gasolina que hay en el vehiculo. Tiene en cuenta la
     * capacidad del deposito (viene en el permiso de circulacion del vehiculo)
     *
     * @param gasolina cantidad de gasolina en el deposito
     */
    @Override
    public void setGasolina(int gasolina) {
        if (pc.getCapacidadDeposito() < (this.gasolina + gasolina)) {
            gasolina = (this.gasolina + gasolina) - pc.getCapacidadDeposito(); //Reutilizo la variable gasolina para indicar la cantidad que se ha excedido//
            System.out.println("Usted ha excedido el limite del deposito " + gasolina + " litros. Vuelve a intentarlo");
        } else {
            this.gasolina = gasolina;
        }

    }

    /**
     * Obtener la gasolina actual del vehiculo
     *
     * @return atributo gasolina
     */
    @Override
    public int getGasolina() {
        return gasolina;

    }

    /**
     * Introducir si las luces estan encendidas (true) o apagadas (false). Tiene
     * en cuenta la hora, ya que las luces se suelen encender cuando oscurece, y
     * encenderlas durante el dia (a no ser que estemos pasando por un tunel),
     * es un malgasto de bateria. Ademas, tiene en cuenta si el coche esta
     * encendido, ya que vamos a encender las luces con el coche encendido.
     *
     * @param luces booleano que indica si las luces estan encendidas
     */
    @Override
    public void setLuces(boolean luces) {
        if (horaArranque > 19 && horaArranque < 8 && luces == true) {
            this.luces = luces;
        } else if (horaArranque > 19 && horaArranque < 8 && luces == false) {
            System.out.println("Ha apagado las luces. Si va a seguir conduciendo, se recomienda llevarlas encendidas.");
            this.luces = false;
        } else if (horaArranque < 19 && horaArranque > 8 && luces == true) {
            System.out.println("Con el objetivo de ahorrar bateria, hemos procedido al apagado automatico de las luces.");
            this.luces = false;
        } else {
            System.out.println("Se han apagado las luces.");
            this.luces = false;
        }

    }

    /**
     * Obtener si la luces estan encendidas o apagadas
     *
     * @return luces (booleano)
     */
    @Override
    public boolean getLuces() {
        return luces;
    }

    /**
     * Introduce al atributo encendido si lo esta o no el vehiculo
     *
     * @param encendido booleando que indica si esta encendido
     */
    @Override
    public void setEncendido(boolean encendido) {
        if (this.gasolina > 0) {
            this.encendido = encendido;
            System.out.println("Se ha encendido el coche.");
        } else {
            System.out.println("Deposito vacio, echar gasolina!");
        }

    }

    /**
     * Obtener si el coche esta encendido
     *
     * @return encendido (booleano)
     */
    @Override
    public boolean getEncendido() {
        return encendido;
    }

    /**
     * Introducir la hora de arranque del vehiculo. Asi, controlaremos cuando
     * deben estar encendidas las luces y cuando no.
     *
     * @param hora hora de encendido
     */
    @Override
    public void setHoraArranque(int hora) {
        horaArranque = hora;
    }

    /**
     * Obtener la hora a la que el vehiculo fue arrancado
     *
     * @return horaArranque (atributo entero)
     */
    @Override
    public int getHoraArranque() {
        return horaArranque;
    }

    /**
     * Este metodo hace que el vehiculo avance x kilometros a y velocidad
     * constante. Tiene en cuenta la gasolina que hay, y calcula una
     * aproximacion para mostrar si tendriamos suficiente gaosolina para avanzar
     * esos x kilometros. Tambien controla la velocidad maxima, la cual sera 125
     * para la clase vehiculo
     *
     * @param km distancia entera
     * @param velocidad velocidad constante y entera
     */
    @Override
    public void avanzar(int km, int velocidad) {
        int repostar;
        if (km / 12 > gasolina) {
            repostar = km / 12 - gasolina;
            System.out.println("Antes de salir, reposte minimo " + repostar + " litros en la gasolinera mas cercana.");
        } else {
            System.out.println("*Conduciendo " + km + " kilometros hasta su destino*");
        }
        if (velocidad > 0 && velocidad <= 125) {
            this.velocidadActual = (double) velocidad;
            System.out.println("Usted ha adquirido una velocidad de " + velocidad + " km/hora.");
        } else {
            System.out.println("Velocidad no valida!");
        }
    }

    /**
     * Metodo para disminuir el atributo velocidad del vehiculo
     *
     * @param deceleracion parametro que va a tomar valores positivoa
     */
    @Override
    public void frenar(int deceleracion) {
        if (velocidadActual + (double) deceleracion < 0) {
            velocidadActual = 0;
            System.out.println("Usted ha parado el vehiculo");
        } else {
            velocidadActual = velocidadActual + (double) deceleracion;
            System.out.println("Su nueva velocidad es: " + velocidadActual + " km/h");
        }

    }

    /**
     * Obtener el permiso de circulacion (en un hipotetico caso de que nos
     * parase la policia, o para usarlo en alguna clase)
     *
     * @return pc, que es una variable (atributo de esta clase) de tipo
     * permisoDeCirculacion
     */
    public PermisoCirculacion getPermisoCirculacion() {
        return pc;
    }

    /**
     * Redefinicion del metodo toString. Si printamos por pantalla un objeto de
     * tipo vehiculo, obtendremos el mensaje dado en el return del metodo.
     *
     * @return un mensaje
     */
    @Override
    public String toString() {
        return "Esto es un vehiculo, cuya matricula es " + pc.getMatricula() + ".";
    }

    /**
     * Redefinicion del metodo equals. Nos servira para comparar dos objetos. En
     * este caso, la unica forma de comparar vehiculos es por su matricula, ya
     * que esta es unica.
     *
     * @param o objeto
     * @return true si son iguales, false si son diferentes
     */
    @Override
    public boolean equals(Object o) {
        vehiculo v = (vehiculo) o;
        return pc.getMatricula().equals(v.pc.getMatricula());
    }

    @Override
    public int compareTo(Object o) {
        vehiculo v = (vehiculo) o;
        if (this.pc.getMatricula().compareTo(v.getPermisoCirculacion().getMatricula()) > 0) {
            return 1;

        } else {
            return -1;
        }
    }

}
