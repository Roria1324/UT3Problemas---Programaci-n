//@author Alexandro Stedan Dezso Florea
import java.util.Scanner;

public class UT3Problema1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] presiones = new double[20];
        double tensiones = 0, sistolicaMax = 3, diastolicaMin = 22, tensionPromedioDiastolica = 0, tensionPromedioSistolica = 0;
        int start = 0, i = 0;
        boolean encontrado = false;

        System.out.print("Introduce las mediciones (Siastólica - Diastólica): ");
        while (i < presiones.length) {
            if (!input.hasNextDouble()) {
                input.next();

            } else if ((tensiones = input.nextDouble()) >= 3 && tensiones <= 22) {
                presiones[i] = tensiones;
                i++;
            }
            if (tensiones == 0) {
                break;
            }
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
                        for (int j = 0; j < presiones.length; j++) {

                        }
                        break;
                    case 4:
                        int b = 0;
                        int c = 0;
                        for (int j = 0; j < presiones.length; j += 2) {
                            tensionPromedioSistolica = tensionPromedioSistolica + presiones[j];
                            b++;
                        }
                        
                        for (int j = 1; j < presiones.length; j += 2) {
                            tensionPromedioDiastolica = tensionPromedioDiastolica + presiones[j];
                            c++;
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
