public class persona {
    private int id;
    private String nombre;
    private boolean isActive;

    public persona() {

    }

    public persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
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
}
