package level2;

import java.util.Scanner;

public class CalculatePoint {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");

        int sum = 0;
        int alpha = 1;
        String prevOX = "";
        for(int i=0; i<N; i++) {
            if(strArr[i].equals("1")) {
                if(prevOX.equals("1")) {
                    alpha++;
                }
                sum+=alpha;
            } else {
                alpha = 1;
            }
            prevOX = strArr[i];
        }
        System.out.println(sum);

    }
}
