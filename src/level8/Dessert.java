package level8;

import java.util.Scanner;

// 문제: N(1~15)마리의 소들을 순서대로 세워놓은 후 +, -, . 을 배치해서 최종 결과가 0이 되도록 한다.
// . 은 공백을 의미한다.
public class Dessert {
    int n, m;
    String[] arr;
    Integer[] intArr;
    String[] strArr = {"+", "-", "."};
    void recur(int x, int sum) {
        if(sum == 0 || x > n) {
            return;
        }
        if(x == n) {
            for(int i=0; i<n; i++) {
                if(arr[x].equals("+")) {
                    sum += intArr[i];
                } else if(arr[x].equals("-")) {
                    sum -= intArr[i];
                } else {
                    sum = 10 * sum + intArr[i];
                }
                System.out.print(arr[i]);
            }


            System.out.println();
        } else {
            for(int i=0; i<m; i++) {
                arr[x] = strArr[i];
                recur(x+1, sum);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt()-1;
        Integer[] intArr = new Integer[N+1];
        for(int i=0; i<=N; i++) {
            intArr[i] = i+1;
        }


        Dessert main = new Dessert();
        main.n = N;
        main.m = 3;
        main.arr = new String[N];
        main.intArr = intArr;

        main.recur(0, 0);
    }
}
