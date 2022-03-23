package part7;
import java.util.Scanner;

class Queue1 {
    Integer[] intArr;
    int f = 0;
    int r = 0;
    int capacity;
    int length = 0;

    public Queue1(int capacity) {
        this.capacity = capacity;
        this.intArr = new Integer[capacity];
    }

    void push(int n) {
        intArr[r] = n;
        r++;
        if(r >= capacity) {
            r = 0;
        }

        length++;
    }

    int pop() {
        int value = intArr[f];
        intArr[f] = 0;
        f++;
        if(f >= capacity) {
            f = 0;
        }
        length--;
        return value;
    }

}

public class Epidemic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int K = Integer.parseInt(strArr[1]);

        boolean[] check = new boolean[100001];
        for(int i=0; i<=100000; i++) {
            check[i] = false;
        }

        Queue1 queue = new Queue1(N);
        queue.push(K);
        check[K] = true;

        while(true) {

            K = queue.pop();

            if(K*2 <= N && !check[K*2]) {
                queue.push(K*2);
                check[K*2] = true;
            }

            if(K/3 >= 1 && !check[K/3]) {
                queue.push(K/3);
                check[K/3] = true;
            }



            if(queue.length <= 0 || queue.length > queue.capacity) {
                break;
            }
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(!check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}