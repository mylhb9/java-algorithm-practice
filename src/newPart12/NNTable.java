package newPart12;

import java.util.Scanner;

// 1 2 3
// 2 4 6
// 3 6 9

// 1 2 2 3 3 4 6 6 9
// 1 2 2 4 4 6 7 7 9
public class NNTable {
    long N;
    public long getOrder(long x) {
        long count = 0;
        for(int i=0; i<N; i++) {
            if(N*(i+1) < x) {
                count+=N;
            } else {
                if(x % (i+1) == 0) {
                    count+=x/(i+1)-1;
                } else {
                    count+=x/(i+1);
                }
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();


        NNTable m = new NNTable();
        m.N = N;
        long start = 0;
        long end = N*N+1;
        while(start + 1 < end) {
            long mid = (start + end) / 2;
            long order = m.getOrder(mid);
            if(order <= K) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
        sc.close();
    }
}
