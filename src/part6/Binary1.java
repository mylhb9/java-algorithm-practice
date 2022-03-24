package part6;

import java.util.*;

public class Binary1 {
    List<Integer> binaryList = new ArrayList<>();
    public void binary(int n) {
        if(n == 0) {
            return;
        } else {
            binaryList.add(n % 2);
            binary(n / 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Binary1 m = new Binary1();
        m.binary(n);
        for(int i=m.binaryList.size()-1; i>=0; i--) {
            System.out.print(m.binaryList.get(i));
        }
    }
}
