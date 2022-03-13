package part3;

import java.util.*;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] strArr = new String[N][5];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        Map<Integer, Set<Integer>> countMap = new HashMap<>();
        for(int i=0; i<N; i++) {
            countMap.put(i, new HashSet<>());
        }


        for(int j=0; j<5; j++) {
            for(int i=0; i<N; i++) {
                for(int a=0; a<N; a++) {
                    if(strArr[i][j].equals(strArr[a][j])) {
                        if(a==i) {
                            continue;
                        }
                        countMap.get(i).add(a);
                    }
                }
            }
        }

        Integer[] countArr = new Integer[N];
        for(int i=0; i<N; i++) {
            countArr[i] = countMap.get(i).size();
        }
        int max = 0;
        int studentNO = 1;
        for(int i=0; i<N; i++) {
            if(countArr[i] > max) {
                max = countArr[i];
                studentNO = i+1;
            }
        }
        System.out.println(studentNO);
    }
}
