package Controladora;

import Modelo.Cabagna;
import Modelo.Carpa;
import Modelo.Hotel;
import Modelo.MedioAlojamiento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static Vista.validaciones.validarMedioAlojamiento;
import static Vista.validaciones.validarRut;
import static Vista.validaciones.formatPeso;

public class MediosAlojamientos {

    private final ArrayList<MedioAlojamiento> listaAlojamientos = new ArrayList<MedioAlojamiento>();
    private static final Scanner entradaEscaner = new Scanner(System.in);

    /*** Ingresa el registro creado de tipo MedioAlojamiento en la lista ***/
    public void ingresarRegistroEnLista(MedioAlojamiento alojamiento) {
        listaAlojamientos.add(alojamiento);
        System.out.println("Se ingresa registro " + alojamiento.getClass().getName());
    }

    /*** Imprime la informacion de la lista invocando  toString sobrescrito en las clases ***/
    public void listarDatosAlojamientos() {
        for (MedioAlojamiento a : listaAlojamientos) {
            System.out.println(a.toString());
        }
    }

    /*** Busca registro por rut en la lista  e imprime el toString de la clase  ***/
    public void buscarPorRut() {
        String rut;
        do {
            System.out.println("Ingrese rut para buscar: ");
            rut = entradaEscaner.nextLine();
        } while (!validarRut(rut));
        rut = rut.replace(".", "").replace("-", "");
        for (MedioAlojamiento a : listaAlojamientos) {
            if ((a.getCliente().getRut())
                    .replace(".", "")
                    .replace("-", "")
                    .equalsIgnoreCase(rut)) {
                System.out.println(a.toString());
            }
        }
        System.out.println("No existe Rut " + rut);
    }

    /*** Retorna True si el rut ya esta en la lista ***/
    public boolean buscarPorRut(String rut) {
        rut = rut.replace(".", "").replace("-", "");
        for (MedioAlojamiento a : listaAlojamientos) {
            if ((a.getCliente().getRut())
                    .replace(".", "")
                    .replace("-", "")
                    .equalsIgnoreCase(rut)) {
                System.out.println("rut " + rut + " ya existe ingrese otro");
                return true;
            }
        }
        return false;
    }

    /*** Recorre lista y suma aquellos valores ***/
    public void totalAdicional() {
        int totalAdicional = 0;
        for (MedioAlojamiento a : listaAlojamientos) {
            if (a instanceof Hotel) {
                totalAdicional += ((Hotel) a).adicional();
            }
        }
        System.out.println("El Total de cobro adicional es " + formatPeso(totalAdicional));
    }

    /*** Recorre lista y suma aquellos valores e imprime el total bono descuento ***/
    public void totalBonoDescuento() {
        int BonoDescuento = 0;
        for (MedioAlojamiento a : listaAlojamientos) {
            BonoDescuento += a.bonoDescuento();
        }
        System.out.println("El total en bonos de descuento es: " + formatPeso(BonoDescuento));
    }

    /*** pide un tipo de alojamniento e imprime la cantidad de alojamientos de este tipo ***/
    public void cantidadMediosAlojamiento() {
        Map<String, MedioAlojamiento> map = new HashMap<String, MedioAlojamiento>();
        map.put("CARPA", new Carpa());
        map.put("CABAÑA", new Cabagna());
        map.put("HOTEL", new Hotel());
        int cantidadAlojamiento = 0;
        String dato;
        do {
            System.out.println("Indique tipo de alojamiento Carpa/Cabaña/Hotel");
            dato = entradaEscaner.nextLine().toUpperCase();
        } while (!validarMedioAlojamiento(dato));
        MedioAlojamiento c = map.get(dato);
        for (MedioAlojamiento a : listaAlojamientos) {
            if (a.getClass() == c.getClass()) {
                cantidadAlojamiento += 1;
            }
        }
        System.out.println("La cantidad de alojamiento de tipo " + dato +" es "+ cantidadAlojamiento);
    }

    /*** Consulta por un rut si este existe e imprime el valor del metodo valor a cancelar***/
    public void valorCancelarPorUncliente() {
        String rut;
        do {
            System.out.println("Ingrese rut para buscar: ");
            rut = entradaEscaner.nextLine();
        } while (!validarRut(rut));
        rut = rut.replace(".", "").replace("-", "");
        for (MedioAlojamiento a : listaAlojamientos) {
            if ((a.getCliente().getRut())
                    .replace(".", "")
                    .replace("-", "")
                    .equalsIgnoreCase(rut)) {
                System.out.println("Monto a Cancelar por el cliente rut " + rut + " es " + formatPeso(a.valorACancelar()));
            }
        }
        System.out.println("$0");
    }

    /*** Se aplica el incremento a lo objetos de tipo Cabana  indicando a los rut que se les aplico***/
    public void AplicarIncrementoValorBase() {
        for (MedioAlojamiento a : listaAlojamientos) {
            if (a instanceof Cabagna) {
                ((Cabagna) a).incrementaValorBase();
                System.out.println("Se aumento en un 18% la cabaña arrendada por " + a.getCliente().getRut());
            }
        }
    }
}

