package test;

import Controladora.MediosAlojamientos;
import Modelo.Carpa;
import Modelo.DatosCliente;
import Modelo.Hotel;
import Modelo.TipoTemporada;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class pruebasEndToEnd {

    private static  MediosAlojamientos med = new MediosAlojamientos();
    private static  Hotel hft;
    private static  Hotel hff;
    private static  Hotel htt;
    private static  Carpa c;

    @BeforeClass
    public static void setup() {

        DatosCliente dh = new DatosCliente("17674005-1", "Juan");
        hft = new Hotel(dh, 20, 5, TipoTemporada.ALTA, 15000, false, true);
        med.ingresarRegistroEnLista(hft);
        dh = new DatosCliente("1767400-5", "Juan");
        hff = new Hotel(dh, 20, 5, TipoTemporada.MEDIA, 20000, false, false);
        med.ingresarRegistroEnLista(hff);
        dh = new DatosCliente("9666516-4", "pepe");
        htt = new Hotel(dh, 20, 5, TipoTemporada.BAJA, 14300, true, true);
        med.ingresarRegistroEnLista(htt);

    }
    @Test
    public void opciones_menu() {
        med.totalAdicional();
    }
}
