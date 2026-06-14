package Latihan;

import java.util.ArrayList;
import java.util.Collections;

public class TournamentRanking {
    public static ArrayList<String> sortParticipants(String[] data) {ArrayList<String> participants = new ArrayList<>();
        for (String name : data) {
            participants.add(name);
        }
        Collections.sort(participants);
        return participants;
    }
    public static void printRanking(ArrayList<String> participants) {
        int rank = 1;
        for (String name : participants) {
            System.out.println(rank + ". " + name);
            rank++;
        }
    }

    public static void main(String[] args) {
        String[] data = {"Ayub", "Candra", "Bima", "Dika", "Eko"};
        ArrayList<String> participants =new ArrayList<>();
        for (String name : data) {
            participants.add(name);
        }
        System.out.println("=== BEFORE SORT ===");
        System.out.println(participants);
        System.out.println();
        participants = sortParticipants(data);
        System.out.println("=== AFTER SORT ===");
        printRanking(participants);
    }
}
