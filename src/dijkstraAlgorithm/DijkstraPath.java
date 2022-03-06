package dijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.HashMap;

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edge, adjacentEdge;
        int currentDistance, adjacentDistance, distance;
        String currentVertex, adjacentVertex;
        ArrayList<Edge> edgeList = new ArrayList<>();

        HashMap<String, Integer> distances = new HashMap<>();
        for(String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(distances.get(start), start));

        while(priorityQueue.size() > 0) {
            edge = priorityQueue.poll();
            currentDistance = edge.distance;
            currentVertex = edge.vertex;

            if(distances.get(currentVertex) < currentDistance) {
                continue;
            }

            edgeList = graph.get(currentVertex);
            for(int i=0; i<edgeList.size(); i++) {
                adjacentEdge = edgeList.get(i);
                adjacentVertex = adjacentEdge.vertex;
                adjacentDistance = adjacentEdge.distance;
                distance = adjacentDistance + currentDistance;

                if(distance < distances.get(adjacentVertex)) {
                    distances.put(adjacentVertex, distance);
                    priorityQueue.offer(new Edge(distance, adjacentVertex));
                }
            }


        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge(5, "A"))));

        DijkstraPath dp = new DijkstraPath();
        System.out.println(dp.dijkstraFunc(graph, "A"));
    }
}