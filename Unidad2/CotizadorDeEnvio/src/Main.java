import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShippingCalculator shippingCalculator = new ShippingCalculator();
        InputValidator inputValidator = new InputValidator();
        Scanner sc = new Scanner(System.in);
        //I-P-O

       //INPUT
        double pesoKg = inputValidator.getValidDouble("Ingresa el peso del paquete a enviar",sc);
        int distanciaKm = inputValidator.getValidInt("Ingresa la distancia que recorrera",sc);
        int tipoServicio = inputValidator.getValidService("Escoga el tipo de servicio (1.-Estandar,2.-Express)",sc);
        boolean zonaRemota = inputValidator.getValidBoolean("Es zona Remota (true/false)",sc);
        //PROSSES
        shippingCalculator.process(pesoKg,distanciaKm,tipoServicio,zonaRemota);

        //OUPUT
        String servicioTexto = (tipoServicio == 1) ? "Estándar" : "Express";

        System.out.println("\n======= TICKET DE ENVÍO =======");
        System.out.println("Servicio:      " + servicioTexto);
        System.out.println("Peso:          " + pesoKg + " kg");
        System.out.println("Distancia:     " + distanciaKm + " km");
        System.out.println("Zona Remota:   " + (zonaRemota ? "Sí" : "No"));
        System.out.println("-------------------------------");

        // Usamos los getters de shippingCalculator
        System.out.printf("Subtotal:      $%.2f\n", shippingCalculator.getSubtotal());
        System.out.printf("IVA (16%%):     $%.2f\n", shippingCalculator.getIva());
        System.out.printf("TOTAL FINAL:   $%.2f\n", shippingCalculator.getTotal());
        System.out.println("-------------------------------\n");

        sc.close();
    }
}
