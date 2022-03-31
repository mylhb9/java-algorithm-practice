package level5;

import java.util.*;

public class Streetree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Integer[] strArr = new Integer[N];
        for(int i=0; i<N; i++) {
            strArr[i] = Integer.parseInt(sc.nextLine());
        }

        List<Integer> commonFactor = new ArrayList<>();
        for(int i=1; i<N; i++) {
            commonFactor.add(strArr[i]-strArr[i-1]);
        }
        for(int i=0; i<commonFactor.size(); i++) {

        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(strArr[i]);
        }

        int pivot = strArr[0];
        int count = 0;
        while(list.get(list.size()-1) > pivot) {
            if(!list.contains(pivot)) {
                count++;
            }
            pivot += commonFactor.get(commonFactor.size()-1);
        }
        System.out.println(count);
    }
}
