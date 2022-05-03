package level13;
// 우선순위 큐 구현하기 (힙)
class PriorityQueue {
    int[] data = new int[100];
    int len = 1;

    void push(int x) {
        data[len++] = x;

        int inx = len - 1;
        while(inx > 1 && data[inx/2] > data[inx]) {
            int temp = data[inx/2];
            data[inx/2] = data[inx];
            data[inx] = temp;
        }

    }

    void pop() {
        data[1] = data[len-1];
        data[len-1] = 0;
        len--;

        int inx = 1;
        while(true) {
            // 1. 자식들 중에서 우선순위가 높은 친구를 알아내야함.
            // 2. 나와 그 우선순위가 높은 친구를 비교해서 자리를 바꾸어야함.

            int pInx = -1; // 우선순위가 높은 친구의 노드번호

            // (A) 자식이 모두 없는 경우
            // (B) 왼쪽 자식만 존재하는 경우
            // (C) 왼쪽 오른쪽 자식이 모두 존재하는 경우

            if(len <= inx*2) {
                break;
            } else if((1 <= inx*2 && inx*2 < len) && len <= inx*2+1) {
                pInx = inx*2;
            } else {
                if(data[inx*2] <data[inx*2+1]) {
                    pInx = inx*2;
                } else {
                    pInx = inx*2+1;
                }
            }

            if(data[inx] > data[pInx]) {
                int temp = data[inx];
                data[inx] = data[pInx];
                data[pInx] = temp;

                inx = pInx;
            } else {
                break;
            }

        }


//        while(true) {
//            if(data[inx*2] > data[inx*2+1]) {
//                if(data[inx*2+1] < data[inx]) {
//                    int temp = data[inx];
//                    data[inx] = data[inx*2+1];
//                    data[inx*2+1] = temp;
//                } else {
//                    break;
//                }
//            } else {
//                if(data[inx*2] < data[inx]) {
//                    int temp = data[inx];
//                    data[inx] = data[inx*2];
//                    data[inx*2] = temp;
//                } else {
//                    break;
//                }
//            }
//        }

    }

    int top() {
        return data[1];
    }

}

public class ImplementHeap {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push(3);
        pq.push(1);
        pq.push(2);

        System.out.println(pq.top());
        pq.pop();

        System.out.println(pq.top());
        pq.pop();

        System.out.println(pq.top());
        pq.pop();
    }
}
