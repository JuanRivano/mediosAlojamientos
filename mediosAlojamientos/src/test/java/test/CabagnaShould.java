package test;

import Modelo.Cabagna;
import Modelo.DatosCliente;
import Modelo.TipoTemporada;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabagnaShould {

    private Cabagna c;

    @Before
    public void setup() {
        DatosCliente d = new DatosCliente("17674005-1", "Juan");
        c = new Cabagna(d, 6, TipoTemporada.ALTA, 14300, false,6, false);

    }

    @Test
    public void retorna_el_incremento_valor_base_capacidad_mayor_a_5() {
        c.incrementaValorBase();
        assertEquals(16874, c.getValorBaseNoche());
    }

    @Test
    public void retorna_el_incremento_valor_base_capacidad_menor_a_5() {
        c.setCapacidad(5);
        c.incrementaValorBase();
        assertEquals(14300, c.getValorBaseNoche());
    }
    @Test
    public void retorna_el_valor_a_cancelar_mayor_a_5() {
        c.setCapacidad(6);
        assertEquals(85800, c.valorACancelar());
    }
    @Test
    public void retorna_el_valor_a_cancelar_igual_a_5() {
        c.setCapacidad(5);
        assertEquals(85800, c.valorACancelar());
    }
}