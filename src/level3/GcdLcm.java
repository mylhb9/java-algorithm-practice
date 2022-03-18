package level3;

import java.util.*;

public class GcdLcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);

        List<Integer> gcdList = new ArrayList<>();
        for(int i=2; i<=Math.min(a, b); i++) {
            if(a % i ==0 && b % i == 0) {
                gcdList.add(i);
                a /= i;
                b /= i;
            }
        }
        int gcd = 1;
        for(int i=0; i < gcdList.size(); i++) {
            gcd *= gcdList.get(i);
        }
        int lcm = gcd * a * b;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
