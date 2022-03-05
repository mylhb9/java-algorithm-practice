package recursiveCall;

import java.util.ArrayList;

public class Factorial {
    public int factorialFunc(int n) {
        if(n > 1) {
            return n + this.factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    public int factorialFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + this.factorialFunc(new ArrayList<>(dataList.subList(1, dataList.size())));
    }

    public int factorialFunc3(int n) {
        if(n==1) {
            return 1;
        } else if(n==2) {
            return 2;
        } else if(n==3) {
            return 4;
        } else {
            return this.factorialFunc3(n-1) + this.factorialFunc3(n-2) + this.factorialFunc3(n-3);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0; i<5; i++) {
            dataList.add(i);
        }

        Factorial factorial = new Factorial();

        System.out.println(factorial.factorialFunc(dataList));

        System.out.println(factorial.factorialFunc3(5));

    }
}
