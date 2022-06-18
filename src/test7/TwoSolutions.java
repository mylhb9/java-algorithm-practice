package test7;

import java.util.*;

public class TwoSolutions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int idx = 0;
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for(int i=0; i<N-1; i++) {
            int first = arr[i];
            int start = i+1;
            int end = N-1;


            while(start + 1 < end) {
                int mid = (start + end) / 2;
                if(arr[mid] < -first) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if(Math.abs(first + arr[start]) > Math.abs(first + arr[end])) {
                start = end;
            }

            if(min > Math.abs(first + arr[start])) {
                min = Math.abs(first + arr[start]);
                idx = i;
            }
            aList.add(first);
            bList.add(arr[start]);
        }
        System.out.println(aList.get(idx) + " " + bList.get(idx));

        sc.close();
    }
}
