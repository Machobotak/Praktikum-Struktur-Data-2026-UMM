public class Main {

    public static void main(String[] args) {
        RailwayGraph graph =new RailwayGraph();
        graph.addStation(new Station("MLG","Malang","Malang"));
        graph.addStation(new Station("SBY", "Surabaya", "Surabaya"));
        graph.addStation(new Station("BL", "Blitar", "Blitar"));
        graph.addStation(new Station("KDR", "Kediri", "Kediri"));
        graph.addStation(new Station("JMB", "Jombang", "Jombang"));

        graph.addRoute("MLG", "SBY", 95, 120, 25000);
        graph.addRoute("MLG", "BL", 80, 90, 20000);
        graph.addRoute("BL", "KDR", 50, 60, 15000);
        graph.addRoute("SBY", "JMB", 120, 150, 35000);
        graph.addRoute("JMB", "KDR", 60, 70, 20000);


        graph.getConnections("MLG");
        graph.bfsTraversal("MLG");
        graph.dfsTraversal("MLG");
        graph.findPathBFS("MLG", "KDR");

        graph.removeStation("MLG");
        graph.getConnections("MLG");
        graph.getConnections("SBY");

    }
}