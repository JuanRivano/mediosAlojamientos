package Modelo;

import static Vista.validaciones.formatPeso;

public class Carpa extends MedioAlojamiento {

    private int cantidadDePersonas;

    public Carpa(){}

    public Carpa(DatosCliente cliente, int cantidadNoches, TipoTemporada tipoTemporada, int valorBaseNoche, int cantidadDePersonas) {
        super(cliente, cantidadNoches, tipoTemporada, valorBaseNoche);
        this.cantidadDePersonas = cantidadDePersonas;
    }


    public  int valorACancelar(){
           return (subTotal()-bonoDescuento());
    }


    @Override
    public String toString() {
        return "Tipo de alojamiento Carpa\n" +
                "Cliente : \n" + cliente.toString() +
                "Cantidad de personas: " + cantidadDePersonas +"\n"+
                "Cantidad de noches: " + cantidadNoches  +"\n"+
                "Temporada: "+ tipoTemporada  +"\n"+
                "Valor base por noche: " + formatPeso(valorBaseNoche);
    }
}
