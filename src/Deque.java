public class Deque<T> {

    private class Node {
        private T data;
        private Node prevLink;
        private Node nextLink;

        private Node(T data) {
            this.data = data;
            this.prevLink = null;
            this.nextLink = null;
        }
    }

    private Node head;
    private Node tail;

    private boolean DQIsEmpty() {
        if (head == null)
            return true;

        return false;
    }


    private void DQAddFirst(T data) {
        Node newNode = new Node(data);
        newNode.nextLink = head;

        if (DQIsEmpty()) {
            tail = newNode;
        } else {
            head.prevLink = newNode;
        }

        newNode.prevLink = null;
        head = newNode;
    }

    private void DQAddLast(T data) {
        Node newNode = new Node(data);
        newNode.prevLink = tail;

        if (DQIsEmpty()) {
            head = newNode;
        } else {
            tail.nextLink = newNode;
        }
        newNode.nextLink = null;
        tail = newNode;
    }

    private T DQRemoveFirst() {
        if (DQIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Empty!");

        Node rNode = head;
        head = rNode.nextLink;

        if (head == null) {
            tail = null;
        } else {
            head.prevLink = null;
        }

        return rNode.data;
    }

    private T DQRemoveLast() {
        if (DQIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Empty!");

        Node rNode = tail;
        tail = tail.prevLink;

        if (tail == null) {
            head = null;
        } else {
            tail.nextLink = null;
        }

        return rNode.data;
    }

    private T DQGetFirst() {
        if (DQIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Error!");

        return head.data;
    }

    private T DQGetLast() {
        if (DQIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Error!");

        return tail.data;
    }

    public static void main(String[] args) {
        Deque<Integer> Deque = new Deque<>();

        // 데이터 넣기 1차
        Deque.DQAddFirst(3);
        Deque.DQAddFirst(2);
        Deque.DQAddFirst(1);

        Deque.DQAddLast(5);
        Deque.DQAddLast(6);
        Deque.DQAddLast(4);

        // 데이터 꺼내기 1차
        while (!Deque.DQIsEmpty())
            System.out.print(Deque.DQRemoveFirst() + " ");

        System.out.println();

        // 데이터 넣기 2차
        Deque.DQAddFirst(3);
        Deque.DQAddFirst(2);
        Deque.DQAddFirst(1);

        Deque.DQAddLast(4);
        Deque.DQAddLast(5);
        Deque.DQAddLast(6);

        // 데이터 꺼내기 2차
        while (!Deque.DQIsEmpty())
            System.out.print(Deque.DQRemoveLast() + " ");
    }
}