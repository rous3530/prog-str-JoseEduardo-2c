import java.util.Scanner;
public class InputValidator {
    public int getValidInt(String message, Scanner sc){
        int value;
        while(true){
            System.out.println(message);
            if (sc.hasNextInt()){
                value = sc.nextInt();
                if (value > 0 && value < 2001){
                    return value;
                }
                System.out.println("El numero ingresado no es postivio");
            }else {
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }

    public double getValidDouble(String message, Scanner sc){
        double value;
        while(true){
            System.out.println(message);
            if (sc.hasNextDouble()){
                value = sc.nextDouble();
                if (value > 0.1 && value <51){
                    return value;
                }
                System.out.println("El numero ingresado no es postivio");
            }else {
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }
    public int getValidService(String message, Scanner sc){
        int value;
        while(true){
            System.out.println(message);
            if (sc.hasNextInt()){
                value = sc.nextInt();
                if (value > 0 && value <3){
                    return value;
                }
                System.out.println("El numero ingresado no esta en el rango");
            }else {
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }
    public boolean getValidBoolean(String message, Scanner sc) {
        while (true) {
            System.out.println(message);
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
