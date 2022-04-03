package level5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[0]);

        // 각 수가 최소 두 개가 확보되어야 다음 수까지 나아갈 수 있다.
        // 또한 각 수의 합이 차이 값과 동일해야한다.
        // 항이 맥스가 되면 또 다른 항을 추가하는데, 그때 1부터 시작해서 최댓값을 향한다.

        Integer[] count = new Integer[100];
        for(int i=0; i<count.length; i++) {
            count[i] = 0;
        }
        count[1] = N;
        for(int i=1; i<=N; i++) {

            while(count[i] > 3) {
                count[i]--;
                if(i!=N) {
                    count[i+1]++;
                }
            }
            if(count[i]==3 && count[i+1] != 0) {
                count[i] = 2;
            }
        }
        int num = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i] != 0) {
                num+=count[i];
            }
        }
        System.out.println(num);
    }
}
