package Latihan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryBorrowing {

    public static HashMap<String, ArrayList<String>>
    groupBooks(String[] transactions) {
        HashMap<String, ArrayList<String>> map =new HashMap<>();
        for (String transaction : transactions) {
            String[] data = transaction.split(":");
            String student = data[0];
            String book = data[1];
            map.putIfAbsent(student,new ArrayList<>());
            map.get(student).add(book);
        }
        return map;
    }
    public static void printRanking(
            HashMap<String, ArrayList<String>> data) {ArrayList<Map.Entry<String, ArrayList<String>>> ranking = new ArrayList<>(data.entrySet());
        ranking.sort((a, b) -> b.getValue().size() - a.getValue().size());
        int rank = 1;
        for (Map.Entry<String, ArrayList<String>> entry : ranking) {
            System.out.println("#" + rank + " " + entry.getKey() + " : " + entry.getValue().size() + " books"
            );
            rank++;
        }
    }
    public static void main(String[] args) {
        String[] transactions = {
                "Ayub:Java", "Bima:Python", "Ayub:DSA", "Candra:SQL", "Ayub:Graph", "Bima:OOP"};
        HashMap<String, ArrayList<String>> result = groupBooks(transactions);
        System.out.println("=== GROUPED BOOKS ===");
        for (Map.Entry<String, ArrayList<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue()
            );
        }
        System.out.println();
        System.out.println("=== RANKING ===");
        printRanking(result);
    }
}
