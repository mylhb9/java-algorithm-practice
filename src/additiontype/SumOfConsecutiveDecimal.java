package additiontype;

import java.util.*;

public class SumOfConsecutiveDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        boolean[] table = new boolean[4000001];
        table[1] = true;
        for(int i=2; i<=4000000; i++) {
            if(table[i]) {
                continue;
            }
//            if(i>= 4000000) {
//                break;
//            }

            for(int j=2*i; j<=4000000; j+=i) {
                table[j] = true;
            }
            if(!table[i]) {
                list.add(i);
            }
        }

        int sum = 0;
        int end = 0;
        int count = 0;

        for(int i=0; i<list.size(); i++) {
            while(sum < N && end <list.size()) {
                sum += list.get(end);
                end++;
            }
            if(sum == N) {
                count++;
            }
            sum-=list.get(i);
        }

        System.out.println(count);
    }
}

