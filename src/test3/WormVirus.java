package test3;

import java.util.*;

// 문제: 1번 컴퓨터를 통해 원 바이러스에 걸리게 되는 컴퓨터 수를 출력
public class WormVirus {
    boolean[] visited;
    Map<Integer, List<Integer>> graph;
    int count = 0;
    public void DFS(int x) {
        visited[x] = true;
        count++;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                DFS(y);
            }
        }
    }

    public static void main(String[] args) {
// 입력: 첫째 줄에 컴퓨터의 수 N 이 주어진다. 둘째 줄에는 컴퓨터 연결 쌍의 수가 주어진다.
// 이어서는 한 줄에 한 쌍씩 네트워크 쌍에서 연결되어있는 컴퓨터의 번호 쌍이 주어진다.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }

        String[][] inputArr = new String[M][2];
        for(int i=0; i<M; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }

        WormVirus m = new WormVirus();
        m.graph = graph;
        m.visited = new boolean[N+1];


// 출력: 1번 컴퓨터가 바이러스에 걸렸을 때, 이를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력
        m.DFS(1);
        System.out.println(m.count-1);
    }
}
