package level14;

import java.util.Scanner;

public class GoodSeq {
    // n=8
    // 0 1 2 3 4 5 6 7
    // 1 2 1 3 1 2 3 1
    int N;
    int[] arr = new int[81];
    boolean answer = false;
    public boolean check(int x, int y) {
        for(int i=0; i<y; i++) {
            if(arr[x-i] != arr[x-i-y]) {
                return true;
            }
        }
        return false;
    }
    public void getSeq(int x) {
        if(answer) {
            return;
        }
        if(x >= N) {
            answer = true;
            for(int i=0; i<N; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for(int i=1; i<=3; i++) {
                arr[x] = i;
                boolean flag = false;
                for(int j=1; j<=(x+1)/2; j++) {
                    if(!check(x, j)) {
                        flag =true;
                        break;
                    }
                }
                if(!flag) {
                    getSeq(x+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        GoodSeq m = new GoodSeq();
        m.N = N;
        m.getSeq(0);
    }
}


