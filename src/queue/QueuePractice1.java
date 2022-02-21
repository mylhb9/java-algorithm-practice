package queue;

import java.util.ArrayList;

public class QueuePractice1<T> {
    private ArrayList<T> myQueue = new ArrayList<>();

    public void enqueue(T t) {
        myQueue.add(t);
    }

    public T dequeue() {
        if(myQueue.isEmpty()) {
            return null;
        }
        // ArrayList의 remove 메소드는 제거한 값을 리턴한다.
        return myQueue.remove(0);
    }

    public static void main(String[] args) {
        QueuePractice1<Integer> queuePractice1 = new QueuePractice1<>();
        queuePractice1.enqueue(1);
        queuePractice1.enqueue(2);
        System.out.println(queuePractice1.dequeue());
        System.out.println(queuePractice1.dequeue());
    }
}
