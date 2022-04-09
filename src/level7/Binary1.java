package level7;

import java.util.*;

public class Binary1 {
    List<Integer> list = new ArrayList<>();
    void getBinary(int x) {
        if(x == 0) {
            for(int i=list.size()-1; i>=0; i--) {
                System.out.print(list.get(i));
            }
            System.out.println();
        } else {
            list.add(x % 2);
            x = x/2;
            getBinary(x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Binary1 m = new Binary1();
        m.getBinary(N);
    }
}
