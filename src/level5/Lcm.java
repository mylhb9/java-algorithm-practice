package level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        long A = Long.parseLong(strArr[0]);
        long B = Long.parseLong(strArr[1]);

        List<Integer> commonFactor = new ArrayList<>();
        for(int i=1; i<=Math.min(A, B); i++) {
            if(A % i == 0 && B % i == 0) {
                commonFactor.add(i);
            }
        }

        int maxCommonFactore = commonFactor.get(commonFactor.size()-1);
        System.out.println(A * B / maxCommonFactore);

    }
}
