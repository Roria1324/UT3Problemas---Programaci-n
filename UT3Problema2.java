//"author Alexandro Stefan Dezso Florea
public class UT3Problema2 {
    public static void main(String[] args) {
        int[] tamanosBusqueda = {1000, 10000, 100000, 1000000};

        System.out.println("Pruebas de búsqueda:");
        for (int tamano : tamanosBusqueda) {
            // Generar array aleatorio para cada prueba de búsqueda
            int[] array = new int[tamano];
            for (int i = 0; i < tamano; i++) {
                array[i] = (int) (Math.random() * 100000);
            }

            // Ordenar array para búsqueda binaria (usando ordenación por inserción)
            for (int i = 1; i < array.length; i++) {
                int clave = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > clave) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = clave;
            }

            // Búsqueda Lineal (promedio de 100 búsquedas)
            long inicio = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                int encontradoLineal = -1;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == -1) { // Valor no existente para peor caso
                        encontradoLineal = i;
                        break;
                    }
                }
            }
            long tiempoBusquedaLineal = (System.nanoTime() - inicio) / 100; // Promedio en nanosegundos

            // Búsqueda Binaria (promedio de 100 búsquedas)
            inicio = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                int inicioBinario = 0, finBinario = array.length - 1, medio = 0;
                boolean encontradoBinario = false;
                while (inicioBinario <= finBinario) {
                    medio = inicioBinario + (finBinario - inicioBinario) / 2;
                    if (array[medio] == -1) { // Valor no existente
                        encontradoBinario = true;
                        break;
                    } else if (array[medio] < -1) {
                        inicioBinario = medio + 1;
                    } else {
                        finBinario = medio - 1;
                    }
                }
            }
            long tiempoBusquedaBinaria = (System.nanoTime() - inicio) / 100; // Promedio en nanosegundos

            System.out.printf("Array de %d elementos: Búsqueda Lineal = %d ms, Búsqueda Binaria = %d ms%n",
                    tamano, tiempoBusquedaLineal, tiempoBusquedaBinaria);
        }
    }
}
