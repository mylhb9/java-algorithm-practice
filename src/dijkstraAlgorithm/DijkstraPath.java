package dijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.HashMap;

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        ArrayList<Edge> nodeList;

        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));


        while(priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            // 최소 경로 distances 에 들어 있는 값이 현재 edge 에서 나온 currentDistance 값 보다 작다면 넘김
            // 무시해버리기

            if(distances.get(currentNode) < currentDistance) {
                continue;
            }
            nodeList = graph.get(currentNode);
            for(int i=0; i<nodeList.size(); i++) {
                adjacentNode = nodeList.get(i);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if(distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
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