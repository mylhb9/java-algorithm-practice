package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        this.heapArray = new ArrayList<>();
        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    public boolean insert(Integer data) {
        Integer insertedIndex, parentIndex;

        if(heapArray == null) {
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        } else {
            heapArray.add(data);
            insertedIndex = heapArray.size() - 1;
            while(this.moveUp(insertedIndex)) {
                parentIndex = insertedIndex / 2;
                Collections.swap(this.heapArray, insertedIndex, parentIndex);
                insertedIndex = parentIndex;
            }
            return true;
        }

    }

    // 삽입된 인덱스가 이미 루트노드이거나 부모노드보다 작게 되면 false 를 리턴하여 반복문의 진행을 막는다.
    public boolean moveUp(Integer insertedIndex) {
        if(insertedIndex <= 1) {
            return false;
        } else {
            Integer parentIndex = insertedIndex / 2;
            if(this.heapArray.get(insertedIndex) > this.heapArray.get(parentIndex)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Integer pop() {
        Integer returnedData, poppedIndex, leftChildPoppedIndex, rightChildPoppedIndex;

        if(this.heapArray == null) {
            return null;
        } else {

            returnedData = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            poppedIndex = 1;
            // Case1 : 자식노드가 없을 때 -> 안따져줘도 while 문 조건에서 걸려서 false 처리되고 따로 해줄 부분이 없음
            while(this.moveDown(poppedIndex)) {
                leftChildPoppedIndex = poppedIndex * 2;
                rightChildPoppedIndex = poppedIndex * 2 + 1;


            // Case2 : 오른쪽 자식 노드만 없을 때

                if(rightChildPoppedIndex >= this.heapArray.size()) {
                    if(this.heapArray.get(leftChildPoppedIndex) > this.heapArray.get(poppedIndex)) {
                        Collections.swap(heapArray, poppedIndex, leftChildPoppedIndex);
                        poppedIndex = leftChildPoppedIndex;
                    }
            // Case3 : 왼쪽 오른쪽 자식노드 모두 있을 떄
                } else {
                    if(this.heapArray.get(leftChildPoppedIndex) > this.heapArray.get(rightChildPoppedIndex)) {
                        if(this.heapArray.get(leftChildPoppedIndex) > this.heapArray.get(poppedIndex)) {
                            Collections.swap(heapArray, poppedIndex, leftChildPoppedIndex);
                            poppedIndex = leftChildPoppedIndex;
                        }
                    } else {
                        if(this.heapArray.get(rightChildPoppedIndex) > this.heapArray.get(poppedIndex)) {
                            Collections.swap(heapArray, poppedIndex, rightChildPoppedIndex);
                            poppedIndex = rightChildPoppedIndex;
                        }
                    }
                }

            }
        }
        return returnedData;
    }



    public boolean moveDown(Integer poppedIndex) {
        Integer leftChildPoppedIndex, rightChildPoppedIndex;

        leftChildPoppedIndex = poppedIndex * 2;
        rightChildPoppedIndex = poppedIndex * 2 + 1;

        // Case1 : 왼쪽 자식노드도 없을 때
        if(leftChildPoppedIndex >= this.heapArray.size()) {
            return false;
        // Case2 : 오른쪽 자식노드만 없을 때
        } else if(rightChildPoppedIndex >= this.heapArray.size()){
            if(this.heapArray.get(leftChildPoppedIndex) > this.heapArray.get(poppedIndex)) {
                return true;
            } else {
                return false;
            }
        // Case3 : 둘다 있는 경우
        } else {
            if(this.heapArray.get(leftChildPoppedIndex) > this.heapArray.get(rightChildPoppedIndex)) {
                if(this.heapArray.get(leftChildPoppedIndex) > this.heapArray.get(poppedIndex)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(this.heapArray.get(rightChildPoppedIndex) > this.heapArray.get(poppedIndex)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
