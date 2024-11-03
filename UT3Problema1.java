//@author Alexandro Stedan Dezso Florea

import java.util.Scanner;

public class UT3Problema1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] presiones = new double[20];
        double sistolica, diastolica, sistolicaMax = 3, diastolicaMin = 22, tensionPromedioDiastolica = 0, tensionPromedioSistolica = 0, tensionCompensadaSiastolica = 0, tensionCompensadaDiastolica = 0 , tensionCompensada = 0;
        int start = 0, i = 0;
        boolean encontrado = false;

        System.out.print("Introduce las mediciones (Siastólica - Diastólica): ");
        while (i < presiones.length) {
            if (!input.hasNextDouble()) {
                input.next();
                continue;
            }
            sistolica = input.nextDouble();

            if (sistolica == 0 && i < 4){
                System.out.println("Debes de introducir minimo 2 parejas");
                continue;
            }else if (sistolica == 0 && i >= 4){
                break;
            }

            if (sistolica < 3 || sistolica > 22){
                System.out.println("Debe de estar en el rango de 3 y 22");
                continue;
            }

            if (!input.hasNextDouble()) {
                input.next();
                continue;
            }
            diastolica = input.nextDouble();

            if (diastolica == 0 && i < 4){
                System.out.println("Debes de introducir minimo 2 parejas");
                continue;
            }else if (diastolica == 0 && i >= 4){
                break;
            }

            if (diastolica < 3 || diastolica > 22){
                System.out.println("Debe de estar en el rango de 3 y 22");
                continue;
            }

            if (sistolica < diastolica){
                continue;
            }

            presiones[i] = sistolica;
            presiones[i + 1] = diastolica;
            i += 2;

        }


        System.out.println("\n1.Sistólica Máxima");
        System.out.println("2.Diastólica Mínima");
        System.out.println("3.Más compesada");
        System.out.println("4.Tensión promedio");
        System.out.println("5.Salir\n");

        while (start != 5) {
            System.out.print("Selecciona la opción deseada: ");
            if (input.hasNextInt()) {
                start = input.nextInt();
                input.nextLine();
                switch (start) {
                    case 1:
                        for (int j = 0; j < presiones.length; j += 2) {
                            if (presiones[j] > sistolicaMax) {
                                sistolicaMax = presiones[j];
                            }
                        }
                        System.out.println(sistolicaMax);
                        break;
                    case 2:
                        for (int j = 1; j < presiones.length; j += 2) {
                            if (presiones[j] < diastolicaMin && presiones[j] >= 3 && presiones[j] <= 22) {
                                diastolicaMin = presiones[j];
                            }
                        }
                        System.out.println(diastolicaMin);
                        break;
                    case 3:
                        int indexcompensada = -1;
                        if (i >= 2){
                            double siastolicaInicial = presiones[0];
                            double diastolicaInicial = presiones[1];
                            double diferenciaInicial = Math.abs(siastolicaInicial - (2 * diastolicaInicial));

                            double minDiferencia = diferenciaInicial;

                            for (int j = 2; j < presiones.length; j += 2) {
                                tensionCompensadaSiastolica = presiones[j];
                                tensionCompensadaDiastolica = presiones[j + 1];

                                tensionCompensada = Math.abs(tensionCompensadaSiastolica -(2 * tensionCompensadaDiastolica));

                                if (tensionCompensada < minDiferencia){
                                    minDiferencia = tensionCompensada;
                                    indexcompensada = j;
                                }
                            }
                                tensionCompensadaSiastolica = presiones[indexcompensada];
                                tensionCompensadaDiastolica = presiones[indexcompensada + 1];
                                System.out.printf("Medición más compensada Siastolica: %.2f Diastolica: %.2f \n", tensionCompensadaSiastolica, tensionCompensadaDiastolica);

                        } else {
                            System.out.println("No se encontraron mediciones válidas\n");
                        }

                        break;
                    case 4:

                        for (int j = 0; j < presiones.length; j += 2) {
                            tensionPromedioSistolica = tensionPromedioSistolica + presiones[j];
                        }

                        for (int j = 1; j < presiones.length; j += 2) {
                            tensionPromedioDiastolica = tensionPromedioDiastolica + presiones[j];
                        }

                        double totalSiastolica = tensionPromedioSistolica / (i / 2);
                        double totalDiastolica = tensionPromedioDiastolica / (i / 2);

                        System.out.printf("Promedio Siastólica %.2f y Diastólica %.2f \n", totalSiastolica, totalDiastolica);
                        break;
                    case 5:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Error");
                }
            } else {
                System.out.println("Error valor incorrecto");
                input.nextLine();
            }
        }
    }
}
