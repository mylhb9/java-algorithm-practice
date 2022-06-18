package newPart12;

import java.util.Scanner;

public class ParametricSearchEx {
    int[] data;
    int n;
    int s;
    public boolean check(int interval) {
        int sum = 0;
        for(int i=0; i<interval; i++) {
            sum += data[i];
        }
        if(sum >= s) {
            return true;
        }
        for(int i=0; i<n-interval; i++) {
            sum = sum - data[i] + data[interval + i];
            if(sum >= s) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[100];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }



        ParametricSearchEx m = new ParametricSearchEx();
        m.data = arr;
        m.n = n;
        m.s = s;

        int start = 1;
        int end = n;

        if(m.check(1)) {
            System.out.println(1);
            return;
        }
        if(!m.check(n)) {
            System.out.println(-1);
            return;
        }

        while(start+1<end) {
            int mid = (start + end) / 2;
            if(!m.check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(end);
    }
}
