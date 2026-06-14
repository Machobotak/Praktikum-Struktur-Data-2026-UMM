package Latihan;

import java.util.HashMap;
import java.util.Stack;

public class KnightMissionHistory {

    public static HashMap<String, Stack<String>>
    buildHistory(String[] data) {HashMap<String, Stack<String>> map = new HashMap<>();
        for (String d : data) {String[] temp = d.split(":");
            String knight = temp[0];
            String mission = temp[1];
            map.putIfAbsent(knight, new Stack<>());
            map.get(knight).push(mission);
        }
        return map;
    }
    public static void printHistory(
            HashMap<String, Stack<String>> history) {
        for (String knight : history.keySet()) {
            System.out.println(knight);
            while (!history.get(knight).isEmpty()) {System.out.println(history.get(knight).pop());
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String[] data = {
                "Arthur:Dragon Hunt",
                "Arthur:Castle Defense",
                "Lancelot:Goblin Raid",
                "Arthur:Rescue Princess",
                "Lancelot:Treasure Hunt"
        };
        HashMap<String, Stack<String>> history = buildHistory(data);
        System.out.println("=== MISSION HISTORY ===\n");
        printHistory(history);
    }
}
