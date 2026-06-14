package Task1;

import java.util.LinkedList;
import java.util.Queue;

public class StationHierarchy {
    private StationNode root;

    public void setRoot(StationNode root) {
        this.root = root;
    }

    public StationNode findStation(String code){
        return findRecursive(root,code);
    }

    public StationNode findRecursive(StationNode current,String code){
        if(current==null){
            return null;
        }
        if(current.StationCode.equals(code)){
            return current;
        }
        for(StationNode child : current.children){
            StationNode found = findRecursive(child,code);
            if(found!=null){
                return found;
            }
        }
        return null;
    }

    public void addStation(String parentCode, StationNode newStation){
        StationNode parent = findStation(parentCode);

        if(parent!=null){
            parent.addChild(newStation);
            System.out.println("Station added successfully");
        }else {
            System.out.println("Parent station not found");
        }
    }

    public void removeStation(String stationCode){
        StationNode target = findStation(stationCode);
        if(target==null){
            System.out.println("Station not found");
            return;
        }

        if(target==root){
            if(root.children.isEmpty()){
                root = null;
            }
            else{
                root = root.children.get(0);
                root.parent = null;
                for(int i = 1; i < target.children.size(); i++){
                    root.addChild(target.children.get(i));
                }
            }
            System.out.println("Root station removed");
            return;
        }

        StationNode parent = target.parent;
        for(StationNode child : target.children){
            parent.addChild(child);
        }
        parent.removeChild(target);
        System.out.println("Station removed successfully");
    }

    public void preOrderTraversal() {
        System.out.println("preOrderTraversal");
        preOrder(root);
    }

    private void preOrder(StationNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        for (StationNode child : node.children) {
            preOrder(child);
        }
    }

    public void postOrderTraversal(){
        System.out.println("Post Oder Traversal");
        postOrder(root);
    }

    private void postOrder(StationNode node){
        if(node==null){
            return;
        }
        for(StationNode child : node.children){
            postOrder(child);
        }
        System.out.println(node);
    }

    public void levelOrderTraversal(){
        System.out.println("Level Order Traversal");
        if (root == null) {
            return;
        }

        Queue<StationNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            StationNode current = queue.poll();
            System.out.println(current);
            for (StationNode child : current.children) {
                queue.add(child);
            }
        }
    }

    public int totalStations() {
        return countNodes(root);
    }

    private int countNodes(StationNode node) {
        if (node == null) {
            return 0;
        }
        int count = 1;
        for (StationNode child : node.children) {
            count += countNodes(child);
        }

        return count;
    }

    public int treeHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(StationNode node) {
        if (node == null) {
            return -1;
        }
        int maxHeight = -1;
        for (StationNode child : node.children) {
            maxHeight = Math.max(maxHeight, calculateHeight(child));
        }
        return maxHeight + 1;
    }

    private int countLeaf(StationNode node) {
        if (node == null) {
            return 0;
        }
        if(node.isLeaf()){
            return 1;
        }
        int total = 0;
        for (StationNode child : node.children) {
            total += countLeaf(child);
        }
        return  total;
    }

    public int calculateLeaf() {
        return countLeaf(root);
    }

}
