package part5;

import java.util.Scanner;

public class StringInclusionRelationship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] A = sc.nextLine().split("");
        String[] B = sc.nextLine().split("");

        if(A.length >= B.length) {
            for(int i=0; i<A.length; i++) {
                boolean check = false;
                for(int j=0; j<B.length; j++) {
                    if(!A[i+j].equals(B[j])) {
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");


    }
}
