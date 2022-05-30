package additiontype;

import java.util.Scanner;

public class Fruits {
    public void getSum() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] strawberry = new int[N];
        for(int i=0; i<N; i++) {
            strawberry[i] = sc.nextInt();
        }

        int[] carrot = new int[N];
        for(int i=0; i<N; i++) {
            carrot[i] = sc.nextInt();
        }

        int[] watermelon = new int[N];
        for(int i=0; i<N; i++) {
            watermelon[i] = sc.nextInt();
        }

        int[] melon = new int[N];
        for(int i=0; i<N; i++) {
            melon[i] = sc.nextInt();
        }




    }
}
