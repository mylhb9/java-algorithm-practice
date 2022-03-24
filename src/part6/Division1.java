package part6;

import java.util.Arrays;
import java.util.Scanner;

public class Division1 {
    Integer[] intArr;
    int n;
    int count = 0;
    public void division(int sum, int index) {
        if(sum == n && intArr[0] != n) {
            for(int i=0; i<intArr.length; i++) {
                if(intArr[i] != 0) {
                    if(intArr[i+1]==0) {
                        System.out.print(intArr[i]);
                    } else {
                        System.out.print(intArr[i] + "+");
                    }
                }
            }
            count++;
            System.out.println();
        } else if(sum < n) {
            for(int i=n; i>=1; i--) {
                if(intArr[index] == 0 && index == 0)  {
                    intArr[index] = i;
                    division(sum+i, index+1);
                    intArr[index] = 0;
                } else if(intArr[index] == 0 && index != 0) {
                    if(intArr[index - 1] >= i) {
                        intArr[index] = i;
                        division(sum+i, index+1);
                        intArr[index] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Division1 m = new Division1();

        m.n = n;
        m.intArr = new Integer[50];
        Arrays.fill(m.intArr, 0);

        m.division(0, 0);
        System.out.println(m.count);
    }
}
