package upgradePrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        ArrayList<Path> mst = new ArrayList<>();
        PriorityQueue<Edge> keys = new PriorityQueue();
        HashMap<String, Edge> keyObjects = new HashMap<>();
        HashMap<String, String> mstPath = new HashMap<>();
        Edge edgeObject, poppedEdge, linekdEdge;
        HashMap<String ,Integer> linkedEdges;

        for(String key : graph.keySet()) {
            if(key == startNode) {
                edgeObject = new Edge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            keys.offer(edgeObject);
            keyObjects.put(key, edgeObject);
        }

        while(keys.size() > 0) {
            poppedEdge = keys.poll();
            keyObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));

            linkedEdges = graph.get(poppedEdge.node);
            for(String adjacent : linkedEdges.keySet()) {
                if(keyObjects.containsKey(adjacent)) {
                    linekdEdge = keyObjects.get(adjacent);
                    if(linkedEdges.get(adjacent) < linekdEdge.weight) {
                        linekdEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);
                        keys.remove(linekdEdge);
                        keys.add(linekdEdge);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<String, HashMap<String, Integer>>();

        HashMap<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);


        PrimPath pObject = new PrimPath();
        System.out.println(pObject.improvedPrimFunc(mygraph, "A"));
    }
}
