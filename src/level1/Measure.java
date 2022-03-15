package level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Measure {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int K = Integer.parseInt(strArr[1]);

        List<Integer> intList = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(N % i == 0) {
                intList.add(i);
            }
        }
        if(intList.size() < K) {
            System.out.println(0);
        } else {
            System.out.println(intList.get(K-1));
        }

    }
}
