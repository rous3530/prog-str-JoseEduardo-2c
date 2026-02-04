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
        shippingCalculator.imprimirTicket(tipoServicio, pesoKg, distanciaKm, zonaRemota, shippingCalculator);
    }
}
