//@author Alexandro Stefan Dezso Florea

import java.util.Scanner;

public class UT3Prolema3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("-Introsuzca fila/anchura: ");
        int filasAnchura = input.nextInt();
        System.out.println("");
        int[][] matriz = new int[filasAnchura][filasAnchura];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) Math.round(Math.random());
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        int contadorLineaUno, contadorColumnaUno, contadorLineaCero, contadorColumnaCero, lineaUno = 0, lineaCero = 0, columnaUno = 0, columnaCero = 0, indexLineaUno = -1, indexColumnaUno = -1, indexLineaCero = -1, indexColumnaCero = -1, maxUnosLineas = 0, maxCerosLineas = 0, maxUnoColumna = 0, maxCerosColumna = 0;
        boolean simetrico = true, unosMaxLinea = false, cerosMaxLinea = false, unosMaxColumna = false, cerosMaxColumna = false;
        int[] cantidadUnosPorFila = new int[matriz.length];
        int[] cantidadCerosPorFila = new int[matriz.length];
        int[] cantidadUnosPorColumna = new int[matriz.length];
        int[] cantidadCerosPorColumna = new int[matriz.length];
        
        for (int i = 0; i < matriz.length; i++) {
            contadorLineaUno = 0;
            contadorColumnaUno = 0;
            contadorLineaCero = 0;
            contadorColumnaCero = 0;

            for (int j = 0; j < matriz[i].length; j++) {
                
                if (matriz[i][j] == 1) {
                    ++contadorLineaUno;
                }
                if (matriz[j][i] == 1) {
                    ++contadorColumnaUno;
                }
                if (matriz[i][j] == 0) {
                    ++contadorLineaCero;
                }
                if (matriz[j][i] == 0) {
                    ++contadorColumnaCero;
                }
                
            }
            cantidadUnosPorFila[i] = contadorLineaUno;
            cantidadCerosPorFila[i] = contadorLineaCero;
            cantidadUnosPorColumna[i] = contadorColumnaUno;
            cantidadCerosPorColumna[i] = contadorColumnaCero;
            
            if (contadorLineaUno >= lineaUno) {
                lineaUno = contadorLineaUno;
                indexLineaUno = i;
            }
            if (contadorLineaCero >= lineaCero) {
                lineaCero = contadorLineaCero;
                indexLineaCero = i;
            }
            if (contadorColumnaUno >= columnaUno) {
                columnaUno = contadorColumnaUno;
                indexColumnaUno = i;
            }
            if (contadorColumnaCero >= columnaCero) {
                columnaCero = contadorColumnaCero;
                indexColumnaCero = i;
            }
            if (contadorLineaUno > maxUnosLineas) {
                maxUnosLineas = contadorLineaUno;
            }
            
            if (contadorLineaCero > maxCerosLineas) {
                maxCerosLineas = contadorLineaCero;
            }
            
            if (contadorColumnaUno > maxUnoColumna) {
                maxUnoColumna = contadorColumnaUno;
            }
            
            if (contadorColumnaCero > maxCerosColumna) {
                maxCerosColumna = contadorColumnaCero;
            }
            
        }

        if (indexLineaUno != -1) {
            System.out.printf("\n-Fila %d mayor de 1s\n", indexLineaUno);
        }
        if (indexColumnaUno != -1) {
            System.out.printf("-Columna %d mayor de 1s\n", indexColumnaUno);
        }
        if (lineaCero == matriz.length) {
            System.out.printf("-Fila %d solo tiene 0s\n", indexLineaCero);
        } else {
            System.out.println("-No hay filas enteras de 0s");
        }
        if (columnaCero == matriz.length) {
            System.out.printf("-Columna %d solo tiene 0s\n", indexColumnaCero);
        } else {
            System.out.println("-No hay columnas enteras de 0s");
        }
        if (lineaUno == matriz.length) {
            System.out.printf("-Fila %d con todo 1s\n", indexLineaUno);
        } else {
            System.out.println("-No hay filas enteras de 1s");
        }
        if (columnaUno == matriz.length) {
            System.out.printf("-Columna %d con todo 1s\n", indexColumnaUno);
        } else {
            System.out.println("-No hay columnas enteras de 1s");
        }

        for (int i = 0; i < cantidadUnosPorFila.length; i++) {
            if (cantidadUnosPorFila[i] == maxUnosLineas) { 
                for (int j = i + 1; j < cantidadUnosPorFila.length; j++) {
                    if (cantidadUnosPorFila[j] == maxUnosLineas) {
                        System.out.printf("-Las filas %d y %d tienen la mayor cantidad de unos\n", i, j);
                        unosMaxLinea = true;
                    }
                }
            }
        }
        
        
        for (int i = 0; i < cantidadCerosPorFila.length; i++) {
            if (cantidadCerosPorFila[i] == maxCerosLineas) { 
                for (int j = i + 1; j < cantidadCerosPorFila.length; j++) {
                    if (cantidadCerosPorFila[j] == maxCerosLineas) {
                        System.out.printf("-Las filas %d y %d tienen la mayor cantidad de ceros\n", i, j);
                        cerosMaxLinea = true;
                    }
                }
            }
        }
        
 
        for (int i = 0; i < cantidadUnosPorColumna.length; i++) {
            if (cantidadUnosPorColumna[i] == maxUnoColumna) { 
                for (int j = i + 1; j < cantidadUnosPorColumna.length; j++) {
                    if (cantidadUnosPorColumna[j] == maxUnoColumna) {
                        System.out.printf("-Las columnas %d y %d tienen la mayor cantidad de unos \n", i, j);
                        unosMaxColumna = true;
                    }
                }
            }
        }
    
        
        for (int i = 0; i < cantidadCerosPorColumna.length; i++) {
            if (cantidadCerosPorColumna[i] == maxCerosColumna) { 
                for (int j = i + 1; j < cantidadCerosPorColumna.length; j++) {
                    if (cantidadCerosPorColumna[j] == maxCerosColumna) {
                        System.out.printf("-Las columnas %d y %d tienen la mayor cantidad de ceros \n", i, j);
                        cerosMaxColumna = true;
                    }
                }
            }
        }

        int diagonalInversa = matriz.length, lineaUnoSec = 0, lineaCeroSec = 0;
        lineaUno = 0;
        lineaCero = 0;
        for (int i = 0; i < matriz.length; i++) {

            if (matriz[0][0] != matriz[i][i]) {
                simetrico = false;
            }
            if (matriz[i][diagonalInversa - 1 - i] != matriz[0][diagonalInversa - 1]) {
                simetrico = false;
            }

            if (matriz[i][i] == 1) {
                lineaUno++;
            }
            if (matriz[i][i] == 0) {
                lineaCero++;
            }
            if (matriz[i][diagonalInversa - 1 - i] == 1) {
                lineaUnoSec++;
            } else if (matriz[i][diagonalInversa - 1 - i] == 0) {
                lineaCeroSec++;
            }
        }
        if (lineaUno == matriz.length) {
            System.out.println("-Diagonal principal entera de 1s");
        } else if (lineaCero == matriz.length) {
            System.out.println("-Diagonal principal entera de 0s");
        } else {
            System.out.println("-Diagonal principal sin números iguales");
        }

        if (lineaUnoSec == matriz.length) {
            System.out.println("-Diagonal secundaria entera de 1s");
        } else if (lineaCeroSec == matriz.length) {
            System.out.println("-Diagonal secundaria entera de 0s");
        } else {
            System.out.println("-Diagonal secundaria sin números iguales");
        }
    }
}
