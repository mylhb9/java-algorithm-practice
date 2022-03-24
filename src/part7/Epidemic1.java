package part7;

import java.util.Arrays;
import java.util.Scanner;

class MyQueue2 {
    private Integer[] queue;
    int f = 0;
    int r = 0;
    int quantity = 0;
    int length = 0;

    public MyQueue2(int quantity) {
        this.quantity = quantity;
        this.queue = new Integer[quantity];
    }

    public void push(int x) {
        if(length >= quantity) {
            return;
        } else {
            queue[r] = x;
            r++;
            if(r>=quantity) {
                r=0;
            }
            length++;
        }
    }

    public int pop() {
        int value = 0;
        if(length <= 0) {
            return 0;
        } else {
            value = queue[f];
            queue[f] = 0;
            f++;
            if(f >= quantity) {
                f = 0;
            }
            length--;
            return value;
        }
    }
}


public class Epidemic1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        String[] inputArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);
        boolean[] checkArr = new boolean[N+1];
        Arrays.fill(checkArr, false);


        MyQueue2 queue = new MyQueue2(N+1);
        queue.push(K);
        checkArr[K] = true;


        while(true) {
            K = queue.pop();
            if(K * 2 <= N && !checkArr[K*2]) {
                queue.push(K*2);
                checkArr[K*2] = true;
            }
            if(K / 3 >= 1 && !checkArr[K/3]) {
                queue.push(K/3);
                checkArr[K/3] = true;
            }

            if(queue.length <= 0) {
                break;
            }

        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(!checkArr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
