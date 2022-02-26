package bfsAndDfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFSSearch {
    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while(needVisit.size() > 0) {
            String node = needVisit.remove(0);

            if(!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        BFSSearch bs = new BFSSearch();
        System.out.println(bs.bfsFunc(graph, "A"));
    }
}
