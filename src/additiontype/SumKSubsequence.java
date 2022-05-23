package additiontype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            map.put(sum, 0);
        }
        map.put(0, 1);
        for(int i=1; i<=N; i++) {
            accArr[i] += (arr[i] + accArr[i-1]);
            map.put(accArr[i], map.get(accArr[i])+1);
            if(K>=0) {
                if(accArr[i] >= K) {
                    if(accArr[i] == K) {
                        count+=map.get(K);
                    } else {
                        count+=map.get(accArr[i]-K);
                    }
                }
            } else {
                if(accArr[i] <= K) {
                    if(accArr[i] == K) {
                        count+=map.get(K);
                    } else {
                        count+=map.get(accArr[i]-K);
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
