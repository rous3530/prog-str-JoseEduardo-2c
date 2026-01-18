import java.util.Scanner;

public class Main {
    public static  double PESOBAJO = 18.5;
    public static  double PESOMEDIO = 25;
    public static  double PESOALTO = 30;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double pesoKg = obtenerdouble(sc,"Ingrese el peso en Kg");
        double alturaM = obtenerdouble(sc,"Ingrese la altura en m");


        double IMC= calcuklarIMC(pesoKg,alturaM);
        String clasificacionIMC= clasificarIMC(IMC);
        System.out.println("Clasificación:" +clasificacionIMC);
    }

    /**
     * Metodo para obtener un numero double desde la consola
     * @param sc objeto previamente instanciado
     * @param mensaje se mostrar en consola el resultado
     * @return
     */
    public static  double obtenerdouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Calcular el IMC y devolver el IMC en la terminal
     * @param pesoKg peso en kilogramos
     * @param alturaM altura en metro
     * @return devuelve el IMC
     */
    public static  double calcuklarIMC(double pesoKg,double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    /**
     * Clasificacion del IMC me diante el valor obtenido anterior mente
     * @param IMC
     * @return
     */
    /** * Metodo que devuelve la clasificación basada en el IMC * @param IMC -> previamente calculado * @return String clasificacion */
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
}