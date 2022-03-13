package part2;

import java.util.Scanner;

public class CalculatePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");

        int sum =0;
        int alpha = 1;
        boolean check = false;
        for(int i=0; i<N; i++) {
            if(strArr[i].equals("1")) {
                if(check) {
                    alpha++;
                } else {
                    alpha = 1;
                }
                sum += alpha;
                check = true;
            } else {
                check = false;
            }
        }
        System.out.println(sum);
    }
}
