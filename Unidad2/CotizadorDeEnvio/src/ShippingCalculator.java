public class ShippingCalculator {
    private final double PRECIO_KG = 12.0;
    private final double IVA_PORCENTAJE = 0.16;

    private double subtotal;
    private double iva;
    private double total;
    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotal() { return total; }


    public void process(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        calcularIVA();
        calcularTotal();
    }

    private void calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
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
}