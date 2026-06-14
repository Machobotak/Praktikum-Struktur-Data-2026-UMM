package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StationHierarchy railway = new StationHierarchy();

        StationNode mainStation = new StationNode("01", "Central Station", "Jakarta");
        railway.setRoot(mainStation);

        railway.addStation("01", new StationNode("02", "North Station", "Jakarta Utara"));
        railway.addStation("01", new StationNode("03","South Station", "Jakarta Selatan"));
        railway.addStation("02", new StationNode("04", "Harbor Station", "Tanjung Priok"));
        railway.addStation("02", new StationNode("05","Beach Station","Ancol"));
        railway.addStation("03",new StationNode("06","City Station","Blok M"));

        int choice;

        do {
            System.out.println("\n===== RAILWAY STATION HIERARCHY =====");
            System.out.println("1. Add Station");
            System.out.println("2. Find Station");
            System.out.println("3. Remove Station");
            System.out.println("4. PreOrder Traversal");
            System.out.println("5. PostOrder Traversal");
            System.out.println("6. LevelOrder Traversal");
            System.out.println("7. Tree Statistics");
            System.out.println("8. Exit");
            System.out.print("Choose menu : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Parent Station Code : ");
                    String parentCode = input.nextLine();
                    System.out.print("Station Code : ");
                    String code = input.nextLine();
                    System.out.print("Station Name : ");
                    String name = input.nextLine();
                    System.out.print("Region : ");
                    String region = input.nextLine();
                    StationNode newStation = new StationNode(code, name, region);
                    railway.addStation(parentCode, newStation);
                    break;
                case 2:
                    System.out.print("Input Station Code : ");
                    String findCode = input.nextLine();
                    StationNode found = railway.findStation(findCode);
                    if (found != null) {
                        System.out.println("\nStation Found");
                        System.out.println(found);
                    } else {
                        System.out.println("\nStation Not Found");
                    }
                    break;
                case 3:
                    System.out.print("Input Station Code to Remove : ");
                    String removeCode = input.nextLine();
                    railway.removeStation(removeCode);
                    break;
                case 4:
                    railway.preOrderTraversal();
                    break;
                case 5:
                    railway.postOrderTraversal();
                    break;
                case 6:
                    railway.levelOrderTraversal();
                    break;
                case 7:
                    System.out.println("\n===== TREE STATISTICS =====");
                    System.out.println("Total Stations : " + railway.totalStations());
                    System.out.println("Tree Height : " + railway.treeHeight());
                    System.out.println("Total Leaf : "+railway.calculateLeaf());
                    break;
                case 8:
                    System.out.println("Program Ended.");
                    break;
                default:
                    System.out.println("Invalid Menu.");
            }
        } while (choice != 8);
        input.close();
    }
}