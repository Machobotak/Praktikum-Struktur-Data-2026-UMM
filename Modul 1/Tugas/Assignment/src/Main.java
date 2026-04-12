import java.util.Scanner;

public class Main {

    public static void printTicketInfo(Ticket<?> ticket) {
        System.out.println("\n=== Ticket Information ===");
        System.out.println("Booking Code   : " + ticket.getBookingCode());
        System.out.println("Passenger Name : " + ticket.getPassenger().getName());

        Object id = ticket.getPassenger().getIdentityNumber();
        System.out.println("Identity Type  : " + id.getClass().getSimpleName());
        System.out.println("Identity Number: " + id);

        System.out.println("Ticket Class   : " + ticket.getTicketClass());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Railway Ticket Booking ===");

        System.out.print("Enter Passenger Name: ");
        String name = input.nextLine();

        System.out.print("Enter Identity Number: ");
        String identity = input.nextLine();


        System.out.print("Enter Booking Code: ");
        String bookingCode = input.nextLine();

        System.out.println("\nSelect Ticket Class:");
        System.out.println("1. ECONOMY");
        System.out.println("2. BUSINESS");
        System.out.println("3. EXECUTIVE");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        TicketClass ticketClass;

        switch (choice) {
            case 1:
                ticketClass = TicketClass.ECONOMY;
                break;
            case 2:
                ticketClass = TicketClass.BUSINESS;
                break;
            case 3:
                ticketClass = TicketClass.EXECUTIVE;
                break;
            default:
                ticketClass = TicketClass.ECONOMY;
        }


        Passenger<Long> passenger = new Passenger<>(name, identity);
        Ticket<Long> ticket = new Ticket<>(bookingCode, passenger, ticketClass);


        printTicketInfo(ticket);
    }
}