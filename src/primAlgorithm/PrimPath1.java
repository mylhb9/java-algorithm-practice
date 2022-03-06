package primAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath1 {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdge;
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdges;
        PriorityQueue<Edge> priorityQueue;
        HashMap<String, ArrayList<Edge>> adjacentEdgeMap = new HashMap<>();

        for(int i=0; i<edges.size(); i++) {
            currentEdge = edges.get(i);
            if(!adjacentEdgeMap.containsKey(currentEdge.node1)) {
                adjacentEdgeMap.put(currentEdge.node1, new ArrayList<>());
            }
            if(!adjacentEdgeMap.containsKey(currentEdge.node2)) {
                adjacentEdgeMap.put(currentEdge.node2, new ArrayList<>());
            }
        }

        // HashMap 에 값을 추가함. 객체 참조 떄문에 잘 들어감
        for(int i=0; i<edges.size(); i++) {
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdgeMap.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdgeMap.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);

        candidateEdgeList = adjacentEdgeMap.getOrDefault(startNode, new ArrayList<>());
        priorityQueue = new PriorityQueue<>();
        for(int i=0; i<candidateEdgeList.size(); i++) {
            priorityQueue.offer(candidateEdgeList.get(i));
        }
        while(priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if(!connectedNodes.contains(poppedEdge.node2)) {
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdges = adjacentEdgeMap.getOrDefault(poppedEdge.node2, new ArrayList<>());
                for(int i=0; i<adjacentEdges.size(); i++) {
                    adjacentEdge = adjacentEdges.get(i);
                    if(!connectedNodes.contains(adjacentEdge.node2)) {
                        priorityQueue.offer(adjacentEdge);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        PrimPath1 pObject = new PrimPath1();
        System.out.println(pObject.primFunc("A", myedges));
    }
}
