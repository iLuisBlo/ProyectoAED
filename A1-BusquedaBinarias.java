package Avance1;

public class BusquedaBinarias {
    public static int busquedaBinaria(String[] array, String valorBuscado) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = array[medio].compareTo(valorBuscado);
            
            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }
}
