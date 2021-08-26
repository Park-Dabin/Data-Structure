public class CircularLinkedList<T> {
    private class Node {
        private T data;
        private Node nextLink;

        private Node() {
            this.data = null;
            this.nextLink = null;
        }

        private Node(T data) {
            this.data = data;
            this.nextLink = null;
        }
    }

    private Node tail;
    private Node cur;
    private Node before;
    private int numOfData;
    private T data;

    public CircularLinkedList() {
        this.tail = null;
        this.cur = null;
        this.before = null;
        this.numOfData = 0;
    }

    public void LInsert(T data) {
        Node newNode = new Node(data);

        if (tail == null) { //tail == null이면 빈 원형 리스
            tail = newNode; //tail
            newNode.nextLink = newNode; //head
        } else {
            newNode.nextLink = tail.nextLink;
            tail.nextLink = newNode;
            tail = newNode;
        }
        numOfData++;
    }

    public void LInsertFront(T data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            newNode.nextLink = newNode;

        } else {
            newNode.nextLink = tail.nextLink;
            tail.nextLink = newNode;
        }
        numOfData++;
    }

    public boolean LFirst() {
        if (tail == null) {
            return false;
        }
        before = tail;
        cur = tail.nextLink;
        data = cur.data;
        return true;
    }

    public boolean LNext() {
        if (tail == null) {
            return false;
        }
        before = cur;
        cur = cur.nextLink;
        data = cur.data;
        return true;
    }

    public T LRemove() {
        Node rpos = cur;
        T rdata = rpos.data;
        if (cur == tail) {
            if (tail == tail.nextLink)
                tail = null;
            else
                tail = before;
        }
        before.nextLink = cur.nextLink;
        cur = before;
        numOfData--;
        return rdata;
    }

    public int LCount() {
        return numOfData;
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();

        circularLinkedList.LInsert(3);
        circularLinkedList.LInsert(4);
        circularLinkedList.LInsert(5);
        circularLinkedList.LInsertFront(2);
        circularLinkedList.LInsertFront(1);

        //데이터 연속 3번 출력
        if (circularLinkedList.LFirst()) {
            System.out.print(circularLinkedList.data + " ");

            for (int i = 0; i < circularLinkedList.LCount() * 3 - 1; i++) {
                if (circularLinkedList.LNext())
                    System.out.print(circularLinkedList.data + " ");
            }
        }
        System.out.println();
        System.out.println();

        //2의 배수를 모두 삭제
        int nodeNum = circularLinkedList.LCount();
        if (nodeNum != 0) {
            circularLinkedList.LFirst();
            if (circularLinkedList.data % 2 == 0)
                circularLinkedList.LRemove();

            for (int i = 0; i < nodeNum - 1; i++) {
                circularLinkedList.LNext();
                if (circularLinkedList.data % 2 == 0)
                    circularLinkedList.LRemove();
            }
        }
        //전체 데이터 1회 출력
        if (circularLinkedList.LFirst()) {
            System.out.print(circularLinkedList.data + " ");
            for (int i = 0; i < circularLinkedList.LCount() - 1; i++) {
                if (circularLinkedList.LNext())
                    System.out.print(circularLinkedList.data + " ");
            }
        }
    }
}
