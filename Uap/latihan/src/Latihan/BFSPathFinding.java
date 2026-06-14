package Latihan;

import java.util.*;

public class BFSPathFinding {
    private HashMap<String, ArrayList<String>> graph;
    public BFSPathFinding() {
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

    public List<String> findPathBFS(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashMap<String, String> parent = new HashMap<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                break;
            }
            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        ArrayList<String> path = new ArrayList<>();
        String step = end;
        while (step != null) {
            path.add(step);
            step = parent.get(step);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        BFSPathFinding g = new BFSPathFinding();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "E");
        g.addEdge("D", "F");
        System.out.println("Path:");
        System.out.println(g.findPathBFS("A", "F"));
    }
}
