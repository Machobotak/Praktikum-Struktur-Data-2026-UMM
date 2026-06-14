import java.util.*;

public class RailwayGraph {
    private HashMap<String, Station> stations;
    private HashMap<String, ArrayList<Route>> adjacencyList;

    public RailwayGraph() {
        stations = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addStation(Station station) {
        stations.put(station.getCode(), station);
        adjacencyList.putIfAbsent(station.getCode(), new ArrayList<>());
    }

    public void addRoute(String from, String to, int distance, int timeTravel, double fare) {
        if(!stations.containsKey(from)||!stations.containsKey(to)){
            System.out.println("Station not found");
            return;
        }
        adjacencyList.get(from).add(new Route(to, distance, timeTravel, fare));
        adjacencyList.get(to).add(new Route(from, distance, timeTravel, fare));
    }

    public void getConnections(String stationCode){
        if(!stations.containsKey(stationCode)){
            System.out.println("Station not found");
            return;
        }

        System.out.println("\nConnection from "+stationCode);
        for (Route route : adjacencyList.get(stationCode)){
            System.out.println(route);
        }
    }

    public void removeRoute(String from, String to) {
        adjacencyList.get(from).removeIf(r -> r.getDestination().equals(to));
        adjacencyList.get(to).removeIf(r -> r.getDestination().equals(from));
    }

    public void removeStation(String stationCode) {
        if(!stations.containsKey(stationCode)){
            return;
        }
        adjacencyList.remove(stationCode);
        for(ArrayList<Route> routes: adjacencyList.values()){
            routes.removeIf(r -> r.getDestination().equals(stationCode));
        }
        stations.remove(stationCode);
    }

    public void bfsTraversal(String stationCode){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(stationCode);
        queue.offer(stationCode);

        System.out.println("\nBFS Traversal:");
        while(!queue.isEmpty()){
            String cur = queue.poll();
            System.out.print(cur+" ");
            for(Route route: adjacencyList.get(cur)){
                String next = route.getDestination();
                if(!visited.contains(next)){
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        System.out.println();
    }

    public void findPathBFS(String start, String end){
        Queue<String> queue = new LinkedList<>();
        Map<String,String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(cur.equals(end)){
                break;
            }
            for(Route route: adjacencyList.get(cur)){
                String next = route.getDestination();
                if(!visited.contains(next)){
                    visited.add(next);
                    parent.put(next,cur);
                    queue.offer(next);
                }
            }
        }
        if(!visited.contains(end)){
            System.out.println("Path not found");
            return;
        }
        ArrayList<String> path = new ArrayList<>();
        String cur = end;
        while(cur!=null){
            path.add(cur);
            cur = parent.get(cur);
        }
        Collections.reverse(path);
        System.out.println("\nShortest Path:");
        System.out.println(path);
    }

    public void dfsTraversal(String startCode){
        Set<String> visited = new HashSet<>();
        System.out.println("\nDFS Traversal:");
        dfsHelper(startCode,visited);
        System.out.println();

    }

    private void dfsHelper(String cur, Set<String> visited){
        visited.add(cur);
        System.out.println(cur+" ");
        for(Route route: adjacencyList.get(cur)){
            String next = route.getDestination();
            if(!visited.contains(next)){
                dfsHelper(next,visited);
            }
        }
    }






}
