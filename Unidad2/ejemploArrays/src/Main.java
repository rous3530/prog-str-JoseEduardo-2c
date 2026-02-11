//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            int[] arr;
            int[] arra1 = new int[4];
            int[] arra2 = {1,2,3,4};

        System.out.println("_________________________");
        for (int i = 0; i < arra1.length; i++) {
            System.out.print(arra1[i]);
        }


        System.out.println("_________________________");
        for (int numero:arra1) {
            System.out.print(numero);
        }


        System.out.println("__________________________");
        persona[] personas = new persona[3];
        persona persona1 = new persona();
        persona1.setId(1);
        persona1.setNombre("Test");
        persona1.setIsActive(true);
        persona persona2 = new persona(2,"Eduardo");
        persona persona3 = new persona(3,"Jose");
        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;

        personas[0]= null;
        for (persona persona:personas) {
            try {

                if(persona!=null && persona.getIsActive()){
                    System.out.println("Hay un null");
                }
                //System.out.println(persona);
                System.out.println("____________");
                System.out.println(persona.getId());
                System.out.println(persona.getNombre());
                System.out.println(persona.getIsActive());
            }catch (Exception e){
                System.out.println("Tiene un null");
            }
        }
    }
}