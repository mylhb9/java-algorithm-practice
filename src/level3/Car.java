package level3;

import java.util.*;
public class Car {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int day = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");
        int count = 0;
        for(int i=0; i<5; i++) {
            if(strArr[i].equals(String.valueOf(day))) {
                count++;
            }
        }
        System.out.println(count);

    }
}
