package part11;

import java.util.*;

// 문제: 숫자 N이 주어질 떄, 계산기를 작동시켜 숫자 N을 만드릭 위하여 최소 몇 번 버튼을 눌러야하는지 프로그램 작성
// 계산결과를 최대 5자리로 유지해야한다. 그 이상을 넘어가 버리면 계산기가 고장나버린다.
public class WeirdCalculator {
    boolean[] check = new boolean[100001];
    Integer[] arr = new Integer[100001];
    Queue<Integer> queue = new LinkedList<>();
    public void BFS() {
        queue.offer(1);
        check[1] = true;
        arr[1] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current*2 <100000 && !check[current*2]) {
                arr[current*2] = arr[current]+1;
                queue.offer(current*2);
                check[current*2] = true;
            }

            if(current/3 !=0 && !check[current/3]) {
                arr[current/3] = arr[current]+1;
                queue.offer(current/3);
                check[current/3] = true;
            }


        }

    }

    public static void main(String[] args) {
// 입력: 숫자 N이 주어진다. 계산기로 만들 수 없는 값은 주어지지 않는다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        WeirdCalculator m = new WeirdCalculator();
        m.BFS();

// 출력: 이상한 계산기로 숫자 N을 만들기 위해 눌러야 하는 최소 버튼 클릭 횟수를 출력한다.

        System.out.println(m.arr[N]);
    }
}
