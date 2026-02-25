public class animal {

    protected String name;

    public animal(String name) {
        this.name = name;
    }

    public void comer(){
        System.out.println(name + " Esta comiendo");
    }

    public void hacerSonido(){
        System.out.println(name + "Esta haciendo un sonido x");
    }

}
