public class GenericTicket<T> {
    private T bookingCode;
    private String passengerName;

    public GenericTicket(T bookingCode, String passengerName) {
        this.bookingCode = bookingCode;
        this.passengerName = passengerName;
    }

    public T getBookingCode() {
        return bookingCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void displayTicket(){
        System.out.println("\n=== Railway Ticket Information ===");
        System.out.println("Booking Code      : "+bookingCode);
        System.out.println("Passengger Name   : "+passengerName);
        System.out.println("Booking Code Type : "+bookingCode.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericTicket ticket1 = new GenericTicket("KA-001","Andi");
        GenericTicket ticket2 = new GenericTicket(1002,"Budi");

        ticket1.displayTicket();
        ticket2.displayTicket();
    }
}