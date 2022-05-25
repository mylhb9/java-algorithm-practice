package additiontype;

import java.util.*;

public class SumKSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N+1];
        int[] accArr = new int[N+1];

        map.put(0, 1);
        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
            accArr[i] += (arr[i] + accArr[i-1]);
            count += map.getOrDefault(accArr[i]-K, 0);
            map.put(accArr[i], map.getOrDefault(accArr[i], 0)+1);
        }

        System.out.println(count);

        sc.close();
    }
}
// 3 -3
// -1 -1 -1
// -1 -2 -3
