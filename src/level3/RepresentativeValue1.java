package level3;

import java.util.*;

public class RepresentativeValue1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] inputArr = new Integer[10];
        Integer[] cnt = new Integer[1003];

        for(int i=0; i<10; i++) {
            inputArr[i] = Integer.parseInt(sc.nextLine());
        }
        for(int i=0; i<cnt.length; i++) {
            cnt[i] = 0;
        }

        int sum = 0;
        for(int i=0; i<10; i++) {
            sum += inputArr[i];
            cnt[inputArr[i]]++;
        }
        System.out.println(sum/10);

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
