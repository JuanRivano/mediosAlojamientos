package test;

import Modelo.DatosCliente;
import Modelo.Hotel;
import Modelo.TipoTemporada;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelShould {
    private static  Hotel h;

    @BeforeClass
    public static void setup() {
        DatosCliente d = new DatosCliente("17674005-1", "Juan");
        h = new Hotel(d, 20, 5, TipoTemporada.ALTA, 14300, false, true);
    }

    @Test
    public void retorna_el_valor_sub_total() {
        assertEquals(71500, h.subTotal());
    }

    @Test
    public void retorna_valor_adicional_fumador_desayuno() {
        h.setEsFumador(true);
        assertEquals(21450, h.adicional());
    }

    @Test
    public void retorna_valor_descuento_temmporada_baja() {
        h.setTipoTemporada(TipoTemporada.BAJA);
        assertEquals(17875, h.bonoDescuento());
    }

    @Test
    public void retorna_valor_descuento_temmporada_media() {
        h.setTipoTemporada(TipoTemporada.MEDIA);
        assertEquals(8938, h.bonoDescuento());
    }

    @Test
    public void retorna_valor_total_cancelar_temporada_media_con_desayuno(){
        h.setEsFumador(true);
        h.setTipoTemporada(TipoTemporada.MEDIA);
        assertEquals(84012, h.valorACancelar());
    }
    @Test
    public void retorna_valor_total_cancelar_temporada_baja_sin_desayuno(){
        h.setEsFumador(false);
        h.setTipoTemporada(TipoTemporada.BAJA);
        assertEquals(125125, h.valorACancelar());
    }
    @Test
    public void retorna_valor_total_cancelar_temporada_baja_con_desayuno(){
        h.setEsFumador(true);
        h.setTipoTemporada(TipoTemporada.BAJA);
        assertEquals(75075, h.valorACancelar());
    }
}
