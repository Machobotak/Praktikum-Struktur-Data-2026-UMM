import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AuthManager auth = new AuthManager();
        InventoryManager inventory = new InventoryManager();

        int choice;

        do {
            if (!auth.isLoggedIn()) {

                System.out.println("\n=== Railway Inventory System ===");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose menu: ");

                choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        auth.register();
                        break;
                    case 2:
                        auth.login();
                        break;
                    case 3:
                        System.out.println("Program finished.");
                        return;
                    default:
                        System.out.println("Invalid menu!");
                }
            } else {
                System.out.println("\n=== Railway Inventory System ===");
                System.out.println("1. Add Item");
                System.out.println("2. View Inventory");
                System.out.println("3. Search Item");
                System.out.println("4. Add Stock");
                System.out.println("5. Remove Item");
                System.out.println("6. Update Price");
                System.out.println("7. View Inventory Report");
                System.out.println("8. Logout");
                System.out.print("Choose menu: ");
                choice = input.nextInt();
                input.nextLine();
                String username = auth.getLoggedInUser();
                switch (choice) {
                    case 1:
                        inventory.addItem(username);
                        break;
                    case 2:
                        inventory.viewInventory(username);
                        break;
                    case 3:
                        inventory.searchItem(username);
                        break;
                    case 4:
                        inventory.addStock(username);
                        break;
                    case 5:
                        inventory.removeItem(username);
                        break;
                    case 6:
                        inventory.updatePrice(username);
                        break;
                    case 7:
                        inventory.viewInventoryReport(username);
                        break;
                    case 8:
                        auth.logout();
                        break;
                    default:
                        System.out.println("Invalid menu!");
                }
            }
        } while (true);
    }
}