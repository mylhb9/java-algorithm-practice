package linkedList;

public class DoubleLinkedList<T> {

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if(this.head == null) {
            this.head = new Node<>(data);
            this.tail = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if(this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);

            while(node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData) {
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }

            }
            return null;
        }

    }

    public T searchFromTail(T isData) {
        if(this.tail == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData) {
        if(this.head == null) {
            this.head = new Node<>(addData);
            this.tail = this.head;
            return true;
        } else if(this.head.data == existedData) {
            this.head.next = new Node<>(existedData);
            this.head = new Node<>(addData);
            return true;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == existedData) {
                    Node<T> nodePrev = node.prev;

                    nodePrev.next = new Node<>(addData);
                    nodePrev.next.prev = nodePrev;

                    nodePrev.next.next = node;
                    node.prev = nodePrev.next;

                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }



    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);


        System.out.println(MyLinkedList.searchFromHead(1));
        System.out.println(MyLinkedList.searchFromTail(6));
    }

}
