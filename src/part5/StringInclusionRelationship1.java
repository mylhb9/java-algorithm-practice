package part5;

import java.util.Scanner;

public class StringInclusionRelationship1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        if(A.contains(B)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
