package Modelo;

import static Vista.validaciones.formatPeso;

public class Cabagna extends Hospederia {
    private boolean chimenea;
    private final double INCREMENTO= 1.18;
    private final int CAPACIDAD=5;

    public Cabagna(){}

    public Cabagna(DatosCliente cliente, int cantidadNoches, TipoTemporada tipoTemporada, int valorBaseNoche, boolean esFumador, int capacidad, boolean chimenea) {
        super(cliente, cantidadNoches, tipoTemporada, valorBaseNoche, esFumador, capacidad);
        this.chimenea = chimenea;
    }

    @Override
    public int valorACancelar() {
        return subTotal()-bonoDescuento();
    }


    public void incrementaValorBase(){
        if(capacidad>CAPACIDAD)valorBaseNoche*=INCREMENTO;
    }

    @Override
    public String toString() {
        return "Tipo de alojamiento Cabaña\n" +
                "Cliente : \n" + cliente.toString() +
                "Capacidad: " + capacidad + "\n"+
                "Cantidad de noches: " + cantidadNoches  +"\n"+
                "Temporada: "+ tipoTemporada  +"\n"+
                "Valor base por noche: " + formatPeso(valorBaseNoche)+"\n"+
                "Tiene chimenea: " + ((chimenea)?"Si":"No") +"\n"+
                "Cliente es fumador: " + ((esFumador)?"Si":"No");

    }
}
