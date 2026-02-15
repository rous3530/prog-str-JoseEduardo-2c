import java.util.Scanner;

public class Eject {
    private int id;
    private String nombre;
    private double promedio;
    private boolean isActive;

    public Eject() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %-15s | Promedio: %.2f | Estado: %s",
                id, nombre, promedio, (isActive ? "Activo" : "Inactivo"));
    }

    public void menu() {
        System.out.println("\n********** MENÚ ALUMNOS **********");
        System.out.println("1) Alta alumno");
        System.out.println("2) Buscar por ID (solo activos)");
        System.out.println("3) Actualizar promedio por ID (solo activos)");
        System.out.println("4) Baja lógica por ID");
        System.out.println("5) Listar activos");
        System.out.println("6) Reportes");
        System.out.println("0) Salir");
        System.out.println("**********************************");
    }

    public static int capturarOpcion(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        int opt = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        return opt;
    }

    public static  int StarArray(Scanner sc, String mensaje) {

        System.out.println(mensaje);
        return sc.nextInt();
    }

    public void alta(Eject[] alumnos, Scanner sc) {
        Validator val = new Validator();
        int id = val.getValidInt(sc, "Ingrese ID unico:");

        for (Eject a : alumnos) {
            if (a != null && a.getId() == id) {
                System.out.println("Error: ID ya existe.");
                return;
            }
        }

        String nom = val.leerTextoNoVacio(sc, "Ingrese nombre: ");
        double prom = val.getValidDouble("Ingrese promedio (0-10): ", sc);

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                Eject nuevo = new Eject();
                nuevo.setId(id);
                nuevo.setNombre(nom);
                nuevo.setPromedio(prom);
                nuevo.setIsActive(true); // Alta siempre activo por defecto
                alumnos[i] = nuevo;
                System.out.println("Alumno registrado con éxito.");
                return;
            }
        }
    }

    public void consulta(Eject[] alumnos, Scanner sc) {
        System.out.print("ID a buscar: ");
        int busqueda = sc.nextInt();
        for (Eject a : alumnos) {
            if (a != null && a.getId() == busqueda && a.getIsActive()) {
                System.out.println(a);
                return;
            }
        }
        System.out.println("Alumno no encontrado o inactivo.");
    }

    public void actualizacion(Eject[] alumnos, Scanner sc) {
        Validator val = new Validator();
        System.out.print("ID para actualizar promedio: ");
        int id = sc.nextInt();
        for (Eject a : alumnos) {
            if (a != null && a.getId() == id && a.getIsActive()) {
                double nuevoProm = val.getValidDouble("Nuevo promedio (0-10): ", sc);
                a.setPromedio(nuevoProm);
                System.out.println("Promedio actualizado.");
                return;
            }
        }
        System.out.println("No se puede actualizar (Inactivo o no existe).");
    }


    public void bajaLogica(Eject[] alumnos, Scanner sc) {
        System.out.print("ID para dar de baja: ");
        int id = sc.nextInt();
        for (Eject a : alumnos) {
            if (a != null && a.getId() == id) {
                a.setIsActive(false);
                System.out.println("Baja realizada.");
                return;
            }
        }
    }

    public void listado(Eject[] alumnos, Scanner sc) {
        System.out.println("\n--- ALUMNOS ACTIVOS ---");
        for (Eject a : alumnos) {
            if (a != null && a.getIsActive()) System.out.println(a);
        }
    }

    public void reportes(Eject[] alumnos) {
        double suma = 0, max = -1, min = 11;
        int cont = 0, excelencia = 0;
        Eject mejor = null, peor = null;

        for (Eject a : alumnos) {
            if (a != null && a.getIsActive()) {
                double p = a.getPromedio();
                suma += p;
                cont++;
                if (p >= 8.0) excelencia++;
                if (p > max) { max = p; mejor = a; }
                if (p < min) { min = p; peor = a; }
            }
        }

        if (cont == 0) {
            System.out.println("No hay alumnos activos para reportes.");
            return;
        }

        System.out.println("\n====== REPORTES (SOLO ACTIVOS) ======");
        System.out.printf("Promedio General: %.2f\n", (suma / cont));
        System.out.println("Mejor Alumno: " + mejor);
        System.out.println("Alumno con menor promedio: " + peor);
        System.out.println("Alumnos con promedio >= 8.0: " + excelencia);
        System.out.println("=====================================");
    }
}