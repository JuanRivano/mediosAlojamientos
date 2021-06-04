package Modelo;

import static Vista.validaciones.formatPeso;

public class Hotel extends Hospederia {

    private final double ADICIONAL = 0.30;
    private boolean conDesayuno;

    public Hotel(){}

    public Hotel(DatosCliente cliente, int capacidad, int cantidadNoches, TipoTemporada tipoTemporada, int valorBaseNoche, boolean esFumador, boolean conDesayuno) {
        super(cliente, cantidadNoches, tipoTemporada, valorBaseNoche, esFumador, capacidad);
        this.conDesayuno = conDesayuno;
    }

    public int adicional() {
        return (conDesayuno && esFumador) ?(int) Math.round(this.subTotal() * ADICIONAL) : this.subTotal();
    }

    public int valorACancelar() {return subTotal() + adicional() - bonoDescuento();}

    @Override
    public String toString() {
        return "Tipo de alojamiento Hotel\n" +
                "Cliente : \n" + cliente.toString() +
                "Capacidad: " + capacidad + "\n" +
                "Cantidad de noches: " + cantidadNoches + "\n" +
                "Temporada: " + tipoTemporada + "\n" +
                "Valor base por noche: " + formatPeso(valorBaseNoche) + "\n" +
                "Cliente es fumador: " + ((esFumador) ? "Si" : "No")+ "\n" +
                "Con desayuno: " +  ((conDesayuno) ? "Si" : "No");
    }
}
