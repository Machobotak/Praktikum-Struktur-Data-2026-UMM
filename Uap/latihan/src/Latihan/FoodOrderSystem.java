package Latihan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FoodOrderSystem {
    public static HashMap<String, Queue<String>> buildOrders(String[] orders) {HashMap<String, Queue<String>> map = new HashMap<>();
        for (String order : orders) {
            String[] temp = order.split(":");
            String seller = temp[0];
            String food = temp[1];
            map.putIfAbsent(seller, new LinkedList<>());
            map.get(seller).offer(food);
        }
        return map;
    }

    public static void processOrders(HashMap<String, Queue<String>> orders) {
        for (String seller : orders.keySet()) {
            if (!orders.get(seller).isEmpty()) {
                String served = orders.get(seller).poll();
                System.out.println(seller + " serves " + served);
            }
        }
    }
    public static void main(String[] args) {
        String[] data = {
                "Alice:Nasi Goreng",
                "Alice:Mie Ayam",
                "Bob:Bakso",
                "Alice:Es Teh",
                "Bob:Sate"
        };
        HashMap<String, Queue<String>> orders = buildOrders(data);
        System.out.println("=== ORDERS ===");
        System.out.println(orders);
        System.out.println();
        System.out.println("=== PROCESS ORDER ===");
        processOrders(orders);
        System.out.println();
        System.out.println("=== REMAINING ORDERS ===");
        System.out.println(orders);
    }
}