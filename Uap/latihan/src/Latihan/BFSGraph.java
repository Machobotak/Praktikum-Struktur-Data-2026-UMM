package Latihan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    private HashMap<String, ArrayList<String>> graph;
    public BFSGraph() {
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
    public void bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbor :
                    graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph g = new BFSGraph();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        System.out.println("BFS Traversal:");
        g.bfs("A");
    }
}
