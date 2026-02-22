public class GenericTicket<T> {
    private T BookingCode;
    private String passengerName;

    public GenericTicket(T bookingCode, String passengerName) {
        BookingCode = bookingCode;
        this.passengerName = passengerName;
    }

    public T getBookingCode() {
        return BookingCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void displayTicket(){
        
    }

    public static void main(String[] args) {

    }
}