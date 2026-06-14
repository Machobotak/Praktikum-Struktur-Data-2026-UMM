package taks2;

public class Main {
    static void main() {
        ScheduleManager manager = new ScheduleManager();
        manager.addLast(new Schedule("TRN001", "Argo Bromo", "Surabaya", "Jakarta", "08:00", 300000));
        manager.addFirst(new Schedule("TRN002", "Gajayana", "Malang", "Jakarta", "09:00", 350000));
        manager.addLast(new Schedule("TRN003", "Matarmaja", "Malang", "Yogyakarta", "10:00", 200000));

        System.out.println("=== SEMUA JADWAL ===");
        manager.displayAll();

        System.out.println("\n=== SEARCH: Malang ===");
        manager.searchRoute("Surabaya");

        System.out.println("\n=== REMOVE FIRST ===");
        manager.removeFirst();
        manager.displayAll();

        System.out.println("\n=== REMOVE BY ID ===");
        manager.removeById(3);
        manager.displayAll();
    }
}
