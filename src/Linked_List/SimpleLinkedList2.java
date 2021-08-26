import java.util.Comparator;

public class SimpleLinkedList2<T> {
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

    private Node head; //더미 노드를 가르킴
    private Node cur; //참조 및 삭제
    private Node before; //삭제
    private int numOfData;
    private Comparator<T> comp; //정렬의 기준을 등록하기 위한 변수
    private T data;

    public SimpleLinkedList2() {
        this.head = new Node(); //더미노드
        this.head.nextLink = null;
        this.comp = null;
        this.numOfData = 0;
    }

    public void LInsert(T data) {
        if (comp == null) { //정렬기준이 없다면
            FInsert(data); //head에 노드 추가
        } else SInsert(data);
    }

    //정렬의 기준이 없을 때 데이터 추가
    public void FInsert(T data) {
        Node newNode = new Node(data);
        newNode.nextLink = head.nextLink; //더미노드의 next가 newNode의 next가 됨
        head.nextLink = newNode; //newNode는 더미노드의 next가 됨
        numOfData++; //데이터 수 1 증가
    }

    //정렬의 기준이 있을 때 데이터 추가
    public void SInsert(T data) {
        Node newNode = new Node(data);
        Node pred = head;
        newNode.data = data;

        while (pred.nextLink != null && comp.compare(data, pred.nextLink.data) != 0) {
            //1. pred가 마지막 노드를 가르키는지 2. pred의 nextLink data가 head랑 더 가까운
            pred = pred.nextLink;
        }
        newNode.nextLink = pred.nextLink;
        pred.nextLink = newNode;
        numOfData++;
    }

    //첫 번째 데이터 탐색
    public boolean LFirst() {
        if (head.nextLink == null) { //뒤가 없을 때
            return false;
        }
        before = head; //before = head(더미)
        cur = head.nextLink; //cur은 더미 뒤의 첫 번째 노드
        data = cur.data;
        return true;
    }

    public boolean LNext() {
        if (cur.nextLink == null) {
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
        before.nextLink = cur.nextLink;
        cur = before;
        numOfData--;
        return rdata;
    }

    public int LCount() {
        return numOfData;
    }

    public void SetSortRule(Comparator<T> comp) {
        this.comp = comp;
    }

    public static void main(String[] args) {
        SimpleLinkedList2<Integer> simpleLinkedList2 = new SimpleLinkedList2<>();
        simpleLinkedList2.SetSortRule(
                (d1, d2) -> {
                    if (d1 < d2)
                        return 0;
                    else
                        return 1;
                }
        );

        simpleLinkedList2.LInsert(11);
        simpleLinkedList2.LInsert(11);
        simpleLinkedList2.LInsert(22);
        simpleLinkedList2.LInsert(22);
        simpleLinkedList2.LInsert(33);

        System.out.println("현재 데이터의 수 : " + simpleLinkedList2.LCount());

        if (simpleLinkedList2.LFirst()) {
            System.out.print(simpleLinkedList2.data + " ");

            while (simpleLinkedList2.LNext())
                System.out.print(simpleLinkedList2.data + " ");
        }
        System.out.println();
        System.out.println();

        simpleLinkedList2.LInsert(15);
        simpleLinkedList2.LInsert(55);
        simpleLinkedList2.LInsert(32);
        System.out.println("현재 데이터의 수 : " + simpleLinkedList2.LCount());
        if (simpleLinkedList2.LFirst()) {
            System.out.print(simpleLinkedList2.data + " ");

            while (simpleLinkedList2.LNext())
                System.out.print(simpleLinkedList2.data + " ");
        }
    }
}
