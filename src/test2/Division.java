package test2;

import java.util.Arrays;
import java.util.Scanner;

public class Division {
    int n;
    int count = 0;
    Integer[] intArr = new Integer[100];
    public void division(int sum, int x) {
        if(sum == n && intArr[0] != n) {
            for(int i=0; i<intArr.length; i++) {
                if(intArr[i] != 0 && intArr[i+1] != 0) {
                    System.out.print(intArr[i] + "+");
                } else if(intArr[i] != 0 && intArr[i+1] == 0) {
                    System.out.print(intArr[i]);
                }
            }
            count++;
            System.out.println();
        } else if(sum < n){
            for(int i=n; i>=1; i--) {
                if(intArr[x] == 0 && x==0) {
                    intArr[x] = i;
                    division(sum+i, x+1);
                    intArr[x] = 0;
                } else if(intArr[x] == 0 && x>0) {
                    if(intArr[x-1] >= i) {
                        intArr[x] = i;
                        division(sum+i, x+1);
                        intArr[x] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Division m = new Division();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m.n = n;
        Arrays.fill(m.intArr, 0);
        m.division(0, 0);
        System.out.println(m.count);
    }
}
