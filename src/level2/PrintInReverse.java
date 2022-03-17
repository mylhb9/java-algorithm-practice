package level2;

import java.util.Scanner;

public class PrintInReverse {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");
        for(int i=0; i<n/2; i++) {
            String pivot = strArr[i];
            strArr[i] = strArr[strArr.length - 1 - i];
            strArr[strArr.length - 1 - i] = pivot;
        }
        for(int i=0; i<n; i++) {
            System.out.print(strArr[i] + " ");
        }

    }
}
