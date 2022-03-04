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
            while(true) {
                if(findNode.value > data) {
                    if(findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {
                    if(findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
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

    public boolean delete(int value) {
        boolean searched = false;

        Node currentParentNode = this.head;
        Node currNode = this.head;

        // CornerCase1 : 노드가 하나도 없을 때
        if(this.head == null) {
            return false;
        // CornerCase2 : 노드가 단지 하나만 있고, 해당 노드가 삭제할 노드일 때
        } else {
            if(this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while(currNode != null) {
                if(currNode.value == value) {
                    searched = true;
                    break;
                } else if(value < currNode.value) {
                    currentParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currentParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if(searched == false) {
                return false;
            }
        }

        // Case1 : 삭제할 노드가 Leaf Node 인 경우 (자식이 없는 종단 노드인 경우)
        if(currNode.left == null && currNode.right == null) {
            if(value < currentParentNode.value) {
                currentParentNode.left = null;
            } else {
                currentParentNode.right = null;
            }
            return true;
        } else if(currNode.left != null && currNode.right == null) {
        // Case2 : 삭제할 노드가 Child Node 를 한 개 가지고 있는 경우
        // Case2-1 : 왼쪽에 가지고 있는 경우
            if(value < currentParentNode.value) {
                currentParentNode.left = currNode.left;
            } else {
                currentParentNode.right = currNode.left;
            }
            return true;
        } else if(currNode.left == null && currNode.right != null) {
        // Case2-2 : 오른쪽에 가지고 있는 경우
            if(value < currentParentNode.value) {
                currentParentNode.left = currNode.right;
            } else {
                currentParentNode.right = currNode.right;
            }
            return true;
        } else {
        // Case3 : 삭제할 노드가 ChildNode 를 두 개 가지고 있는 경우
        // Case3-1 : 삭제할 노드가 부모노드의 왼쪽에 있을 때,
            if(value < currentParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // Case3-1-1 : changeNode 의 오른쪽 childNode 가 있을 때
                if(changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                // Case3-1-2 : changeNode 의 오른쪽 childNode 가 없을 때
                    changeParentNode.left = null;
                }
                currentParentNode.left = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
            } else {
        // Case3-2 : 삭제할 노드가 부모노드의 오른쪽에 있을 때
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeParentNode.left;
                }
                // Case3-2-1 : changeNode 의 오른쪽 childNode 가 있을 때
                if(changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                // Case3-2-2 : changeNode 의 오른쪽 childNode 가 없을 때
                    changeParentNode.left = null;
                }
                currentParentNode.right = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        System.out.println(myTree.insertNode(10));
        System.out.println(myTree.insertNode(15));
        System.out.println(myTree.insertNode(13));
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}
