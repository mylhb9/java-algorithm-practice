package part1;

import java.util.*;

public class YutPlay2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> countList = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int count = 0;
            for(int j=0; j<4; j++) {
                int a = sc.nextInt();
                if(a == 1) {
                    count++;
                }
            }
            countList.add(count);
        }

        for(int i=0; i<3; i++) {
            int a = countList.get(i);
            if(a == 0) {
                System.out.println("D");
            } else if(a == 1) {
                System.out.println("C");
            } else if(a == 2) {
                System.out.println("B");
            } else if(a == 3) {
                System.out.println("A");
            } else {
                System.out.println("E");
            }
        }
        sc.close();
    }
}
