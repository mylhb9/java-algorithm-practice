package study;

public class RecurOrder {
    static void recur(int n) {
        if(n == 3) {
            return;
        }

        recur(n+1);

        for(int i=0; i<n; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        recur(1);
    }
}
