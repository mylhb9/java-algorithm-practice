package kruskalAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Edge implements Comparable<Edge>{
    public int weight;
    public String nodeU;
    public String nodeV;

    public Edge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeU = nodeU;
        this.nodeV = nodeV;
    }

    @Override
    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

    public static void main(String[] args) {
        ArrayList<String> vetices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        System.out.println(vetices);
        System.out.println(edges);
    }
}
