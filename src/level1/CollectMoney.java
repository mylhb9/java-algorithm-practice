package level1;

import java.util.Scanner;

public class CollectMoney {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int sum = 0;
        for(int i=1; i<=M; i++) {
            sum+=i;
            if(sum >= M) {
                System.out.println(i);
                return;
            }
        }


    }
}
