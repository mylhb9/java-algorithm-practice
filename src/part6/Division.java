package part6;

import java.util.*;

public class Division {
    Integer[] result = new Integer[1000];
    int n;
    int count = 0;

    public void getDivision(int sum, int idx) {
        if(sum == n && sum <= n) {
            for(int i=0; i< result.length; i++) {
                if(result[i] != null) {
                    if(i==0) {
                        System.out.print(result[i]);
                    }
                    else {
                        System.out.print("+"+result[i]);
                    }
                }
            }
            count++;
            System.out.println();
        } else {
            int myNum;
            if(idx == 0) {
                myNum = n - 1;
            } else {
                myNum = n - sum;
            }
            for(int i=myNum; i>0; i--) {
                result[idx] = i;
                if(idx>0 && result[idx-1] < result[idx]) {
                    continue;
                }
                getDivision(sum+i, idx+1);
                result[idx] = null;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();


        Division m = new Division();
        m.n = x;
        m.getDivision(0, 0);
        System.out.println(m.count);
    }
}
