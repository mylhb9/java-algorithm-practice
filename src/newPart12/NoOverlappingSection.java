package newPart12;

import java.util.*;

public class NoOverlappingSection {
    int[] arr;
    int n;
    boolean flag = false;
    public boolean check(int interval) {
        int[] checkArr = new int[100005];
        List<Integer> memoryList = new ArrayList<>();
        for(int i=0; i<interval; i++) {
            checkArr[arr[i]]++;
            if(checkArr[arr[i]] >= 2) {
                memoryList.add(arr[i]);
                flag = true;
            }
        }
        if(!flag) {
            return true;
        }
        for(int i=0; i<n-interval; i++) {
            checkArr[arr[i]]--;
            checkArr[arr[i+interval]]++;
            if(checkArr[arr[i]] <= 1) {
                memoryList.remove((Object)arr[i]);
            }

            if(checkArr[arr[i+interval]] > 1) {
                memoryList.add(arr[i+interval]);
            }

            if(memoryList.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        NoOverlappingSection m = new NoOverlappingSection();
        m.arr = arr;
        m.n = n;
        int start = 0;
        int end = n+1;
        while (start+1<end) {
            int mid = (start + end) / 2;
            if(m.check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
        sc.close();
    }
}
