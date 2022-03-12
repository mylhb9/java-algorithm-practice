package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YutPlay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] strArray = new String[3][4];
        for(int i=0; i<3; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }

        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<3; i++) {
            intList.add(Integer.parseInt(strArray[i][0]) + Integer.parseInt(strArray[i][1]) +Integer.parseInt(strArray[i][2]) +Integer.parseInt(strArray[i][3]));
        }

        List<String> yut = new ArrayList<>();
        yut.add("D");
        yut.add("C");
        yut.add("B");
        yut.add("A");
        yut.add("E");

        for(int i=0; i<3; i++) {
            System.out.println(yut.get(intList.get(i)));
        }

    }
}
