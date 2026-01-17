import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {

            int Opcion = menuOpciones(sc,"Menu: " +
                    "1.-Calcular IMC" +
                    "2.-Calcular área de un rectangulo" +
                    "3.-Convertir °C a °F" +
                    "4.-Calcular area circulo" +
                    "5.-Salir" +
                    "Favor de seleccionar una opción: ");



            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You selected Option A.");
                    break;
                case 2:
                    System.out.println("You selected Option B.");
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();

        } while (choice != 3);
    }

    public  static int menuOpciones(Scanner sc,String mensaje) {



        return 0;
    }
}
