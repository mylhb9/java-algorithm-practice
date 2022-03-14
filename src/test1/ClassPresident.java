package test1;

import java.util.*;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] strArr = new String[N][5];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<5; j++) {
                for(int a=0; a<N; a++) {
                    if(a!=i) {
                        if(strArr[i][j].equals(strArr[a][j])) {
                            set.add(a);
                        }
                    }
                }
            }
            intList.add(set.size());
        }
        int max = 0;
        int index = 0;
        for(int i=0; i<N; i++) {
            if(max < intList.get(i)) {
                max = intList.get(i);
                index = i;
            }
        }

        System.out.println(index+1);
    }
}
