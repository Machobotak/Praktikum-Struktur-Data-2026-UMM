package Latihan;

import java.util.HashMap;

class Node1 {
    int id;
    Node1 left;
    Node1 right;
    Node1(int id) {
        this.id = id;
    }
}

public class StudentBST {
    Node1 root;
    HashMap<Integer, String> students = new HashMap<>();
    public Node1 insert(Node1 root, int id) {
        if (root == null) {
            return new Node1(id);
        }
        if (id < root.id) {
            root.left = insert(root.left, id);
        } else {
            root.right = insert(root.right, id);
        }
        return root;
    }

    public boolean search(Node1 root, int target) {
        if (root == null) {
            return false;
        }

        if (root.id == target) {
            return true;
        }

        if (target < root.id) {
            return search(root.left, target);
        }
        return search(root.right, target);
    }

    public static void main(String[] args) {
        StudentBST bst = new StudentBST();
        bst.students.put(101, "Ayub");
        bst.students.put(102, "Bima");
        bst.students.put(103, "Candra");
        bst.root = bst.insert(bst.root, 101);
        bst.root = bst.insert(bst.root, 102);
        bst.root = bst.insert(bst.root, 103);
        int searchID = 102;
        if (bst.search(bst.root, searchID)) {
            System.out.println("ID : " + searchID);
            System.out.println("Nama : " + bst.students.get(searchID));
        } else {
            System.out.println("Mahasiswa tidak ditemukan");
        }
    }
}