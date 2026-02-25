public class gato extends animal{

    public gato(String name) {
        super(name);//inicializa la clase padre, es animal
    }
    @Override
    public void hacerSonido() {
        System.out.println(name+" hace miau");
    }
}
