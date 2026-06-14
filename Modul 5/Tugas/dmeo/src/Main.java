import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AuthManager authManager = new AuthManager();
        InventoryManager inventory = new InventoryManager();

        int choice;

        while (true) {
            System.out.println("\n=== Railway Inventory System ===");
            if (authManager.isLoggedIn()) {
                System.out.println("Logged in as: " + authManager.getLoggedInUser());
                System.out.println("1. Add Item");
                System.out.println("2. View Inventory");
                System.out.println("3. Search Item");
                System.out.println("4. Add Stock");
                System.out.println("5. Remove Item");
                System.out.println("6. Update Price");
                System.out.println("7. View Inventory Report");
                System.out.println("8. Logout");
                System.out.println("9. Exit");
                System.out.print("Choose menu: ");
                choice = input.nextInt();
                input.nextLine();
                
                String username = authManager.getLoggedInUser();
                
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
                        authManager.logout();
                        break;
                    case 9:
                        System.out.println("Thank you for using Railway Inventory System!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid menu!");
                }
            } else {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose menu: ");
                choice = input.nextInt();
                input.nextLine();
                
                switch (choice) {
                    case 1:
                        authManager.register();
                        break;
                    case 2:
                        authManager.login();
                        break;
                    case 3:
                        System.out.println("Thank you for using Railway Inventory System!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid menu!");
                }
            }
        }
    }
}