package level17;

import java.util.Scanner;

public class ResourceExtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] resourcesSum = new int[N][M];

        for(int i=0; i<N; i++) {
            int sum =0;
            for(int j=0; j<M; j++) {
                int a = sc.nextInt();
                sum += a;
                if(i <= 0) {
                    resourcesSum[i][j] = sum;
                } else {
                    if(j <= 0) {
                        resourcesSum[i][j] = resourcesSum[i-1][j] + sum;
                    } else {
                        if(resourcesSum[i-1][j] >= resourcesSum[i][j-1]) {
                            resourcesSum[i][j] = a + resourcesSum[i-1][j];
                        } else {
                            resourcesSum[i][j] = a + resourcesSum[i][j-1];
                        }
                    }
                }
            }
        }
        System.out.println(resourcesSum[N-1][M-1]);
    }
}