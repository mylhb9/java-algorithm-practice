package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary {
    List<Integer> binaryList = new ArrayList<>();
    public int getBinary(int n) {
        if(n == 0) {
            return 1;
        } else {
            binaryList.add(n%2);
            n/=2;
            return getBinary(n);
        }
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Binary m = new Binary();

        m.getBinary(n);
        for(int i=m.binaryList.size()-1; i>=0; i--) {
            System.out.print(m.binaryList.get(i));
        }

    }
}
