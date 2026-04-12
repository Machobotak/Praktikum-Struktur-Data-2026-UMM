package task1;

import java.util.ArrayList;

public class PassengerManager {
    private ArrayList<Passenger> passengers;

    public PassengerManager() {
        passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public Passenger searchByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                return passenger;
            }
        }
        return null;
    }

    public void updatePassenger(int index, String name, String email, String phone, int age) {
        if(index >= 0 && index < passengers.size()) {
            passengers.get(index).setName(name);
            passengers.get(index).setEmail(email);
            passengers.get(index).setPhone(phone);
            passengers.get(index).setAge(age);
        }else{
            System.out.println("Index tidak valid");
        }
    }

    public void removeByindex(int index) {
        if(index >= 0 && index < passengers.size()) {
            passengers.remove(index);
        }
    }

    public void removeById(int id) {
        for(Passenger passenger : passengers) {
            if(passenger.getPassengerId() == id) {
                passengers.remove(passenger);
                break;
            }
        }
    }

    public Passenger getPassenger(int index) {
        if (index >= 0 && index < passengers.size()) {
            return passengers.get(index);
        }
        return null;
    }

    public void displayAll() {
        if(passengers.isEmpty()) {
            System.out.println("tidak ada data penumpang");
        }else {
            for(Passenger passenger : passengers) {
                passenger.displayInfo();
            }
        }
    }

}
