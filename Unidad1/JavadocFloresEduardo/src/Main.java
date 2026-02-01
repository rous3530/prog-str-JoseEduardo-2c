import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static  double PESOBAJO = 18.5;
    public static  double PESOMEDIO = 25;
    public static  double PESOALTO = 30;
    public static  double MULTIPLICA = 1.8;
    public static  double SUMA = 54;
    public static  double PI = 3.1416;
    public static void main(String[] args) {
        int Opcion;
        Scanner sc = new Scanner(System.in);

        do {

            Opcion = menuOpciones(sc, "Menu: \n" +
                    "1.-Calcular IMC \n" +
                    "2.-Calcular área de un rectangulo \n" +
                    "3.-Convertir °C a °F \n" +
                    "4.-Calcular area circulo \n" +
                    "5.-Salir \n" +
                    "Favor de seleccionar una opción numerica: ");

            opcionSwitch(sc,Opcion);


        } while (Opcion != 5);
    }

    /**
     *
     * @param sc
     * @param mensaje
     * @return
     */
    public  static int menuOpciones(Scanner sc,String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     *
     * @param sc
     * @param Opcion
     * @return
     */
    public static int opcionSwitch(Scanner sc ,int Opcion) {
        switch (Opcion) {
            case 1:
                System.out.println("Selecciono calcular IMC");
                double pesoKg = optenerDouble(sc,"Ingrese su peso en Kg: ");
                double alturaM = optenerDouble(sc,"Ingrese su altura en Metros: ");
                double IMC = calcuclarIMC(pesoKg,alturaM);
                String clasificacionIMC= clasificarIMC(IMC);
                System.out.println("Clasificación: " +clasificacionIMC);
                break;
            case 2:
                System.out.println("Selecciono calcular área de un rectangulo");
                int altura = optenerInt(sc,"Ingrese su altura en numeros enteros: ");
                int base = optenerInt(sc,"Ingrese su base en nuemrso enteros: ");
                int areaRectangulo= calcularAreaRectangulo(base,altura);
                System.out.println("El area de su rectangulo es: "+areaRectangulo);
                break;
            case 3:
                System.out.println("Selecciono convertir °C a °F");
                double celsius = optenerDouble(sc,"Ingrese sus grados Celsius: ");
                double fahrenheit = transformarAF(celsius);
                System.out.println("Su grados Celsius en Fahrenheit son: "+fahrenheit);
                break;
            case 4:
                System.out.println("Selecciono calcular area de un circulo ");
                double radio = optenerDouble(sc,"Ingrese el radio: ");
                double areaCirculo = calcularAreaCirculo(radio);
                System.out.println("El area del circulo es de: "+areaCirculo);
                break;
            case 5:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Porfavor seleccione una opción valida");
        }
        return 0;
    }

    /**
     *
     * @param pesoKg
     * @param alturaM
     * @return
     */
    public static double calcuclarIMC(double pesoKg, double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    /**
     *
     * @param sc
     * @param mensaje
     * @return
     */
    public static double optenerDouble(Scanner sc,String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     *
     * @param IMC
     * @return
     */
    public static String clasificarIMC(double IMC){
        if(IMC<PESOBAJO) {
            return "Peso Bajo";
        }
        else if(IMC<PESOMEDIO){
            return "Medio";
        }

        else if(IMC<PESOALTO) {
            return "Sobre peso";
        }
        else return "Obesidad";
    }

    /**
     *
     * @param sc
     * @param mensaje
     * @return
     */
    public static int optenerInt(Scanner sc,String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     *
     * @param base
     * @param altura
     * @return
     */
    public static int calcularAreaRectangulo(int base, int altura){
        return altura*base;
    }

    /**
     *
     * @param celsius
     * @return
     */
    public static double transformarAF(double celsius){
        return (celsius*MULTIPLICA)+SUMA;
    }

    /**
     *
     * @param radio
     * @return
     */
    public static double calcularAreaCirculo(double radio){
        return PI *(radio*radio);
    }
}
