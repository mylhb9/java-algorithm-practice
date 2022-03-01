package primAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();


        // currentEdge 는 모든 Edge 정보를 가지고 있는 edges 중 한 개의 edge 임.
        // adjacentEdges 는 각 vertex 들이 가지고 있는 Edge 정보 리스트를 표현한 HashMap 임.
        // 그중에서 node2 는 가야할 노드를 의미함.
        // node1 은 출발할 노드를 의미함.
        // 아래의 식은 이를 초기화 시키는 것임.
        for(int i=0; i<edges.size(); i++) {
            currentEdge = edges.get(i);
            // currentEdge 의 출발할 노드에서 갈 노드가 포함돼있지 않다면
            // adjacentEdges 의 출발 노드에서 도착할 노드들 리스트를 초기화한다.
            if(!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<>());
            }
            // currentEdge 의 도착할 노드에서 갈 노드가 포함돼있지 않다면
            // adjacentEdges 의 도착 노드에서 도착할 노드들 리스트를 초기화한다.
            if(!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<>());
            }
        }
        // currentEdge 는 node1 과 node2 의 연결을 포함하는 edge 이다.
        // currentEdgeList 는 currentEdge 의 출발 노드인 node1 에서 갈 수 있는 리스트들을 담고, node1 -> node2 인 edge 를 추가시켰다.
        // adjacentEdges 에서 각각의 노드리스트들을 가져와서 node1과 node2의 연결을 추가시켰다
        for(int i=0; i<edges.size(); i++) {
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        // candidateEdgeList 는 HashMap 인 adjacentEdges 의 startNode 의 리스트이다.
        // PriorityQueue 에 startNode 에서 어느 노드로 갈지 정하는 edge 들을 넣을 수 있다.
        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<>());
        priorityQueue = new PriorityQueue<>();
        for(int i=0; i<candidateEdgeList.size(); i++) {
            priorityQueue.add(candidateEdgeList.get(i));
        }

        // priorityQueue 에 내용물이 하나도 없을 때까지
        while(priorityQueue.size() > 0) {
            // priorityQueue 에서 제일 가중치가 작은 값을 뽑는다.
            poppedEdge = priorityQueue.poll();
            // 만약 가중치가 가장 낮은 두 번째 노드가 연결된 노드에 포함되어 있지 않다면
            if(!connectedNodes.contains(poppedEdge.node2)) {
                // 연결된 노드 리스트에 추가한다.
                connectedNodes.add(poppedEdge.node2);
                // 최소신장트리에 이 Edge 를 추가한다.
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                // 가중치가 가장 낮은 노드가 가야할 노드들 리스트를 뽑은 것이 adjacentEdgeNodes 이다.
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<>());

                for(int i=0; i<adjacentEdgeNodes.size(); i++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);
                    // 가야할 노드가 연결된 노드 리스트들에 포함되지 않았다면 priorityQueue 에 추가한다
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
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

        PrimPath pObject = new PrimPath();
        System.out.println(pObject.primFunc("A", myedges));
    }
}
