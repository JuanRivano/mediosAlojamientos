package test;

import org.junit.Test;

import static Vista.validaciones.*;
import static org.junit.Assert.*;

public class validacionesShould {


    @Test
    public void retorna_medio_alojamiento_no_valido() {
        assertFalse(validarMedioAlojamiento("noExiste"));
    }


    @Test
    public void retorna_medio_alojamiento_valido() {
        assertTrue(validarMedioAlojamiento("CABAÑA"));
    }

    @Test
    public void retorna_numero_formateado_peso() {
        assertEquals("$500.000",formatPeso(500000));
    }

    @Test
    public void retorna_true_a_una_entrada_SI() {
        assertTrue(esSIoNo("si"));
    }

    @Test
    public void retorna_true_a_una_entrada_NO() {
        assertTrue(esSIoNo("NO"));
    }

    @Test
    public void retorna_true_a_rut_valido() {
        assertTrue(validarRut("17674005-1"));
    }

    @Test
    public void retorna_false_a_rut_valido() {
        assertFalse(validarRut("1767005-1"));
    }
}