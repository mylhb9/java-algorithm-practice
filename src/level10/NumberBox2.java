package level10;

import java.util.*;

public class NumberBox2 {
    Map<Integer, Boolean> checks = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strBoxArr = sc.nextLine().split(" ");
        int M = Integer.parseInt(sc.nextLine());
        String[] strAnswerArr = sc.nextLine().split(" ");

        NumberBox2 m = new NumberBox2();
        for(int i=0; i<N; i++) {
            m.checks.put(Integer.parseInt(strBoxArr[i]), true);
        }

        for(int i=0; i<M; i++) {
            if(m.checks.get(Integer.parseInt(strAnswerArr[i])) != null) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
