package array;

import java.util.Scanner;

public class PointCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();

        Integer[] intArray = new Integer[N];
        String[] stringArray = line.split(" ");
        for(int i=0; i<stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        int sum = 0;
        int plus = 1;
        int previousValue = 0;
        for(int i=0; i<intArray.length; i++) {
            if(intArray[i] == 1) {
                if(previousValue == 1) {
                    plus++;
                } else {
                    plus = 1;
                }
                sum += plus;
            }
            previousValue = intArray[i];
        }
        System.out.println(sum);
    }
}
