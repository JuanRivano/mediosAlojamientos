package Modelo;

import java.util.Locale;

public abstract class MedioAlojamiento {

    protected DatosCliente cliente;
    protected int cantidadNoches;
    protected TipoTemporada tipoTemporada;
    protected int valorBaseNoche;
    private final double DESCUENTOBAJA=0.25;
    private final double DESCUENTOMEDIA=0.125;

    public MedioAlojamiento() {
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public DatosCliente getCliente() {
        return cliente;
    }

    public MedioAlojamiento(DatosCliente cliente, int cantidadNoches, TipoTemporada tipoTemporada, int valorBaseNoche) {
        this.cliente = cliente;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
        this.valorBaseNoche =valorBaseNoche;
    }

    public void setTipoTemporada(TipoTemporada tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public int subTotal(){
        return valorBaseNoche*cantidadNoches;
    }

    public int bonoDescuento(){
        if (tipoTemporada.name().equalsIgnoreCase("baja")){
            return  (int) Math.round(subTotal()*DESCUENTOBAJA);
        }if(tipoTemporada.name().equalsIgnoreCase("media")){
            return (int) Math.round(subTotal()*DESCUENTOMEDIA);
        }
        return 0;
    }

    public abstract int valorACancelar();


}
