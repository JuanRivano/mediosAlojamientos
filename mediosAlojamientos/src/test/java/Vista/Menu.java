package Vista;


import Controladora.IngresoRegistro;
import Controladora.MediosAlojamientos;
import java.util.Scanner;
import static Vista.validaciones.*;

public class Menu {
    private static Scanner entradaEscaner = new Scanner(System.in);
    private static MediosAlojamientos alojamiento = new MediosAlojamientos();

    /*** menu con las opciones a las que el operario tiene acceso ***/
    public static void menuPrincipal() {
        boolean registroIngresado = false;
        while (true) {
            int opcion;
            listaMenu();
            opcion = validarOpcion(entradaEscaner.nextLine().toUpperCase());
            switch (opcion) {
                case 1:
                    IngresoRegistro.ingresarMedioAlojamiento(alojamiento);
                    registroIngresado = true;
                    break;
                case 2:
                    if (registroIngresado) {alojamiento.listarDatosAlojamientos();}
                    else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 3:
                    if (registroIngresado) {alojamiento.buscarPorRut();
                    }else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 4:
                    if (registroIngresado) {alojamiento.totalAdicional();
                    } else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 5:
                    if (registroIngresado) {alojamiento.totalBonoDescuento();
                    }else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 6:
                    if (registroIngresado){alojamiento.cantidadMediosAlojamiento();
                    }else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 7:
                    if (registroIngresado){alojamiento.valorCancelarPorUncliente();
                    }else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 8:
                    if (registroIngresado) {alojamiento.AplicarIncrementoValorBase();}
                    else {System.out.println("Ingrese un registro en la opcion 1");}
                    break;
                case 9:
                    salirAplicaicion();
                    break;
                default:
                    break;
            }
        }
    }

    private static void listaMenu(){
        System.out.println("Ingrese una Opción");
        System.out.println("1.- Ingresar Medio de Alojamiento");
        System.out.println("2.- Mostrar medios de alojamiento");
        System.out.println("3.- Datos de un cliente");
        System.out.println("4.- Total adicional");
        System.out.println("5.- Total bono descuento");
        System.out.println("6.- Cantidad medios de alojamiento");
        System.out.println("7.- Valor a cancelar por un cliente");
        System.out.println("8.- Aplicar incremento del valor base");
        System.out.println("9.- Salir");
        System.out.println("Opcion: ");
    }
}





