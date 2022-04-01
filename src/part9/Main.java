package part9;


import java.util.*;

// 문제: 숫자 N을 제곱수의 합으로 표현할 때, 사용해야하는 제곱수의 최소 개수를 출력하는 프로그램을 작성
// 입력: N 이 주어짐 (1<= N <= 100000)
// 출력: 필요한 제곱수의 최소 개수를 출력한다.
public class Main {
    int N;
    boolean[] check;
    boolean ok = false;
    List<Integer> squareList = new ArrayList<>();
    public void square(int x, int sum) {
        if(sum == N) {
            System.out.println(x);
            ok = true;
        } else if(sum < N && !ok) {
            for(int j = squareList.size()-1; j>=0; j--) {
                if(!check[x]) {
                    check[x] = true;
                    sum += squareList.get(j);
                    square(x+1, sum);
                    sum -= squareList.get(j);
                    check[x] = false;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: 주어진 N 을 변수에 담는다.
        int N = sc.nextInt();

        // 처리
        // 1. 미리 리스트에 제곱했을 때, 주어진 숫자보다 작은 수를 담고 시작한다.
        List<Integer> squareNumList = new ArrayList<>();
        for(int i=1; i*i<=N; i++) {
            if(i*i <= N) {
                squareNumList.add(i*i);
            }
        }
        // 2. 해당하는 수를 만들기 위해서, 그 합을 구해서 재귀로 표현해본다.
        boolean[] check = new boolean[100010];
        for(int i=0; i<check.length; i++) {
            check[i] = false;
        }

        Main m = new Main();
        m.N = N;
        m.check = check;
        m.squareList = squareNumList;
        m.square(0, 0);

    }
}
