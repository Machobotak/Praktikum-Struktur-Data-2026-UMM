package taks2;

public class Schedule {
    private static int counter = 1;
    private int scheduleId;
    private String trainCode;
    private String trainName;
    private String origin;
    private String destination;
    private String departureTime;
    private double baseFare;

    public Schedule( String trainCode, String trainName, String origin, String destination, String departureTime, double baseFare) {
        this.scheduleId = counter++;
        this.trainCode = trainCode;
        this.trainName = trainName;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.baseFare = baseFare;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Schedule.counter = counter;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public void displayInfo() {
        System.out.println("ID: " + scheduleId +
                " | " + trainCode +
                " | " + trainName +
                " | " + origin + " -> " + destination +
                " | " + departureTime +
                " | Rp" + baseFare);
    }
}
