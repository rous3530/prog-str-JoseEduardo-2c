import java.util.Scanner;
public class Eject {
    private int id;
    private String nombre;
    private boolean isActive;

    public Eject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public void menu(){
        System.out.println("------Menu------");
        System.out.println("1)Alta");
        System.out.println("2) Buscar por ID (solo mostrara activos)");
        System.out.println("3) Baja lógica por ID");
        System.out.println("4) Listar activas");
        System.out.println("5) Actualizar nombre por ID (solo activas)");
        System.out.println("0) Salir");
        System.out.println("----------------");
    }

    public static int capturarOpcion(Scanner sc, String mensaje) {
        while (true) {
                System.out.print(mensaje);
                return sc.nextInt();
        }
    }

    public static  int StarArray(Scanner sc, String mensaje) {

        System.out.println(mensaje);
        return sc.nextInt();
    }


    public void alta(Eject[] usuarios, Scanner sc) {
        Validator validador = new Validator();


        int id = validador.getValidInt("Ingrese un id unico:", sc);
        sc.nextLine();
        String nombre = validador.leerTextoNoVacio(sc, "Ingrese un nombre:");
        boolean active = validador.leerBoolean(sc, "El usuario esta Activo? (True/False)");

        for (Eject u : usuarios) {
            if (u != null && u.getId() == id) {
                System.out.println("Error: El ID " + id + " ya está registrado. No se puede duplicar.");
                return;
            }
        }

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                Eject nuevoUsuario = new Eject();
                nuevoUsuario.setId(id);
                nuevoUsuario.setNombre(nombre);
                nuevoUsuario.setIsActive(active);

                usuarios[i] = nuevoUsuario;
                System.out.println("Usuario registrado exitosamente en la posición " + i);
                return;
            }
        }

        System.out.println("Error: El arreglo está lleno. No hay espacio para más usuarios.");
    }


    public void consulta(Eject[] usuarios, Scanner sc) {
        System.out.print("Ingrese el ID a buscar: ");
        int buscarId = sc.nextInt();
        boolean idExisteEnSistema = false;

        for (Eject u : usuarios) {
            if (u != null && u.getId() == buscarId) {
                idExisteEnSistema = true;

                if (u.getIsActive()) {
                    System.out.println("Usuario Encontrado: " + u.toString());
                } else {
                    System.out.println("El usuario con ID " + buscarId + " existe, pero está INACTIVO.");
                }
                break;
            }
        }

        if (!idExisteEnSistema) {
            System.out.println("Error: El ID " + buscarId + " NO ENCONTRADO (no existe en el registro).");
        }
    }


    public void bajaLogica(Eject[] usuarios, Scanner sc) {
        System.out.print("Ingrese el ID para dar de baja: ");
        int bajaId = sc.nextInt();
        boolean exito = false;

        for (Eject u : usuarios) {
            if (u != null && u.getId() == bajaId) {
                if (u.getIsActive()) {
                    u.setIsActive(false);
                    System.out.println("El usuario con ID " + bajaId + " ha sido desactivado.");
                } else {
                    System.out.println("El usuario ya estaba inactivo.");
                }
                exito = true;
                break;
            }
        }
        if (!exito) System.out.println("No se encontró un usuario con ese ID.");
    }

    public void listado(Eject[] usuarios, Scanner sc) {
        System.out.println("\n--- LISTADO DE USUARIOS ACTIVOS ---");
        boolean hayActivos = false;

        for (Eject u : usuarios) {
            if (u != null && u.getIsActive()) {
                System.out.println(u.toString());
                hayActivos = true;
            }
        }

        if (!hayActivos) {
            System.out.println("No hay usuarios activos registrados actualmente.");
        }

        System.out.println("\nPresione Enter para continuar...");
        sc.nextLine();
    }

    public void actualizacion(Eject[] usuarios, Scanner sc) {
        System.out.print("Ingrese el ID para actualizar nombre: ");
        int updateId = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        boolean encontrado = false;

        for (Eject u : usuarios) {
            if (u != null && u.getId() == updateId) {
                encontrado = true;
                if (u.getIsActive()) {
                    System.out.print("Ingrese el nuevo nombre: ");
                    u.setNombre(sc.nextLine());
                    System.out.println("Nombre actualizado con éxito.");
                } else {
                    System.out.println("No se puede editar: El usuario con ID " + updateId + " está INACTIVO.");
                }
                break;
            }
        }
        if (!encontrado) System.out.println("Error: ID " + updateId + " no existe.");
    }

}