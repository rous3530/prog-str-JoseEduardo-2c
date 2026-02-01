import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static final int OPCION_MIN = 1;
    public static final int OPCION_MAX = 5;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        int c_CtoF = 0, c_FtoC = 0, c_KmToMi = 0, c_MiToKm = 0;

        do {
            mostrarMenu();
            opcion = capturarEntero(teclado, "Seleccione una opción: ");

            if (opcion >= OPCION_MIN && opcion < OPCION_MAX) {
                double valorEntrada = capturarDouble(teclado, "Ingrese el valor a convertir: ");

                switch (opcion) {
                    case 1 -> {
                        System.out.printf("%.2f °C equivalen a %.2f °F%n", valorEntrada, convertirCelsiusAFahrenheit(valorEntrada));
                        c_CtoF++;
                    }
                    case 2 -> {
                        System.out.printf("%.2f °F equivalen a %.2f °C%n", valorEntrada, convertirFahrenheitACelsius(valorEntrada));
                        c_FtoC++;
                    }
                    case 3 -> {
                        System.out.printf("%.2f Km equivalen a %.2f Millas%n", valorEntrada, convertirKmAMillas(valorEntrada));
                        c_KmToMi++;
                    }
                    case 4 -> {
                        System.out.printf("%.2f Millas equivalen a %.2f Km%n", valorEntrada, convertirMillasAKm(valorEntrada));
                        c_MiToKm++;
                    }
                }
            } else if (opcion != OPCION_MAX) {
                System.out.println("Error: Opción inválida. Intente de nuevo.");
            }

        } while (opcion != OPCION_MAX);

        imprimirResumen(c_CtoF, c_FtoC, c_KmToMi, c_MiToKm);
        teclado.close();
    }


    public static double convertirCelsiusAFahrenheit(double c) { return (c * 9/5) + 32; }
    public static double convertirFahrenheitACelsius(double f) { return (f - 32) * 5/9; }
    public static double convertirKmAMillas(double km) { return km * 0.621371; }
    public static double convertirMillasAKm(double mi) { return mi * 1.60934; }


    public static void mostrarMenu() {
        System.out.println("\nCONVERSOR DE UNIDADES");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    /**
     * Captura un entero y gestiona errores de tipo de dato.
     */
    public static int capturarEntero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                sc.next();
            }
        }
    }

    /**
     * Captura un decimal (double) y gestiona errores de tipo de dato.
     */
    public static double capturarDouble(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un valor numérico (ej: 25.5).");
                sc.next();
            }
        }
    }

    public static void imprimirResumen(int c1, int c2, int c3, int c4) {
        int total = c1 + c2 + c3 + c4;
        System.out.println("RESUMEN FINAL");
        System.out.println("°C a °F: " + c1);
        System.out.println("°F a °C: " + c2);
        System.out.println("Km a Millas: " + c3);
        System.out.println("Millas a Km: " + c4);
        System.out.println("Total de conversiones: " + total);
    }
}