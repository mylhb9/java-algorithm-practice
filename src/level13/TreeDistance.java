package level13;

// 문제: 트리에서의 거리
// 트리가 주어지고, 두 노드 X, Y 가 주어질 때. 두 노드 사이의 거리를 출력하는 프로그램을 작성
// 두 노드를 잇는 경로가 유일하여 정답은 항상 유일함

// 입력: 첫 번째 줄은 노드 개수 n, 두 노드 X, Y 의 번호가 주어짐
// 두 번째 줄부터 트리의 간선 정보가 주어짐
// 각 줄은 2개의 숫자 a , b로 이루어지며, 노드 a가 노드 b의 부모노드라는 것을 의미함
// 루트는 노드 0 이라고 가정

// 출력: 두 노드 X, Y 사이의 거리를 출력

import java.util.*;

public class TreeDistance {
    boolean[] visited = new boolean[1001];
    Map<Integer, List<Integer>> graph;
    int count = 0;
    public void DFS(int x, int y) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int a = graph.get(x).get(i);
            if(!visited[a]) {
                count++;
                if(a == y) {
                    System.out.println(count);
                    return;
                }
                DFS(a, y);
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        TreeDistance m = new TreeDistance();
        m.graph = graph;
        m.DFS(X, Y);
    }
}
