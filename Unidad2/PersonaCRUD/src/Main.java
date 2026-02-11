import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Eject eject = new Eject();
        Scanner sc = new Scanner(System.in);
int opcion;


            int tamano= eject.StarArray(sc,"Ingrese la cantidad de usuarios que dara de alta");
            Eject[] usuarios = new Eject[tamano];

        do {

            eject.menu();
            opcion = eject.capturarOpcion(sc,"Selecione una opcion: ");
            if (opcion >= 1 && opcion <= 5) {
                switch (opcion) {
                    case 1 -> {
                            eject.alta(usuarios, sc);
                    }
                    case 2 -> {
                        eject.consulta(usuarios,sc);
                       }
                    case 3 -> {
                        eject.bajaLogica(usuarios,sc);
                    }
                    case 4 -> {
                        eject.listado(usuarios,sc);
                    }
                    case 5 -> {
                        eject.actualizacion(usuarios,sc);
                    }
                }
            } else if (opcion != 0) {
                System.out.println("Error: Opción inválida. Intente de nuevo.");
            }
        }while (opcion != 0);


    }
}