package level3;

import java.util.*;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[][] strArr = new String[N][5];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put(i+1, new HashSet<>());
        }

        for(int j=0; j<5; j++) {
            for(int i=0; i<N; i++) {
                for(int k=0; k<N; k++) {
                    if(strArr[i][j].equals(strArr[k][j])) {
                        map.get(i+1).add(k+1);
                    }
                }
            }
        }
        int max = 0;
        int studentNo = 0;
        for(int i=0; i<N; i++) {
            if(max < map.get(i+1).size()) {
                max = map.get(i+1).size();
                studentNo = i+1;
            }
        }
        System.out.println(studentNo);
    }
}
