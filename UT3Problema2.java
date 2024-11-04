// Definición de tamaños
            int[] tamanosBusqueda = {1000, 10000, 100000, 1000000};
            int[] tamanosOrdenacion = {100, 1000, 10000, 100000};

            // Inicializar y rellenar arrays de búsqueda
            int[] arrayBusqueda1000 = new int[1000];
            int[] arrayBusqueda10000 = new int[10000];
            int[] arrayBusqueda100000 = new int[100000];
            int[] arrayBusqueda1000000 = new int[1000000];

            for (int j = 0; j < arrayBusqueda1000.length; j++) {
                arrayBusqueda1000[j] = j;
            }
            for (int j = 0; j < arrayBusqueda10000.length; j++) {
                arrayBusqueda10000[j] = j;
            }
            for (int j = 0; j < arrayBusqueda100000.length; j++) {
                arrayBusqueda100000[j] = j;
            }
            for (int j = 0; j < arrayBusqueda1000000.length; j++) {
                arrayBusqueda1000000[j] = j;
            }

            // Inicializar y rellenar arrays de ordenación
            int[] arrayOrdenacion100 = new int[100];
            int[] arrayOrdenacion1000 = new int[1000];
            int[] arrayOrdenacion10000 = new int[10000];
            int[] arrayOrdenacion100000 = new int[100000];

            for (int j = 0; j < arrayOrdenacion100.length; j++) {
                arrayOrdenacion100[j] = (int) (Math.random() * 100);
            }
            for (int j = 0; j < arrayOrdenacion1000.length; j++) {
                arrayOrdenacion1000[j] = (int) (Math.random() * 1000);
            }
            for (int j = 0; j < arrayOrdenacion10000.length; j++) {
                arrayOrdenacion10000[j] = (int) (Math.random() * 10000);
            }
            for (int j = 0; j < arrayOrdenacion100000.length; j++) {
                arrayOrdenacion100000[j] = (int) (Math.random() * 100000);
            }

            int buscar = -1; // Valor a buscar

            // --- Comparación de Búsqueda Lineal y Binaria ---
            System.out.println("\n-- Comparación de Búsqueda Lineal y Binaria --");

            // Búsqueda Lineal
            for (int i = 0; i < tamanosBusqueda.length; i++) {
                int[] array = null;
                if (tamanosBusqueda[i] == 1000) {
                    array = arrayBusqueda1000;
                } else if (tamanosBusqueda[i] == 10000) {
                    array = arrayBusqueda10000;
                } else if (tamanosBusqueda[i] == 100000) {
                    array = arrayBusqueda100000;
                } else if (tamanosBusqueda[i] == 1000000) {
                    array = arrayBusqueda1000000;
                }

                long tiempoInicial = System.currentTimeMillis();
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == buscar) {
                        break;
                    }
                }
                long tiempoEjecucion = System.currentTimeMillis() - tiempoInicial;
                System.out.println(String.format("Búsqueda lineal en array de tamaño %d tardó: %fms", array.length, (double) tiempoEjecucion));

                // Búsqueda Binaria
                tiempoInicial = System.currentTimeMillis();
                int izq = 0, der = array.length - 1, medio;
                while (izq <= der) {
                    medio = (izq + der) / 2;
                    if (array[medio] == buscar) {
                        break;
                    } else if (array[medio] < buscar) {
                        izq = medio + 1;
                    } else {
                        der = medio - 1;
                    }
                }
                tiempoEjecucion = System.currentTimeMillis() - tiempoInicial;
                System.out.println(String.format("Búsqueda binaria en array de tamaño %d tardó: %fms", array.length, (double) tiempoEjecucion));
                System.out.println("");
            }

            // --- Comparación de Algoritmos de Ordenación ---
            System.out.println("\n-- Comparación de Inserción Directa, Selección Directa, y Burbuja --");

            // Ordenación
            for (int i = 0; i < tamanosOrdenacion.length; i++) {
                int[] array = null;
                if (tamanosOrdenacion[i] == 100) {
                    array = arrayOrdenacion100;
                } else if (tamanosOrdenacion[i] == 1000) {
                    array = arrayOrdenacion1000;
                } else if (tamanosOrdenacion[i] == 10000) {
                    array = arrayOrdenacion10000;
                } else if (tamanosOrdenacion[i] == 100000) {
                    array = arrayOrdenacion100000;
                }

                // Inserción Directa
                long tiempoInicial = System.currentTimeMillis();
                for (int j = 1; j < array.length; j++) {
                    int key = array[j];
                    int k = j - 1;
                    while (k >= 0 && array[k] > key) {
                        array[k + 1] = array[k];
                        k--;
                    }
                    array[k + 1] = key;
                }
                long tiempoEjecucion = System.currentTimeMillis() - tiempoInicial;
                System.out.println(String.format("Inserción directa en array de tamaño %d tardó: %fms", array.length, (double) tiempoEjecucion));

                // Selección Directa
                array = null; // Volver a asignar el array para la selección
                if (tamanosOrdenacion[i] == 100) {
                    array = arrayOrdenacion100.clone();
                } else if (tamanosOrdenacion[i] == 1000) {
                    array = arrayOrdenacion1000.clone();
                } else if (tamanosOrdenacion[i] == 10000) {
                    array = arrayOrdenacion10000.clone();
                } else if (tamanosOrdenacion[i] == 100000) {
                    array = arrayOrdenacion100000.clone();
                }

                tiempoInicial = System.currentTimeMillis();
                for (int j = 0; j < array.length - 1; j++) {
                    int minIndex = j;
                    for (int k = j + 1; k < array.length; k++) {
                        if (array[k] < array[minIndex]) {
                            minIndex = k;
                        }
                    }
                    int temp = array[j];
                    array[j] = array[minIndex];
                    array[minIndex] = temp;
                }
                tiempoEjecucion = System.currentTimeMillis() - tiempoInicial;
                System.out.println(String.format("Selección directa en array de tamaño %d tardó: %fms", array.length, (double) tiempoEjecucion));

                // Intercambio Directo (Burbuja)
                array = null; // Volver a asignar el array para el burbuja
                if (tamanosOrdenacion[i] == 100) {
                    array = arrayOrdenacion100.clone();
                } else if (tamanosOrdenacion[i] == 1000) {
                    array = arrayOrdenacion1000.clone();
                } else if (tamanosOrdenacion[i] == 10000) {
                    array = arrayOrdenacion10000.clone();
                } else if (tamanosOrdenacion[i] == 100000) {
                    array = arrayOrdenacion100000.clone();
                }

                tiempoInicial = System.currentTimeMillis();
                for (int j = 0; j < array.length - 1; j++) {
                    for (int k = 0; k < array.length - j - 1; k++) {
                        if (array[k] > array[k + 1]) {
                            int temp = array[k];
                            array[k] = array[k + 1];
                            array[k + 1] = temp;
                        }
                    }
                }
                tiempoEjecucion = System.currentTimeMillis() - tiempoInicial;
                System.out.println(String.format("Intercambio directo (Burbuja) en array de tamaño %d tardó: %fms", array.length, (double) tiempoEjecucion));
                System.out.println("");
            }
