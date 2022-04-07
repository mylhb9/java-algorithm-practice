package part10;


import java.util.*;

// 문제: 어떤 컴퓨터가 웜 바이러스에 걸렸을 때, 이 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력해라
// 입력: 컴퓨터의 수 N 이 주어진다. 100 이하이고, 각 컴퓨터에는 1번부터 N번까지 차례로 번호가 매겨진다.
// 네트워크 상에서 직접 연결돼 있는 컴퓨터 쌍의 수 M 이 주어진다. 이어서 한 줄에 한 쌍 네트워크 상에서 직접 연결돼 있는 컴퓨터의 번호쌍이
// 주어진다
// 출력: 1번 컴퓨터가 웜 바이러스에 걸리면, 이를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력한다.
public class WormVirus1 {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
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
        WormVirus1 m = new WormVirus1();
        m.visited = new boolean[101];
        Arrays.fill(m.visited, false);
        m.graph = graph;
        m.DFS(1);

        System.out.println(m.count-1);
    }
}

// 1 --- 2 --- 3
// |   /
// |  /   4 --- 7
// | /
// 5 --- 6
