package level5;

import java.util.*;

// 문제: 가로수들이 모두 같은 간격이 되도록 가로수를 해당하는 위치에 심음
// 심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야하는 가로수의 최소수를 구함
// 처리: 공약수를 구해서 해당하는 위치에 나무가 없을 떄만 카운팅한다.

public class Streetree {
    public static int getGcd(int a, int b) {
        int temp;
        while(a % b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Integer[] inputArr = new Integer[N];
        for(int i=0; i<N; i++) {
            inputArr[i] = Integer.parseInt(sc.nextLine());
        }

        Integer[] distanceArr = new Integer[N-1];
        for(int i=0; i<N-1; i++) {
            distanceArr[i] = inputArr[i+1] - inputArr[i];
        }

        int gcd = distanceArr[0];
        for(int i=1; i<N-1; i++) {
            gcd = getGcd(gcd, distanceArr[i]);
        }

        int count = 0;
        boolean[] check = new boolean[200000];
        Arrays.fill(check, false);
        for(int i=0; i<inputArr.length; i++) {
            check[inputArr[i]] = true;
        }
        for(int i=inputArr[0]; i<=inputArr[inputArr.length-1]; i+=gcd) {
            if(!check[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
}
