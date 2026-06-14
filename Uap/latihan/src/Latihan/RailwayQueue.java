package Latihan;

import java.util.HashMap;
import java.util.LinkedList;

public class RailwayQueue {
    public static HashMap<String, LinkedList<String>> buildQueue(String[] data) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (String d : data) {
            String[] temp = d.split(":");
            String station = temp[0];
            String passenger = temp[1];
            map.putIfAbsent(station, new LinkedList<>());
            map.get(station).add(passenger);
        }
        return map;
    }

    public static void servePassengers(HashMap<String, LinkedList<String>> queues){
        for (String station : queues.keySet()) {
            if(!queues.get(station).isEmpty()){
                String served = queues.get(station).poll();
                System.out.println(station+" serves "+served);
            }
        }
    }

    static void main() {
        String[] data = {
                "Malang:Ayub",
                "Malang:Bima",
                "Surabaya:Candra",
                "Malang:Dika"
        };

        HashMap<String, LinkedList<String>> queues =buildQueue(data);

        System.out.println("Sebelum dilayani:");
        System.out.println(queues);

        servePassengers(queues);

        System.out.println("\nSetelah dilayani:");
        System.out.println(queues);
    }
}
