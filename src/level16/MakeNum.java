package level16;

import java.util.Scanner;

public class MakeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[100001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4; i<=N; i++) {
            arr[i] =( arr[i-1] + arr[i-2] + arr[i-3]) % 1000007;
        }
        System.out.println(arr[N]);
    }
}


// 1 : 1 1개
// 2 : 1+1 2 2개
// 3 : 1+1+1 2+1 1+2 3 4개
// 4 : 1+1+1+1 2+1+1 1+2+1 3+1 1+1+2 2+2 1+3 7개
// f(n) = f(n-1) + f(n-2) + f(n-3)