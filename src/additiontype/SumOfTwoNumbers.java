package additiontype;

import java.util.*;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
            count += map.getOrDefault(K - arr[i], 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(count);
    }
}
