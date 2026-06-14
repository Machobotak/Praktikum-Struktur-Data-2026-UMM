package Task2;

public class EmployeeBST {

    private BSTNode root;
    public void insert(Employee employee) {
        root = insertRecursive(root, employee);
    }

    private BSTNode insertRecursive(BSTNode current, Employee employee) {
        if (current == null) {
            return new BSTNode(employee);
        }

        if (employee.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, employee);
        }
        else if (employee.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, employee);
        }
        return current;
    }


    public Employee search(int id) {
        BSTNode result = searchRecursive(root, id);
        if (result != null) {
            return result.data;
        }
        return null;
    }

    private BSTNode searchRecursive(BSTNode current, int id) {
        if (current == null ||
                current.data.employeeId == id) {
            return current;
        }
        if (id < current.data.employeeId) {
            return searchRecursive(current.left, id);
        }
        return searchRecursive(current.right, id);
    }

    public void delete(int id) {
        root = deleteRecursive(root, id);
    }

    private BSTNode deleteRecursive(BSTNode current, int id) {
        if (current == null) {
            return null;
        }

        if (id < current.data.employeeId) {
            current.left = deleteRecursive(current.left, id);
        }

        else if (id > current.data.employeeId) {
            current.right = deleteRecursive(current.right, id);
        }

        else {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }
            Employee successor = findMin(current.right);
            current.data = successor;
            current.right = deleteRecursive(current.right, successor.employeeId);
        }

        return current;
    }


    public Employee findMin() {
        return findMin(root);
    }

    private Employee findMin(BSTNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }


    public Employee findMax() {
        BSTNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public void inorderTraversal() {
        System.out.println("\n=== INORDER ===");
        inorderRecursive(root);
    }

    private void inorderRecursive(BSTNode current) {
        if (current != null) {
            inorderRecursive(current.left);
            System.out.println(current.data);
            System.out.println("----------------");
            inorderRecursive(current.right);
        }
    }


    public void preorderTraversal() {
        System.out.println("\n=== PREORDER ===");
        preorderRecursive(root);
    }

    private void preorderRecursive(BSTNode current) {
        if (current != null) {
            System.out.println(current.data);
            System.out.println("----------------");
            preorderRecursive(current.left);
            preorderRecursive(current.right);
        }
    }

    public void postorderTraversal() {
        System.out.println("\n=== POSTORDER ===");
        postorderRecursive(root);
    }

    private void postorderRecursive(BSTNode current) {
        if (current != null) {
            postorderRecursive(current.left);
            postorderRecursive(current.right);
            System.out.println(current.data);
            System.out.println("----------------");
        }
    }
}