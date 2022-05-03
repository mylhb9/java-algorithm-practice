package level13;

// 문제: 트리의높이
// 트리의 높이는 루트로부터 가장 멀리 떨어진 노드와의 거리이다.
// 트리가 주어지면, 그 트리의 높이를 출력

// 입력: 첫 번째 줄에 노드 개수 n, 루트노드의 번호 r이 주어진다.
// 두 번째 줄부터 트리의 간선정보가 주어진다.
// 각 줄은 a, b로 이루어지며 a번 노드와 b번 노드가 서로 연결되어 있다는 뜻이다.
// 각 노드의 번호는 0 ~ n-1 까지 존재한다
// 연결이 되지 않은 노드는 없다.

// 출력: 트리의 높이를 출력한다.

import java.util.*;

public class TreeHeight {
    boolean[] visited = new boolean[101];
    Map<Integer, List<Integer>> graph;
    int count = 0;
    int max = 0;
    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                count++;
                DFS(y);
                if(count > max) {
                    max = count;
                }
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<=n-1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        TreeHeight m = new TreeHeight();
        m.graph = graph;
        m.DFS(r);
        System.out.println(m.max);

    }
}
