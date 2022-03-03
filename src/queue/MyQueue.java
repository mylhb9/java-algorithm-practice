package queue;

import java.util.ArrayList;

public class MyQueue<T> {
    public ArrayList<T> queue = new ArrayList<>();

    public void enqueue(T t) {
        queue.add(t);
    }

    public T dequeue() {
        if(queue.isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());

    }
}
