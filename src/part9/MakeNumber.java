package part9;

// 문제: 숫자 1, 2, 3을 이용하여 숫자 N을 만드는 경우의 수를 출력하는 프로그램 만들기
// 입력: 첫 째줄에 N이 주어진다. (1 <= N <= 100000)
// 출력: 1, 2, 3을 이용하여 N을 만들수 있는 경우의 수를 1000007로 나눈 나머지를 출력한다.


import java.util.Arrays;
import java.util.Scanner;

public class MakeNumber {
    int N;
    Integer[] intArr;
    boolean[] check;
    int count = 0;
    public void makeNum(int x, int sum) {
        if(sum == N) {
            count++;
            System.out.println(Arrays.toString(intArr));
        } else if(sum < N){
            for(int i=1; i<=3; i++) {
                if(!check[x]) {
                    intArr[x] = i;
                    check[x] = true;
                    sum += intArr[x];
                    makeNum(x+1, sum);
                    check[x] = false;
                    sum -= intArr[x];
                    intArr[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        MakeNumber m = new MakeNumber();
        m.N = N;
        Integer[] intArr = new Integer[N];
        for(int i=0; i<intArr.length; i++) {
            intArr[i] = 0;
        }
        boolean[] check = new boolean[N];
        for(int i=0; i<check.length; i++) {
            check[i] = false;
        }
        m.intArr = intArr;
        m.check = check;
        m.makeNum(0, 0);
        System.out.println(m.count%1000007);
    }
}
