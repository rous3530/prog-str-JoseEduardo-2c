import java.util.Scanner;
public class validator {

    public int leerIntEnRango(Scanner sc, String msg, int min, int max){
        int value;
        while(true){
            System.out.println(msg);
            if (sc.hasNextInt()){
                value = sc.nextInt();
                if (value > min && value < max){
                    return value;
                }
                System.out.println("El numero ingresado no es postivio");
            }else {
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }
    public String leerTextoNoVacio(Scanner sc, String msg) {
        String valor = "";
        while (true) {
            System.out.print(msg);
            valor = sc.nextLine();

            if (valor.isBlank()) {
                System.out.println("Error: El campo no puede estar vacío.");
                continue;
            }
            if (valor.matches(".*\\d.*")) {
                System.out.println("Error: El nombre no puede contener números.");
                continue;
            }

            break;
        }
        return valor;
    }
    public double[] leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double[] cals = new double[3];
        int contador = 0;

        while (contador < 3) {

            System.out.print(msg + " " + (contador + 1) + ": ");

            if (sc.hasNextDouble()) {
                double entrada = sc.nextDouble();

                if (entrada <= max && entrada >= min) {
                    cals[contador] = entrada;
                    contador++;
                } else {
                    System.out.printf("Error: La calificación debe estar entre %.1f y %.1f\n", min, max);
                }
            } else {

                System.out.println("Error: Ingrese un número válido.");
                sc.next();
            }
        }
        return cals;
    }
    public boolean  leerBoolean(Scanner sc, String msg){
        while (true) {
            System.out.println(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Error: El valor debe ser 'true' o 'false'.");
                sc.nextLine();
            }
        }
    }

}