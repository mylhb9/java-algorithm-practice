package level3;

import java.util.Scanner;

public class RepresentativeValue2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] inputArr = new Integer[10];
        Integer[] cnt = new Integer[1001];

        for(int i=0; i<cnt.length; i++) {
            cnt[i] = 0;
        }

        for(int i=0; i<10; i++) {
            inputArr[i] = Integer.parseInt(sc.nextLine());
        }

        int sum = 0;
        for(int i=0; i<10; i++) {
            sum += inputArr[i];
        }
        System.out.println(sum / 10);

        for(int i=10; i<=1000; i+=10) {
            for(int j=0; j<10; j++) {
                if(i == inputArr[j]) {
                    cnt[i]++;
                }
            }
        }

        int mx = 0;
        int idx = 0;
        for(int i=10; i<=1000; i+=10) {
            if(mx < cnt[i]) {
                mx = cnt[i];
                idx = i;
            }
        }
        System.out.println(idx);

    }
}
