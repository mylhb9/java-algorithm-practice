package test6;

import java.util.*;

public class NoOverlapSection {
    int[] table;
    int n;
    public boolean isOverlap(int r) {
        List<Integer> memoryList = new ArrayList<>();
        int[] visited = new int[100005];

        for(int i=0; i<r; i++) {
            visited[table[i]] += 1;
            if(visited[table[i]] > 1) {
                memoryList.add(table[i]);
            }
        }

        if(memoryList.size() == 0) {
            return true;
        }

        for(int i=0; i<n-r; i++) {
            visited[table[i]] -= 1;
            visited[table[i+r]] += 1;

            if(visited[table[i]] <= 1) {
                memoryList.remove((Object) table[i]);
            }

            if(visited[table[i+r]] > 1) {
                memoryList.add(table[i+r]);
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
        int[] table = new int[n];
        for(int i=0; i<n; i++) {
            table[i] = sc.nextInt();
        }

        NoOverlapSection m = new NoOverlapSection();
        m.table = table;
        m.n = n;

        int start = 1;
        int end = n+1;
        while(start+1<end) {
            int mid = (start + end) / 2;
            if(m.isOverlap(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
        sc.close();
    }
}
