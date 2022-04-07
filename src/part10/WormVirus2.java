package part10;


import java.util.*;

// 문제: 웜 바이러스는 네트워크를 통해서 전파됨. 네트워크 상에 연결되어있는 모든 컴퓨터가 감염됨
// 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 컴퓨터의 수와 네트워크 상에서 서로 연결돼있는 정보가 주어지면, 1번 컴퓨터를 통해서
// 웜바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성
public class WormVirus2 {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    int count = 0;
    public void getComputerNum(int x) {
        visited[x] = true;
        count++;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                getComputerNum(y);
            }
        }
    }

    public static void main(String[] args) {
        // 입력: 첫째 줄에는 컴퓨터의 수 N이 주어진다.
        // 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1~N 까지의 번호가 차례로 매겨진다.
        // 둘째 줄에는 네트워크 상에서 직접 연결되어있는 컴퓨터쌍의 수 M이 주어진다.
        // 이어서 그 수만큼 한줄에 한 쌍씩 네트워크 상에서 직접 연결돼 있는 컴퓨터의 번호쌍이 주어짐
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



        WormVirus2 m = new WormVirus2();
        m.graph= graph;
        m.visited = new boolean[N+1];
        m.getComputerNum(1);

        // 출력: 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게되는 컴퓨터의 수를 출력
        System.out.println(m.count-1);
    }
}
