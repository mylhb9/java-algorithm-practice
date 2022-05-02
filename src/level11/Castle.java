package level11;

// 문제: 탑
// 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고, 각 탑의 꼭대기에 레이저 송신기를 설치
// 모든 탑의 레이저 송신기는 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사
// 하나의 탑에서 발사된 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능
// 6 9 5 7 4 자신보다 높은 탑만이 수신할 수 있음
// 탑들의 개수 N 과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느탑에서 수신하는지를 알아내는 프로그램을 작성

// 입력: 첫째 줄에 탑의 수를 나타내는 정수 N이 주어짐. (1<=N<=500,000)
// 둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어짐. 탑들의 높이는 (1이상 100,000,000이하)

import java.util.*;

// 출력: 주어진 탑들의 순서대로 각각의 탑들에서 발사한 신호를 수신한 탑들의 번호를 출력, 수신 탑이 존재하지 않으면 0 출력
public class Castle {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        List<Integer> lengthList = new ArrayList<>();
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = 0;
        for(int i=0; i<N; i++) {
            while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if(stack.empty()) {
                idx = 0;
            }
            if(!stack.empty() && arr[stack.peek()] >= arr[i]) {
                idx = stack.peek()+1;
            }

            stack.push(i);
            lengthList.add(idx);

        }

        for(int i=0; i<lengthList.size(); i++) {
            System.out.print(lengthList.get(i) + " ");
        }
    }
}
