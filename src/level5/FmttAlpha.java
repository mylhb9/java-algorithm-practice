package level5;

import java.util.Scanner;

public class FmttAlpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[0]);

        int sum = 0;
        for(int i=1; i<=N; i++) {
            sum += 2*i;
            if(sum >= N) {
                if(N > sum - i) {
                    System.out.println(2*i);
                } else {
                    System.out.println(2*i-1);
                }
                break;
            }
        }
    }
}
