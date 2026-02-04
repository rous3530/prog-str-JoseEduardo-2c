public class ShippingCalculator {
    private final double PRECIO_KG = 12.0;
    private final double IVA_PORCENTAJE = 0.16;
    public double subtotal;
    public double iva;
    public double total;

    public void process(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        calcularIVA();
        calcularTotal();
    }

    private  void calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        this.subtotal = (tipoServicio == 1) ? 50.0 : 90.0;

        this.subtotal += (pesoKg * PRECIO_KG);

        if (distanciaKm <= 50) {
            this.subtotal += 20;
        } else if (distanciaKm <= 200) {
            this.subtotal += 60;
        } else {
            this.subtotal += 120;
        }
        if (esZonaRemota) {
            this.subtotal += (this.subtotal * 0.10);
        }
    }

    private void calcularIVA() {
        this.iva = this.subtotal * IVA_PORCENTAJE;
    }

    private void calcularTotal() {
        this.total = this.subtotal + this.iva;
    }

    public static void imprimirTicket(int tipo, double peso, int dist, boolean rem, ShippingCalculator calc) {

        // Información de entrada
        String servicioTexto = (tipo == 1) ? "Estándar" : "Express";
        System.out.println("Servicio:      " + servicioTexto);
        System.out.println("Peso:          " + peso + " kg");
        System.out.println("Distancia:     " + dist + " km");
        System.out.println("Zona Remota:   " + (rem ? "Sí" : "No"));

        System.out.println("-------------------------");

        // Resultados del proceso (obtenidos de la clase ShippingCalculator)
        System.out.printf("Subtotal:      $%.2f\n", calc.subtotal);
        System.out.printf("IVA (16%%):     $%.2f\n", calc.iva);
        System.out.printf("TOTAL FINAL:   $%.2f\n", calc.total);

        System.out.println("-------------------------");
    }

}