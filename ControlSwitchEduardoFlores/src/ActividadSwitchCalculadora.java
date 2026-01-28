import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {

            int Opcion;
        Scanner sc = new Scanner(System.in);

        Opcion = menuOpciones(sc, "Menu: \n" +
                "Seleccione la operacion que desee realizar \n" +
                "1.-Sumar \n" +
                "2.-Restar \n" +
                "3.-Multiplicar \n" +
                "4.-Dividir \n" +
                "5.-Salir \n" +
                "Favor de seleccionar una opción numerica: ");

        opcionSwitch(sc,Opcion);

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
        double valorA, valorB;
        switch (Opcion) {
            case 1:
                System.out.println("Selecciono Suma");
                valorA = optenerDouble(sc,"Ingrese su primer numero a sumar: ");
                valorB = optenerDouble(sc,"Ingrese su segundo digito que sumara: ");
                double operacionSuma = calcuclarSuma(valorA,valorB);
                System.out.println("El resultado de sumar "+valorA+"+"+valorB+"="+operacionSuma);
                break;
            case 2:
                System.out.println("Selecciono Resta");
                valorA = optenerInt(sc,"Ingrese su primer numero a restar: ");
                valorB = optenerInt(sc,"Ingrese su segundo numero que restara: ");
                double operacionResta= calcularResta(valorA,valorB);
                System.out.println("El resultado de restar "+valorA+"-"+valorB+"="+operacionResta);
                break;
            case 3:
                System.out.println("Selecciono Multiplicacion");
                valorA = optenerInt(sc,"Ingrese su primer numero a multiplicar: ");
                valorB = optenerInt(sc,"Ingrese su segundo numero que multiplicara: ");
                double operacionMultiplicar = calcularMultiplicacion(valorA,valorB);
                System.out.println("El resultado de muliplicar "+valorA+"*"+valorB+"="+operacionMultiplicar);
                break;
            case 4:
                System.out.println("Selecciono Division ");
                valorA = optenerInt(sc,"Ingrese su primer numero a divisor: ");
                valorB = optenerInt(sc,"Ingrese su segundo numero que sera el dividendo: ");
                double operacionDivision = calcularDivision(valorA,valorB);
                System.out.println("El resultado de su divir "+valorA+"/"+valorB+"="+operacionDivision);
                break;
            default:
                System.out.println("Porfavor seleccione una opción valida");
        }
        return 0;
    }

    /**
     *
     * @param valorA
     * @param valorB
     * @return
     */
    public static double calcuclarSuma(double valorA, double valorB){
        return valorA+valorB;
    }

    /**
     *
     * @param valorA
     * @param valorB
     * @return
     */
    public static double calcularResta(double valorA, double valorB){
        return valorA-valorB;
    }

    /**
     *
     * @param valorA
     * @param valorB
     * @return
     */
    public static double calcularMultiplicacion(double valorA, double valorB){
        return valorA*valorB;
    }    /**
     *
     * @param valorA
     * @param valorB
     * @return
     */
    public static double calcularDivision(double valorA, double valorB) {
        if (valorB == 0) {
            System.out.println("No se puede dividir por cero");
            return 0;
        }

        return valorA / valorB;
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
     * @param sc
     * @param mensaje
     * @return
     */
    public static int optenerInt(Scanner sc,String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }
}