package Controladora;

import Modelo.*;
import Vista.MedioAlojamientoEnum;
import java.util.Scanner;
import static Vista.validaciones.*;
import static Vista.validaciones.esSIoNo;

public class IngresoRegistro {
    private static Scanner entradaEscaner = new Scanner(System.in);
    private static String capacidad;
    private static String cantidadNoches;
    private static TipoTemporada tipoTemporada;
    private static String tipo;
    private static String valorBaseNoche;

    /*** llama a los metodos para generar el nuevo registro tipo CARPA/CABAÑA/HOTEL ***/
    public static void ingresarMedioAlojamiento(MediosAlojamientos alojamiento) {
        DatosCliente cliente;
        MedioAlojamientoEnum medioAloj;
        String dato;
        cliente = ingresarDatosCliente(alojamiento);
        do {
            System.out.println("Indique tipo de alojamiento Carpa/Cabaña/Hotel");
            dato = entradaEscaner.nextLine().toUpperCase().trim();
        } while (!validarMedioAlojamiento(dato));
        medioAloj = MedioAlojamientoEnum.valueOf(dato);
        if (medioAloj == MedioAlojamientoEnum.CARPA) {
            alojamiento.ingresarRegistroEnLista(carpa(cliente));
        } else if (medioAloj == MedioAlojamientoEnum.CABAÑA) {
            alojamiento.ingresarRegistroEnLista(cabagna(cliente));
        } else {
            alojamiento.ingresarRegistroEnLista(hotel(cliente));
        }
    }

    /*** Solicita informacion por consola y  retorna objeto de tipo Datos Cliente ***/
    private static DatosCliente ingresarDatosCliente(MediosAlojamientos alojamiento) {
        String nombre;
        String rut;
        do {
            do {
                System.out.println("Ingrese su nombre");
                nombre = entradaEscaner.nextLine();
            } while (validarNombre(nombre));

            do {
                System.out.println("Ingrese su rut");
                rut = entradaEscaner.nextLine();
            } while (!validarRut(rut));

        } while (alojamiento.buscarPorRut(rut));
        return new DatosCliente(rut, nombre);
    }

    /*** Solicita informacion por consola de Medios de alojamiento ***/
    private static void medioAlojamiento() {
        do {
            System.out.println("cantidad Noches: ");
            cantidadNoches = entradaEscaner.nextLine();
        } while (isNumeric(cantidadNoches, 20));

        do {
            System.out.println("Temporada Alta, Media, Baja:");
            tipo = entradaEscaner.nextLine().toUpperCase().trim();
        } while (!validarTipoTemporada(tipo));
        tipoTemporada = TipoTemporada.valueOf(tipo);
        do {
            System.out.println("Valor Base noche: ");
            valorBaseNoche = entradaEscaner.nextLine();
        } while (isNumeric(valorBaseNoche, 100000));
    }

    /*** Solicita informacion por consola y  retorna objeto de tipo Carpa ***/
    private static Carpa carpa(DatosCliente cliente) {
        String cantidadPersonas;
        medioAlojamiento();

        do {
            System.out.println("cantidad de personas: ");
            cantidadPersonas = entradaEscaner.nextLine();
        } while (isNumeric(cantidadPersonas, 5));
        return new Carpa(cliente, Integer.parseInt(cantidadNoches), tipoTemporada,
                Integer.parseInt(valorBaseNoche), Integer.parseInt(cantidadPersonas));
    }

    /*** Solicita informacion por consola y  retorna objeto de tipo Cabaña ***/
    private static Cabagna cabagna(DatosCliente cliente) {
        boolean esFumador;
        boolean esChimenea;
        String fumador;
        String chimenea;
        medioAlojamiento();
        do {
            System.out.println("Ingrese Capacidad: ");
            capacidad = entradaEscaner.nextLine();
        } while (isNumeric(capacidad, 10));
        do {
            System.out.println("Es Fumador: ");
            fumador = entradaEscaner.nextLine();
        } while (!esSIoNo(fumador));
        esFumador = (fumador.equalsIgnoreCase("si"));
        do {
            System.out.println("Tiene chimenea: ");
            chimenea = entradaEscaner.nextLine();
        } while (!esSIoNo(fumador));
        esChimenea = (chimenea.equalsIgnoreCase("si"));
        return new Cabagna(cliente, Integer.parseInt(cantidadNoches), tipoTemporada,
                Integer.parseInt(valorBaseNoche), esFumador, Integer.parseInt(capacidad), esChimenea);
    }

    /*** Solicita informacion por consola y  retorna objeto de tipo Hotel ***/
    private static Hotel hotel(DatosCliente cliente) {
        boolean conDesayuno;
        boolean esFumador;
        String desayuno;
        String fumador;
        medioAlojamiento();
        do {
            System.out.println("Ingrese Capacidad: ");
            capacidad = entradaEscaner.nextLine();
        } while (isNumeric(capacidad, 10));
        do {
            System.out.println("Es Fumador: ");
            fumador = entradaEscaner.nextLine();
        } while (!esSIoNo(fumador));
        esFumador = (fumador.equalsIgnoreCase("si"));
        do {
            System.out.println("Con desayuno: ");
            desayuno = entradaEscaner.nextLine();
        } while (!esSIoNo(desayuno));
        conDesayuno = (desayuno.equalsIgnoreCase("si"));
        return new Hotel(cliente, Integer.parseInt(capacidad), Integer.parseInt(cantidadNoches), tipoTemporada,
                Integer.parseInt(valorBaseNoche), esFumador, conDesayuno);
    }

}

