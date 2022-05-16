package level20;

import java.util.*;

class Edge {
    int start;
    int end;
    int value;
}

class MyComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge e1, Edge e2) {
        if(e1.value > e2.value) {
            return 1;
        }
        return -1;
    }
}

public class Party {
    int[] parent = new int[1001];
    public static Edge makeEdges(int a, int b, int c) {
        Edge edge = new Edge();
        edge.start = a;
        edge.end = b;
        edge.value = c;
        return edge;
    }

    public int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            int y = find(parent[x]);
            parent[x] = y;
            return y;
        }
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return false;
        } else {
            parent[rootA] = rootB;

            return true;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        List<Edge> edgeList = new ArrayList<>();
        for(int i=0; i<M; i++) {
            edgeList.add(makeEdges(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        MyComparator myComparator = new MyComparator();
        Collections.sort(edgeList, myComparator);

        Party m = new Party();
        for(int i=1; i<=N; i++) {
            m.parent[i] = i;
        }

        int result = 0;

        for(int i=0; i<M; i++) {
            if(m.union(K, edgeList.get(i).end)) {
                result += edgeList.get(i).value;
            }
        }

        System.out.println(result);
    }
}
