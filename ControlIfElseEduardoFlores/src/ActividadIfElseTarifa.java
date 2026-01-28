import java.util.Scanner;

public class ActividadIfElseTarifa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad,tarifaFinal;
        boolean esEstudiante;



        edad = obtenerInt(sc, "Ingrese su edad: ");

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        }

        esEstudiante = obtenerBoolean(sc, "Es usted estudiante (TRUE/FALSE): ");


        tarifaFinal = calcularTarifa(edad, esEstudiante);

        mostrarResumen(edad, esEstudiante, tarifaFinal);
    }

    /**
     * Calcula la tarifa basada en la edad y el estatus de estudiante.
     * @param edad Edad del usuario.
     * @param esEstudiante Booleano que indica si es estudiante.
     * @return El costo de la tarifa.
     */
    public static int calcularTarifa(int edad, boolean esEstudiante) {
        int tarifa = 0;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else if (edad >= 18) {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        return tarifa;
    }

    /**
     * Solicita un entero al usuario.
     * @param sc Scanner para la entrada.
     * @param mensaje Mensaje a mostrar.
     * @return El entero ingresado.
     */
    public static int obtenerInt(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    /**
     * Solicita un booleano al usuario.
     * @param sc Scanner para la entrada.
     * @param mensaje Mensaje a mostrar.
     * @return El booleano ingresado.
     */
    public static boolean obtenerBoolean(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextBoolean();
    }

    /**
     * Muestra los datos finales en pantalla.
     * @param edad Edad ingresada.
     * @param esEstudiante Estatus de estudiante.
     * @param tarifa Tarifa calculada.
     */
    public static void mostrarResumen(int edad, boolean esEstudiante, int tarifa) {
        System.out.println("\nResumen de Tarifa");
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + (esEstudiante ? "Sí" : "No"));
        System.out.println("Tarifa final: $" + tarifa);
    }
}