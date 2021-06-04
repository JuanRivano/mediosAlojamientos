package Modelo;

public abstract class Hospederia extends MedioAlojamiento {
    protected boolean esFumador;
    protected int capacidad;

    public Hospederia(){}

    public Hospederia(DatosCliente cliente, int cantidadNoches, TipoTemporada tipoTemporada, int valorBaseNoche, boolean esFumador, int capacidad) {
        super(cliente, cantidadNoches, tipoTemporada, valorBaseNoche);
        this.esFumador = esFumador;
        this.capacidad = capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }
}
