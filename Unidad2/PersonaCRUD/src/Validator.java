import java.util.Scanner;
public class Validator {
    public int getValidInt(String message, Scanner sc){
        int value;
        while(true){
            System.out.println(message);
            if (sc.hasNextInt()){
                value = sc.nextInt();
                if (value > 0){
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