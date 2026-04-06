class Ticket<T> {
    private String bookingCode;
    private Passenger<T> passenger;
    private TicketClass ticketClass;

    public Ticket(String bookingCode, Passenger<T> passenger, TicketClass ticketClass) {
        this.bookingCode = bookingCode;
        this.passenger = passenger;
        this.ticketClass = ticketClass;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public Passenger<T> getPassenger() {
        return passenger;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }
}
