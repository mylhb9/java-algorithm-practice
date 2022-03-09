package simpleBruteForce;

import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] strArray = new String[n][5];
        Integer[][] intArray = new Integer[n][5];
        Integer[] maxArray = new Integer[n];
        for(int i=0; i<n; i++) {
            maxArray[i] = 0;
            strArray[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<5; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        for(int j=0; j<5; j++) {
            for(int i=0; i<n; i++) {
                for(int k=1+i; k<n; k++) {
                    if(intArray[i][j] == intArray[k][j]) {
                        maxArray[i]++;
                        maxArray[k]++;
                    }
                }
            }
        }

        int max =0;
        String index = "";
        for(int i=0; i<maxArray.length; i++) {
            if(maxArray[i] > max) {
                max = maxArray[i];
            }
        }
        for(int i=0; i<maxArray.length; i++) {
            if(max == maxArray[i]) {
                index += i+1 + " ";
            }
        }
        System.out.println(index.split(" ")[0]);

    }
}
