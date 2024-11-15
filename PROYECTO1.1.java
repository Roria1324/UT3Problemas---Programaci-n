//@author Alexandro Stefan Dezso Florea
import java.util.Scanner;

public class Proyecto1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Declaración de variable
        int start = 0, numPalabra, intentosMax = 0;
        final int valorMin = 0, valorMax = 9;
        final String[] palabrasOcultas = {"flamenco", "cisne", "gaviota", "pavo", "paloma", "cuervo", "guacamayo", "pato", "canario", "ruiseñor"};
        String palabraOculta, palabraJugador;
        System.out.println("---------------------------------");
        System.out.println("--Bienvenido a adivina la pabra--");
        System.out.println("---------------------------------");

        while (start != 2) {
            System.out.print("Si quiere comenzar pulse 1 y si quiere salir pulse 2: ");
            //Condicion para verificar entrada de datos
            if (input.hasNextInt()) {
                start = input.nextInt();
                input.nextLine();
                //Menu en el cual el jugador elige si jugar o no
                switch (start) {
                    //En caso de 1 jugar
                    case 1:
                        int puntajeMax = 100;
                        boolean adivinado = false;
                        int intentos = 0;
                        System.out.print("\nCuentos intentos quieres: ");
                        if (input.hasNextInt()) {
                            intentosMax = input.nextInt();
                            input.nextLine();
                        } else {
                            System.out.println("Error, valor incorrecto");
                            input.next();
                        }
                        numPalabra = (int) (Math.random() * palabrasOcultas.length);
                        palabraOculta = palabrasOcultas[numPalabra];

                        for (int i = 0; i < intentosMax; i++) {
                            intentos++;
                            System.out.println("Intento número: " + intentos);
                            System.out.print("Intente adivinar la palabra: ");
                            palabraJugador = input.nextLine().toLowerCase();
                            if (palabraJugador.length() < palabraOculta.length() || palabraJugador.length() > palabraOculta.length()) {
                                System.out.println("Ingrese una palabra que tenga la misma cantidad de letras.");
                                i--;
                                intentos--;
                            } else {

                                if (palabraJugador != palabraOculta) {
                                    if (intentos > 1) {
                                        System.out.println("\nLa palabra tiene: " + palabraOculta.length() + " letras");
                                    }
                                    if (intentos > 3) {
                                        for (int j = 0; j < palabraOculta.length(); j++) {
                                            if (palabraJugador.charAt(j) == palabraOculta.charAt(j)) {
                                                System.out.print(palabraOculta.charAt(j));
                                            } else {
                                                System.out.print("_");
                                            }
                                        }
                                        System.out.println(); //Sout para separar siguiente print y no salga junto.
                                    }

                                    if (intentos > 5) {
                                        for (int j = 0; j < palabraOculta.length(); j++) {
                                            if (palabraOculta.charAt(j) == 'a' || palabraOculta.charAt(j) == 'e'
                                                    || palabraOculta.charAt(j) == 'i' || palabraOculta.charAt(j) == 'o'
                                                    || palabraOculta.charAt(j) == 'u') {
                                                System.out.print("V");
                                            } else {
                                                System.out.print("C");
                                            }
                                        }
                                        System.out.println();//Sout para separar siguiente print y no salga junto.
                                    }

                                }
                            }
                            if (palabraJugador.equals(palabraOculta)) {
                                puntajeMax -= (100 / intentosMax);
                                if (intentos == 1 && palabraOculta.length() >= 15) {
                                    puntajeMax = puntajeMax * 5;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + " Total de puntos: " + puntajeMax + " Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 1 && palabraOculta.length() >= 10) {
                                    puntajeMax = puntajeMax * 4;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 1 && palabraOculta.length() >= 7) {
                                    puntajeMax = puntajeMax * 3;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 2 && palabraOculta.length() >= 15) {
                                    puntajeMax = puntajeMax * 4;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 2 && palabraOculta.length() >= 10) {
                                    puntajeMax = puntajeMax * 3;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 2 && palabraOculta.length() >= 7) {
                                    puntajeMax = puntajeMax * 2;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 3 && palabraOculta.length() >= 15) {
                                    puntajeMax = puntajeMax * 3;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 3 && palabraOculta.length() >= 10) {
                                    puntajeMax = puntajeMax * 2;
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos == 3 && palabraOculta.length() >= 7) {
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                } else if (intentos >= 4 && palabraOculta.length() >= 4) {
                                    System.out.println("Has ganado, la palabra era: " + palabraOculta + ". Total de puntos: " + puntajeMax + ". Total de intentos: " + intentos);
                                    break;
                                }

                                if (adivinado) {
                                    System.out.println("HAS PERDIDO!! Total de puntos: 0. La palabra era: " + palabraOculta + "Has gastado un total de " + intentos + " intentos");
                                    break;
                                }
                            }
                        }
                        break;
                    //En caso de 2 salir del juego
                    case 2:
                        System.out.println("Saliendo del juego");
                        break;
                }
            } else {
                System.out.println("Error, valor incorrecto");
                input.nextLine();
            }
        }
    }
}
