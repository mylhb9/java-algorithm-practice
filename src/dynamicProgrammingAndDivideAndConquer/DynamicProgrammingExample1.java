package dynamicProgrammingAndDivideAndConquer;

public class DynamicProgrammingExample1 {
    public int fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        DynamicProgrammingExample1 dp = new DynamicProgrammingExample1();
        System.out.println(dp.fibonacci(50));
    }
}
