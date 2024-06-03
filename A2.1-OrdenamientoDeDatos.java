package Avance2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenamientoDeDatos {

    public static void ordenarPorNombre(List<Producto> productos) {
        Collections.sort(productos, Comparator.comparing(Producto::getNombre));
    }

    public static void ordenarPorPrecio(List<Producto> productos) {
        Collections.sort(productos, Comparator.comparingInt(Producto::getPrecio));
    }

    public static void ordenarPorMarca(List<Producto> productos) {
        Collections.sort(productos, Comparator.comparing(Producto::getMarca));
    }

    public static void ordenarPorCodigo(List<Producto> productos) {
        Collections.sort(productos, Comparator.comparingInt(Producto::getCodigo));
    }
}
