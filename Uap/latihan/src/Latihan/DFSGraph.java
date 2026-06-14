package Latihan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DFSGraph {
    private HashMap<String, ArrayList<String>> graph;
    public DFSGraph() {
        graph = new HashMap<>();
    }

    public void addVertex(String vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination) {
        addVertex(source);
        addVertex(destination);
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public void dfs(String current, HashSet<String> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (String neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public void startDFS(String start) {
        HashSet<String> visited = new HashSet<>();
        dfs(start, visited);
    }

    public static void main(String[] args) {
        DFSGraph g = new DFSGraph();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        System.out.println("DFS Traversal:");
        g.startDFS("A");
    }
}
