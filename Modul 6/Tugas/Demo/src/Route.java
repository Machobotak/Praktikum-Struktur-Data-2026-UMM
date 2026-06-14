public class Route {
    String destination;
    int distance;
    int timeTravel;
    double fare;

    public Route(String destination, int distance, int timeTravel, double fare) {
        this.destination = destination;
        this.distance = distance;
        this.timeTravel = timeTravel;
        this.fare = fare;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getTimeTravel() {
        return timeTravel;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "To: "+destination+
                " | destination: " + distance+
                " km | Time: "+timeTravel+
                " min | fare: Rp."+fare;
    }
}
