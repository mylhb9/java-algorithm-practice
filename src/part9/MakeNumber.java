package part9;

// 문제: 숫자 1, 2, 3을 이용하여 숫자 N을 만드는 경우의 수를 출력하는 프로그램 만들기
// 입력: 첫 째줄에 N이 주어진다. (1 <= N <= 100000)
// 출력: 1, 2, 3을 이용하여 N을 만들수 있는 경우의 수를 1000007로 나눈 나머지를 출력한다.


import java.util.Arrays;
import java.util.Scanner;

public class MakeNumber {
    int sum = 0;
    Integer[] intArr;
    boolean[] check;
    public void makeNum(int x) {
        if(x==sum) {
            System.out.println(Arrays.toString(intArr));
        } else {
            for(int i=1; i<=sum-1; i++) {
                if(!check[x]) {
                    intArr[x] = i;
                    check[x] = true;
                    makeNum(x+1);
                    check[x] = false;
                    intArr[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        MakeNumber m = new MakeNumber();
        m.sum = N;
        

    }
}
