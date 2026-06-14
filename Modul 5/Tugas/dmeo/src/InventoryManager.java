import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    private HashMap<String, HashMap<String, Item>> userInventories = new HashMap<>();
    private Scanner input  = new Scanner(System.in);

    public InventoryManager() {
        dataStatic();
    }

    private void dataStatic(){
        // Tambahkan inventory default untuk admin
        HashMap<String, Item> adminInventory = new HashMap<>();
        Item item1 = new Item("kaos",10,55000);
        adminInventory.put(item1.getName(), item1);
        userInventories.put("@dmin", adminInventory);
    }
    
    private HashMap<String, Item> getUserInventory(String username) {
        return userInventories.computeIfAbsent(username, k -> new HashMap<>());
    }

    public void addItem(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== Add new item ===");
        System.out.print("Enter item name: ");
        String name = input.nextLine().toLowerCase();
        if(inventory.containsKey(name)){    
            System.out.println("Item already exists in the inventory.");
            return;
        }
        System.out.print("Enter initial stock: ");
        int stock = input.nextInt();
        System.out.print("Enter price: ");
        double price = input.nextDouble();
        input.nextLine();
        Item item = new Item(name, stock, price);
        inventory.put(name, item);
        System.out.println("Item added successfully.");
    }

    public void viewInventory(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== View inventory ===");
        if(inventory.isEmpty()){
            System.out.println("There is no items in the inventory.");
            return;
        }
        int no = 1;
        for(Map.Entry<String,Item> entry : inventory.entrySet()){
            Item item = entry.getValue();
            System.out.println(no + ". " + item.getName()+" | Stock: "+item.getStock()+" | Price: "+item.getPrice());
            no++;
        }
        System.out.println("Total items in the inventory: " + inventory.size());
    }

    public void searchItem(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== Search item ===");
        System.out.print("Enter item name: ");
        String name = input.nextLine().toLowerCase();
        if(name.isEmpty()){
            System.out.println("Item name cannot be empty!");
            return;
        }
        if(inventory.containsKey(name)){
            Item item = inventory.get(name);
            System.out.println("\nItem found successfully.");
            System.out.println("Name: "+item.getName());
            System.out.println("Stock: "+item.getStock());
            System.out.println("Price: "+item.getPrice());
        }else {
            System.out.println("Item not found.");
        }
    }

    public void addStock(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== Add new stock ===");
        System.out.print("Enter item name: ");
        String name = input.nextLine().toLowerCase();
        if(name.isEmpty()){
            System.out.println("Item name cannot be empty!");
            return;
        }
        if(inventory.containsKey(name)){
            Item item = inventory.get(name);
            System.out.print("Enter stock to add: ");
            int addstock = input.nextInt();
            input.nextLine();
            int oldStock = item.getStock();
            item.setStock(addstock+oldStock);
            System.out.println("Stock updated successfully.");
            System.out.println(name+": "+oldStock+" -> "+item.getStock());
        }else {
            System.out.println("Item not found.");
        }
    }

    public void removeItem(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== Remove item ===");
        System.out.print("Enter item name to remove: ");
        String name = input.nextLine().toLowerCase();
        if(name.isEmpty()){
            System.out.println("Item name cannot be empty!");
            return;
        }
        Item removedItem = inventory.remove(name);
        if(removedItem != null){
            System.out.println("Item removed successfully.");
            System.out.println("(stock: "+removedItem.getStock()+" price: Rp."+removedItem.getPrice()+")");
        }else  {
            System.out.println("Item not found.");
        }
    }

    public void updatePrice(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== Update price ===");
        System.out.print("Enter item name: ");
        String name = input.nextLine().toLowerCase();
        if(name.isEmpty()){
            System.out.println("Item name cannot be empty!");
            return;
        }
        if(inventory.containsKey(name)){
            Item item = inventory.get(name);
            double oldPrice = item.getPrice();
            System.out.println("Current price: Rp."+oldPrice);
            System.out.print("Enter new price: ");
            double newPrice = input.nextDouble();
            input.nextLine();
            item.setPrice(newPrice);
            System.out.println("Price updated successfully.");
            System.out.println(name+": "+oldPrice+" -> Rp."+item.getPrice());
        }else  {
            System.out.println("Item not found.");
        }
    }

    public void viewInventoryReport(String username){
        HashMap<String, Item> inventory = getUserInventory(username);
        System.out.println("\n=== View inventory report ===");
        if(inventory.isEmpty()){
            System.out.println("There is no items in the inventory.");
            return;
        }
        for(Map.Entry<String,Item> entry : inventory.entrySet()){
            Item item = entry.getValue();
            System.out.println("- "+item.getName()+"| Stock: "+item.getStock()+" | Price: "+item.getPrice());
        }
        System.out.println("\nLogged-in User: "+username);
    }


}
