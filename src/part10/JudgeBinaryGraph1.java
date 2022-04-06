package part10;

// 문제: 이분 그래프란, 정점을 크게 두 집합으로 나눌 수 있는 그래프를 말함
// 이떄 같은 집합에 속한 정점끼리는 간선이 존재해서는 안된다.
// 같은 집합에 속한 정점 사이에는 간선이 존재하지 않으므로 이분 그래프라고 할 수 있겠다.

// 입력: 정점의 개수 N개와 간선의 개수 M개가 주어진다.
// 2<=N<=1000, N-1<=M<=100000
// 둘째 줄부터 간선의 정보가 주어진다.
// 두 정보는 두 정점이 연결되어있다는 의미이다.
// 출력: 그래프가 이분 그래프이면 YES 아니면 NO를 출력한다.

import java.util.*;

public class JudgeBinaryGraph1 {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    boolean[] check1;
    boolean check = false;
    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);

            if(!visited[y]) {


                check1[y] = !check1[x];


                DFS(y);
            } else {
                if(check1[y] == check1[x]) {
                    check = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        String[][] inputArr = new String[M][2];
        for(int i=0; i<M; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }
        JudgeBinaryGraph1 m = new JudgeBinaryGraph1();
        m.graph = graph;
        m.visited = new boolean[1005];
        m.check1 = new boolean[1005];
        m.check1[0] = false;
        Arrays.fill(m.visited, false);

        m.DFS(Integer.parseInt(inputArr[0][0]));
        if(m.check) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }
}
