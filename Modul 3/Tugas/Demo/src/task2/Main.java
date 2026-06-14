package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Queue queue = new Queue();
        Stack history = new Stack();

        int choice;

        do {
            System.out.println("\n=== Railway Ticket Service ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. Display Queue");
            System.out.println("3. Serve Passenger");
            System.out.println("4. Undo Last Transaction");
            System.out.print("Choose menu: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = input.nextLine();
                    queue.enqueue(name);
                    System.out.println("Passenger added to queue.");
                    break;

                case 2:
                    System.out.println("Current Queue:");
                    queue.display();
                    break;

                case 3:
                    String served = queue.dequeue();
                    if (served != null) {
                        System.out.println("Serving passenger: " + served);
                        history.push(served);
                        System.out.println("Transaction saved.");
                    } else {
                        System.out.println("Queue kosong.");
                    }
                    break;

                case 4:
                    String undo = history.pop();
                    if (undo != null) {
                        System.out.println("Undo transaction for passenger: " + undo);
                        queue.enqueue(undo);
                    } else {
                        System.out.println("Tidak ada transaksi untuk di-undo.");
                    }
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }

        } while (choice >= 1 && choice <= 4);

        input.close();
    }
}
