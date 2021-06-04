package test;

import Modelo.Carpa;
import Modelo.DatosCliente;
import Modelo.TipoTemporada;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarpaShould {

    private Carpa c;

    @Before
    public void setup() {
        DatosCliente d = new DatosCliente("17674005-1", "Juan");
        c = new Carpa(d, 20, TipoTemporada.ALTA, 14300,5);

    }

    @Test
    public void retorna_el_valor_a_cancelar() {
        assertEquals(286000, c.valorACancelar());
    }
}