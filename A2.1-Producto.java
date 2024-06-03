package Avance2;

public class Producto {
    private String nombre;
    private int precio;
    private String marca;
    private int codigo;

    public Producto(String nombre, int precio, String marca, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getCodigo() {
        return codigo;
    }
}
