package stack;

import java.util.ArrayList;

public class StackPractice1<T> {
    private ArrayList<T> myStack = new ArrayList<>();

    public void push(T t) {
        myStack.add(t);
    }

    public T pop() {
        if(myStack.isEmpty()) {
            return null;
        }
        return myStack.remove(myStack.size() - 1);
    }

    public static void main(String[] args) {
        StackPractice1<Integer> myStack = new StackPractice1<>();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
