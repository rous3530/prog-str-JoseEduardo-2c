import java.util.Scanner;

/**
public class Main{
    public static void main(String[]a){
        Scanner sc=new Scanner(System.in);
        System.out.print("n:");int n=sc.nextInt();
        int s=0;
        for(int i=1;i<=n;i++){s+=i;}
        System.out.println("r:"+s);
    }}

 * 8 malas practicas detectas

 * 1.-nombres de variables no son claras
 * 2.-mensajes  no claros
 * 3.-divibicion de responsabilidades
 * 4.-identacion correcta
 * 5.-falta de declaracion de variable constante escrito con mayusculas
 * 6.-documentacion del codigo
 * 7.-el codigo no es legible no se puede leer correctamente
 * 8.-no finalizar scanner para evitar la perdida de datos
 */

public class Main{
    public static  int VALORCERO = 0;
    public static void main(String[]a){
        Scanner sc=new Scanner(System.in);

        int Numero=pedirEntero(sc,"Ingrese un numero positivio que no sea menor o igual a 0: ");
        int Resultado = sumarHastaNumero(Numero);

        System.out.println("El resultado de sumar "+ Numero +" es: "+ Resultado);
    }

    /**
     *
     * @param sc obtener previamente instancias
     * @param mensaje se mostrara en consola el mensaje  y luego se usara para calcular
     * @return
     */
    public static int pedirEntero(Scanner sc,String mensaje){
        System.out.print(mensaje);
        return sc.nextInt();
    }

    /**
     * @param Numero se ocupa el valor  de la seccion pedirEntero en esta sentencia
     * @return regresa el valor de VALORCERO
     */
    public static int sumarHastaNumero(int Numero){
        for (int i=1;i<=Numero;i++){
            VALORCERO+=i;
        }
        return VALORCERO;
    }



}