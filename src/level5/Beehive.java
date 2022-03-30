package level5;

import java.util.Scanner;

public class Beehive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 2;
        int N = sc.nextInt();

        if(N ==1) {
            System.out.println(1);
            return;
        }

        Integer[] intArr = new Integer[1000001];
        for(int i=1; i<=N; i++) {
            sum += 6*(i-1);
            for(int j=sum; j<=sum+6*(i)-1 ; j++) {
                intArr[j] = i+1;
                if(j==N) {
                    System.out.println(intArr[j]);
                    return;
                }
            }
        }
    }
}
