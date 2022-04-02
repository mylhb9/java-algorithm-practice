package level5;

import java.util.Scanner;

public class CombinationPascal {
    Integer[][] notes;

    public int pascal(int n, int r) {
        if(n == r) {
            return 1;
        } else if(r==0) {
            return 1;
        } else {
            if(notes[n][r] != null) {
                return notes[n][r];
            }
            notes[n][r] = pascal(n-1, r-1) + pascal(n-1, r);
            return notes[n][r];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        CombinationPascal c = new CombinationPascal();
        Integer[][] notes = new Integer[31][31];
        c.notes = notes;
        System.out.println(c.pascal(n, m));
    }
}
