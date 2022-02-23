package tree;

public class TreePractice2 {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        // Case1: Node가 하나도 없을 때
        if(this.head == null) {
            this.head = new Node(data);
        } else {
        // Case2: Node가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while(true) {
                // Case2-1: 현재 Node의 왼쪽에 Node가 들어가야할 때
                if(data < findNode.value) {
                    if(findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode = new Node(data);
                        break;
                    }
                // Case2-2: 현재 Node의 오른쪽에 Node가 들어가야할 때
                } else {
                    if(findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode = new Node(data);
                        break;
                    }
                }
            }

        }
        return true;
    }

    public Node search(int data) {
        // Case1: Node가 하나도 없을 때
        if(this.head == null) {
            return null;
        // Case2: Node가 하나 이상 있을 떄
        } else {
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

        Node currParentNode = this.head;
        Node currNode = this.head;

        // CornerCase1: Node가 하나도 없을 때
        if(this.head == null) {
            return false;
        // CornerCase2: Node가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
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
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if(searched == false) {
                return false;
            }
        }
        // 여기까지 실행되면,
        // currNode 에는 해당 데이터를 가지고 있는 Node,
        // currParentNode 에는 해당 데이터를 가지고 있는 Node 의 부모 Node

        // case1: 삭제할 Node가 Leaf Node 인 경우
        if(currNode.left == null && currNode.right == null) {
            if(value < currParentNode.value) {
                currParentNode.left = null;
            } else {
                currParentNode.right = null;
            }
            return true;
        // case2-1: 삭제할 Node가 ChildNode를 한 개 가지고 있는 경우(왼쪽에 Child Node 가 있는 경우)
        } else if(currNode.left != null && currNode.right == null) {
            if(value < currParentNode.value) {
                currParentNode.left = currNode.left;
            } else {
                currParentNode.right = currNode.left;
            }
            return true;
        // case2-2: 삭제할 Node가 Child Node를 한 개 가지고 있는 경우(오른쪽에 Child Node 가 있는 경우)
        } else if(currNode.left == null && currNode.right != null) {
            if(value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currParentNode.right = currNode.right;
            }
            return true;
        } else {
            // case3-1: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 왼쪽에 있을 때)
            if(value < currParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeParentNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음

                // case3-1-1: changeNode 의 오른쪽 childNode 가 있을 때,
                if(changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                // case3-1-2: changeNode 의 childNode 가 없을 때,
                } else {
                    changeParentNode.left = null;
                }
                // currParentNode 의 왼쪽 childNode 에, 삭제할 Node 의 자식중,
                // 가장 작은 값을 가진 changeNode 와 연결
                currParentNode.left = changeNode;

                // currParentNode 의 왼쪽 childNode 가 현재 changeNode 이고,
                // changeNode 의 왼쪽/오른쪽 childNode 가 모두, 삭제할 currNode 의
                // 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
            // case3-2: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 왼쪽에 있을 때)
            } else {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeParentNode.left;
                }
                // case3-2-1: changeNode 의 오른쪽 childNode 가 있을 때,
                if(changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                // case3-2-2: changeNode 의 childNode 가 없을 때,
                } else {
                    changeParentNode.left = null;
                }
                currParentNode.right = changeNode;

                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

            }
            return true;
        }
    }
}
