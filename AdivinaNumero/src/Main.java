import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {

    public static final int MAX_INTENTOS = 7;
    public static final int RANGO_MINIMO = 1;
    public static final int RANGO_MAXIMO = 100;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random generador = new Random();

        int numeroSecreto = generador.nextInt(RANGO_MAXIMO) + RANGO_MINIMO;
        int intentosRealizados = 0;
        int fueraDeRangoContador = 0;
        int erroresFormatoContador = 0;
        boolean haGanado = false;

        System.out.println("Bienvenido al Juego del Número Secreto");
        System.out.println("Tienes " + MAX_INTENTOS + " intentos para adivinar un número entre " + RANGO_MINIMO + " y " + RANGO_MAXIMO);

        while (intentosRealizados < MAX_INTENTOS && !haGanado) {
            System.out.println("\nIntento " + (intentosRealizados + 1) + "/" + MAX_INTENTOS);

            try {
                int suposicion = obtenerEntradaUsuario(lector, "Introduce tu número: ");

                if (validarRango(suposicion)) {
                    intentosRealizados++;
                    haGanado = verificarAcierto(suposicion, numeroSecreto);
                } else {
                    System.out.println("Error: El número debe estar entre " + RANGO_MINIMO + " y " + RANGO_MAXIMO);
                    fueraDeRangoContador++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido (no letras ni símbolos).");
                erroresFormatoContador++;
                lector.next();
            }
        }

        finalizarPartida(haGanado, numeroSecreto, fueraDeRangoContador, erroresFormatoContador);
        lector.close();
    }

    /**
     * Solicita la entrada al usuario.
     * @param sc Instancia de Scanner.
     * @param mensaje Instrucción para el usuario.
     * @return El número entero ingresado.
     */
    public static int obtenerEntradaUsuario(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    /**
     * Comprueba si el número está dentro de los límites permitidos.
     * @param numero El valor a validar.
     * @return true si es válido, false de lo contrario.
     */
    public static boolean validarRango(int numero) {
        return (numero >= RANGO_MINIMO && numero <= RANGO_MAXIMO);
    }

    /**
     * Compara la suposicion con el número secreto y orienta al usuario.
     * @param suposicion Número del usuario.
     * @param secreto Número a adivinar.
     * @return true si son iguales.
     */
    public static boolean verificarAcierto(int suposicion, int secreto) {
        if (suposicion == secreto) {
            System.out.println("¡Ganaste!");
            return true;
        } else if (suposicion < secreto) {
            System.out.println("Pista: El número secreto es MAYOR.");
        } else {
            System.out.println("Pista: El número secreto es MENOR.");
        }
        return false;
    }

    /**
     * Despliega las estadísticas finales del juego.
     */
    public static void finalizarPartida(boolean gano, int secreto, int fueraRango, int fallosTipo) {
        System.out.println("\nRESUMEN DE PARTIDA");
        if (!gano) {
            System.out.println("Agotaste tus intentos. El número secreto era: " + secreto);
        }
        System.out.println("Entradas fuera de rango: " + fueraRango);
        System.out.println("Entradas no numéricas: " + fallosTipo);
        System.out.println("¡Gracias por jugar!");
    }
}