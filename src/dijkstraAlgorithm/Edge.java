package dijkstraAlgorithm;

public class Edge implements Comparable<Edge>{
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }

    @Override
    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }
}