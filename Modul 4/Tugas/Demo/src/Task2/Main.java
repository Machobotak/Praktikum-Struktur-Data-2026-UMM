package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeBST bst = new EmployeeBST();

        Employee employee1 = new Employee(10,"ayub","acara");
        bst.insert(employee1);
        Employee employee2 = new Employee(2,"karan","si");
        bst.insert(employee2);
        Employee employee3 = new Employee(23,"budi","pdd");
        bst.insert(employee3);
        Employee employee4 = new Employee(5,"fahmi","si");
        bst.insert(employee4);

        int choice;
        do {
            System.out.println("\n===== EMPLOYEE BST MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Find Minimum");
            System.out.println("8. Find Maximum");
            System.out.println("9. Exit");
            System.out.print("Choose Menu : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Employee ID : ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Employee Name : ");
                    String name = input.nextLine();
                    System.out.print("Department : ");
                    String department = input.nextLine();
                    Employee employee = new Employee(id, name, department);
                    bst.insert(employee);
                    System.out.println("Employee inserted.");
                    break;
                case 2:
                    System.out.print("Input Employee ID : ");
                    int searchId = input.nextInt();
                    Employee found = bst.search(searchId);
                    if (found != null) {
                        System.out.println("\nEmployee Found");
                        System.out.println(found);
                    } else {
                        System.out.println("\nEmployee Not Found");
                    }
                    break;
                case 3:
                    System.out.print("Input Employee ID to Delete : ");
                    int deleteId = input.nextInt();
                    bst.delete(deleteId);
                    System.out.println("Employee deleted.");
                    break;
                case 4:
                    bst.inorderTraversal();
                    break;
                case 5:
                    bst.preorderTraversal();
                    break;
                case 6:
                    bst.postorderTraversal();
                    break;
                case 7:
                    System.out.println("\nMinimum Employee");
                    System.out.println(bst.findMin());
                    break;
                case 8:
                    System.out.println("\nMaximum Employee");
                    System.out.println(bst.findMax());
                    break;
                case 9:
                    System.out.println("Program Ended.");
                    break;
                default:
                    System.out.println("Invalid Menu.");
            }

        } while (choice != 9);

        input.close();
    }
}
