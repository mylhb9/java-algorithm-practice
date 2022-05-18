package additiontype;

import java.util.*;

public class Chebyshevtheo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int a = -1;
        while(a != 0) {
            a = sc.nextInt();
            if(a!=0) {
                list.add(a);
            }
        }
        boolean[] table = new boolean[250000];
        table[1] = true;
        for(int i=2; i<=123456*2; i++) {
            if(table[i]) {
                continue;
            }
            if(i>= Math.sqrt(Integer.MAX_VALUE)) {
                break;
            }

            for(int j=i*i; j<=123456*2; j+=i) {
                table[j] = true;
            }
        }

        int[] arr = new int[250000];
        for(int i=1; i<=123456*2; i++) {
            if(!table[i]) {
                arr[i] = arr[i-1] + 1;
            } else {
                arr[i] = arr[i-1];
            }
        }
        for(int i=0; i<list.size(); i++) {
            System.out.println(arr[2*list.get(i)] - arr[list.get(i)]);
        }

    }
}
