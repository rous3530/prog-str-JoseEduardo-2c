import java.util.Scanner;

public class Validator {
    public double getValidDouble(String message, Scanner sc) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                if (val >= 0 && val <= 10) return val;
            }
            System.out.println("Error: Rango inválido (0-10).");
            sc.nextLine();
        }
    }

    public int getValidInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                if (val > 0) return val;
            }
            System.out.println("Error: Debe ser un ID positivo.");
            sc.nextLine();
        }
    }

    public String leerTextoNoVacio(Scanner sc, String msg) {
        sc.nextLine(); // Limpiar buffer
        while (true) {
            System.out.print(msg);
            String txt = sc.nextLine().trim();
            if (!txt.isEmpty() && !txt.matches(".*\\d.*")) return txt;
            System.out.println("Error: Nombre inválido (sin números y no vacío).");
        }
    }
}