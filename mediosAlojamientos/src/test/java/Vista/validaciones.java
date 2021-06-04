package Vista;


import Modelo.TipoTemporada;;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class validaciones {

    public static boolean validarNombre(String nombre) {
        boolean estado = false;
        Pattern pat = Pattern.compile("^[a-zA-Z]{3,10}$");
        Matcher mat = pat.matcher(nombre);
        if (!mat.matches()) {
            System.out.println("Error al ingresar Nombre (solo letras sin espacios largo minimo 3 maximo 10)");
            estado = true;
        }
        return estado;
    }

    public static boolean isNumeric(String numero, int capacidad) {
        try {
            int numInteger=Integer.parseInt(numero);
            if (numInteger > 0 && numInteger <= capacidad) {
                return false;
            } else {
                System.out.println("numero fuera de rango 1 - "+capacidad);
                return true;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("No numerico");
            return true;
        }

    }
    public static int validarOpcion(String opcion) {
        return !isNumeric(opcion,9) ? Integer.parseInt(opcion) : 10;
    }

    public static boolean validarMedioAlojamiento(String m) {
        try {
            MedioAlojamientoEnum.valueOf(m);
            return true;
        } catch (Exception e) {
            System.out.println("Ingrese uno medio de alojamiento valido");
        }
        return false;
    }

    public static boolean validarTipoTemporada(String m) {
        try {
            TipoTemporada.valueOf(m);
            return true;
        } catch (Exception e) {
            System.out.println("Ingrese uno tipo Temporada");
        }
        return false;
    }

        public static boolean validarRut(String rut) {
            boolean validacion = false;
            try {
                rut =  rut.toUpperCase();
                rut = rut.replace(".", "");
                rut = rut.replace("-", "");
                int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
                char dv = rut.charAt(rut.length() - 1);
                int m = 0, s = 1;
                for (; rutAux != 0; rutAux /= 10) {
                    s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
                }
                if (dv == (char) (s != 0 ? s + 47 : 75)) {
                    validacion = true;
                }
            } catch (Exception ignored) {
            }
            if(validacion){
                return true;
            }
            System.out.println("Rut invalido favor ingrese rut correcto");
            return false;
        }

    public static boolean esSIoNo (String respuesta){
        return (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no"));
    }

    public static String formatPeso(int valor){
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        return defaultFormat.format(valor).replace("Ch","");
    }

    public static void salirAplicaicion(){
        try {
            System.out.print("Saliendo de la aplicacion");
            for  (int i = 0; i < 5; i++ ){
                System.out.print(".");
                Thread.sleep(300);
            }
                System.exit(0);
        }catch(Exception ignored){}
    }
}
