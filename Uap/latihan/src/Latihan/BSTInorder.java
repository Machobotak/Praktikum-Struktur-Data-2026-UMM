package Latihan;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class BSTInorder {
    Node root;
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BSTInorder bst = new BSTInorder();
        int[] data = {50, 30, 70, 20, 40, 60, 80};
        for (int x : data) {bst.root = bst.insert(bst.root, x);
        }
        System.out.println("Inorder Traversal:");
        bst.inorder(bst.root);
    }
}