package task1;

public class Main {
    public static void main(String[] args) {
        PassengerManager manager = new PassengerManager();
        manager.addPassenger(new Passenger("Ayub","mibrahimalayubi@gmail.com","082149590032",20));
        manager.addPassenger(new Passenger("Budi","budi@gmail.com","08547365123",19));

        System.out.println("Data Penumpang");
        manager.displayAll();

        System.out.println("Search");
        Passenger ketemu1 = manager.searchByName("Ayub");
        if(ketemu1 != null){
            ketemu1.displayInfo();
        }

        manager.updatePassenger(0,"Ayub update", "baru","123123123",20);
        manager.removeByindex(1);

        System.out.println("setelah update & delete");
        manager.displayAll();

    }
}
