package Avance1;

public class QuickSortString {
    public static void quickSort(String[] array, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(array, inicio, fin);
            quickSort(array, inicio, indiceParticion - 1);
            quickSort(array, indiceParticion + 1, fin);
        }
    }

    private static int particion(String[] array, int inicio, int fin) {
        String pivote = array[fin];
        int indiceMenor = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (array[j].compareTo(pivote) <= 0) {
                indiceMenor++;
                intercambiar(array, indiceMenor, j);
            }
        }
        intercambiar(array, indiceMenor + 1, fin);
        return indiceMenor + 1;
    }

    private static void intercambiar(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
