package level8;

import java.util.Arrays;
import java.util.Scanner;

// 문제: N(1~15)마리의 소들을 순서대로 세워놓은 후 +, -, . 을 배치해서 최종 결과가 0이 되도록 한다.
// . 은 공백을 의미한다.
public class Dessert {
    char[] strArr = {'+', '-' ,'.'};
    int N;
    int[] arr;
    char[] oper = new char[N];

    public boolean getSum() {
        int init = arr[0];
        for(int i=0; i<N-1; i++) {
            if(oper[i]==('+')) {
                init += arr[i+1];
            } else if(oper[i]==('-')) {
                init -= arr[i+1];
            } else {
                if(i!=0) {
                    if(oper[i-1]==('+')) {
                        init = init - arr[i] + 10 * arr[i] + arr[i+1];
                    } else {
                        init = init + arr[i] -(10 * arr[i] + arr[i+1]);
                    }
                } else {
                    init = 10*init + arr[1];
                }
            }
        }
        if(init == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void getResult(int x) {
        if(x >= N-1) {
            for(int i=0; i<N; i++) {
                if(getSum()) {
                    if(i == 0) {
                        System.out.print(arr[i] + oper[i+1]);
                    } else {
                        System.out.print(arr[i+1] + oper[i+2]);
                    }
                }
            }
        } else {
            for(int i=0; i<3; i++) {
                oper[x] = strArr[i];
                getResult(x+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=1; i<=N; i++) {
            arr[i-1] = i;
        }
        Dessert m = new Dessert();
        m.N = N;
        m.arr = arr;
        Arrays.fill(m.oper, '0');
        m.getResult(0);
    }
}
