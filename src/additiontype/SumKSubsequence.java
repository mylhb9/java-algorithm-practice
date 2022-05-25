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
        int sum = 0;
        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        map.put(0, 1);
        for(int i=1; i<=N; i++) {
            accArr[i] += (arr[i] + accArr[i-1]);
            map.put(accArr[i], map.getOrDefault(accArr[i], 0)+1);
            if(K>=0) {
                if(accArr[i] >= K) {
                    if(accArr[i] == K) {
                        count+=map.getOrDefault(K, 0);
                    } else {
                        count+=map.getOrDefault(accArr[i]-K, 0);
                    }
                }
            } else {
                if(accArr[i] <= K) {
                    if(accArr[i] == K) {
                        count+=map.getOrDefault(K, 0);
                    } else {
                        count+=map.getOrDefault(accArr[i]-K, 0);
                    }
                }
            }
        }
        System.out.println(count);

        sc.close();
    }
}
// 3 -3
// -1 -1 -1
// -1 -2 -3
