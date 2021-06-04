package Modelo;

public class DatosCliente {

    private String rut;
    private String nombre;

    public DatosCliente(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    @Override
    public String toString() {
        return  "rut cliente: " + rut + "\n" +
                "nombre cliente: " + nombre + "\n";
    }
}

