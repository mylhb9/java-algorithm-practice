package test6;

import java.util.Scanner;

public class NNTable {

    // 1 2 3
    // 2 4 6
    // 3 6 9
    long N;

    public long getOrder(long x) {
        long count = 0;
        for(int i=0; i<N; i++) {
            if(N*(i+1) < x) {
                count += N;
            } else {
                if(x % (i+1) == 0) {
                    count += (x/(i+1)-1);
                } else {
                    count += (x/(i+1));
                }
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();

        long start = 1;
        long end = N*N+1;

        NNTable m = new NNTable();
        m.N = N;
        while(start+1<end) {
            long mid = (start + end) / 2;
            long midOrder = m.getOrder(mid);

            if(midOrder <= K) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);

    }
}
