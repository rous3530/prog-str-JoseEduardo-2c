import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        InputValidator inputValidator = new InputValidator();
        Scanner sc = new Scanner(System.in);
        //I-P-O

       //INPUT
        int cantidad = inputValidator.getValidInt("Ingresa la cantidad de articulos",sc);
        //PROSSES
        ticket.process(cantidad);

        //OUPUT
        ticket.imprimirTicket(cantidad);
    }
}
