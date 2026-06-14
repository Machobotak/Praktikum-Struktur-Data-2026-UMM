package Latihan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RailwayGraph {
    private HashMap<String, ArrayList<String>> graph;
    public RailwayGraph() {
        graph = new HashMap<>();
    }

    public void addVertex(String station) {
        graph.putIfAbsent(station, new ArrayList<>());
    }

    public void addEdge(String source, String destination) {
        addVertex(source);
        addVertex(destination);
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public void printGraph() {
        for (Map.Entry<String, ArrayList<String>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        RailwayGraph railway = new RailwayGraph();
        railway.addEdge("Malang", "Surabaya");
        railway.addEdge("Surabaya", "Madiun");
        railway.addEdge("Malang", "Blitar");
        railway.addEdge("Madiun", "Solo");
        System.out.println("=== RAILWAY GRAPH ===\n");
        railway.printGraph();
    }
}