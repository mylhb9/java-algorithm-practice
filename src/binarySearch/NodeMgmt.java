package binarySearch;

public class NodeMgmt {
    Node head = null;
    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        // Case1: 노드가 하나도 없을 때
        if(this.head == null) {
            this.head = new Node(data);
            return true;
        } else {
        // Case2: 노드가 하나이상 있을 때
            Node findNode = this.head;
            while(findNode != null) {
                if(findNode.value > data) {
                    if(findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode = new Node(data);
                    }
                } else {
                    if(findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode = new Node(data);
                    }
                }
            }
            return true;
        }
    }

    public Node search(int data) {
        // Case1: 노드가 하나도 없을 때
        if(this.head == null) {
            return null;
        } else {
        // Case2: 노드가 하나이상 있을 때
            Node findNode = this.head;
            while(findNode != null) {
                if(findNode.value == data) {
                    return findNode;
                } else if(data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }
}
