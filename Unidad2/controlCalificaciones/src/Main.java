import java.util.Scanner;

public class Main {
    private static double MIN = 0.0;
    private static double MAX = 100.0;
    private static int MINASIS = 0;
    private static int MAXASIS = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validator inputValidator = new validator();
        GradeService gradeService = new GradeService();

        String nombre = inputValidator.leerTextoNoVacio(sc, "Ingrese nombre completo: ");

        double[] calificacion = inputValidator.leerDoubleEnRango(sc, "Ingrese calificacion", MIN, MAX);

        int asistencia = inputValidator.leerIntEnRango(sc, "Ingrese asistencia (0-100): ", MINASIS, MAXASIS);

        boolean proyecto = inputValidator.leerBoolean(sc, "El proyecto se entrego (true/false): ");

        double promedio = gradeService.calcularPromedio(calificacion[0], calificacion[1], calificacion[2]);
        double notaFinal = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(notaFinal, asistencia, proyecto);

        imprimirReporte(nombre, calificacion, promedio, asistencia, proyecto, notaFinal, estado);
    }

    public static void imprimirReporte(String nom, double[] c, double p, int a, boolean pr, double f, String est) {
        System.out.println("\n========================================");
        System.out.println("REPORTE ACADÉMICO: " + nom.toUpperCase());
        System.out.printf("Parciales: [%.1f, %.1f, %.1f]\n", c[0], c[1], c[2]);
        System.out.printf("Promedio de Parciales: %.2f\n", p);
        System.out.println("Asistencia: " + a + "%");
        System.out.println("Proyecto Entregado: " + (pr ? "SÍ" : "NO"));
        System.out.printf("Calificación Final (70%% Prom / 30%% Asis): %.2f\n", f);
        System.out.println("ESTADO FINAL: " + est);
        System.out.println("========================================");
    }
}