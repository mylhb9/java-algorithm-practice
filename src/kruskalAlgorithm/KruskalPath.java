package kruskalAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalPath {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public String find(String node) {
        if(parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        System.out.println("root1: " + root1);
        String root2 = find(nodeU);
        System.out.println("root2: " + root2);

        // union-by-rank 기법
        if(rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if(rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> nodes, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1. 초기화
        for(int i=0; i< nodes.size(); i++) {
            this.makeSet(nodes.get(i));
        }

        // 2. Edge 의 weight 기반으로 sorting
        Collections.sort(edges);
        System.out.println(edges);
        // 3. nodeV 와 nodeU 의 루트노드가 다르면 서로 연결
        for(int i=0; i<edges.size(); i++) {
            currentEdge = edges.get(i);
            if(find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<String> nodes = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
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


        KruskalPath kObject = new KruskalPath();

        System.out.println(kObject.kruskalFunc(nodes, edges));
        System.out.println(kObject.parent);

    }
}
