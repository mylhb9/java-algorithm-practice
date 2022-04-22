package test4;

import java.util.Scanner;

public class NNTable {
    long N;
    public long countNum(long x) {
        long count = 0;
        for(int i=0; i<N; i++) {
            if(x >(i+1)*N) {
                count += N;
            } else {
                if(x % (i+1) == 0) {
                    count += (x / (i+1) - 1);
                } else {
                    count += (x / (i+1));
                }
            }
        }
        return count+1;
    }
    /*
        1 2 3    4
        2 4 6
        3 6 9
1 2 2 3 3 4 6 6 9
1 2 3 4 5 6 7 8 9
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();

        NNTable m = new NNTable();
        m.N = N;

        long start = 1;
        long end = N*N+1;

        while(start+1 < end) {
            long mid = (start + end) / 2;
            long midOrder = m.countNum(mid);

            if(midOrder <= K) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}
