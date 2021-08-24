public class DoublyLinkedList<T> {
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
    private Node cur;
    private int numOfData;
    private T data;

    public void LInsert(T data) {
        Node newNode = new Node(data);

        newNode.nextLink = head;
        if (head != null)
            head.prevLink = newNode;

        newNode.prevLink = null;
        head = newNode;
        numOfData++;
    }

    public boolean LFirst() {
        if (head == null)
            return false;
        cur = head;
        data = cur.data;
        return true;
    }

    public boolean LNext() {
        if (cur.nextLink == null)
            return false;
        cur = cur.nextLink;
        data = cur.data;
        return true;
    }

    public boolean LPrevious() {
        if (cur.prevLink == null)
            return false;
        cur = cur.prevLink;
        data = cur.data;
        return true;
    }

    public T LRemove() {
        Node rpos = cur;
        T rdata = rpos.data;

        cur.prevLink.nextLink = cur.nextLink;
        cur.nextLink.prevLink = cur.prevLink;
        cur = cur.prevLink;
        numOfData--;
        return rdata;
    }

    public int LCount() {
        return numOfData;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> DoublyLinkedList = new DoublyLinkedList<>();

        DoublyLinkedList.LInsert(1);
        DoublyLinkedList.LInsert(2);
        DoublyLinkedList.LInsert(3);
        DoublyLinkedList.LInsert(4);
        DoublyLinkedList.LInsert(5);
        DoublyLinkedList.LInsert(6);
        DoublyLinkedList.LInsert(2);
        DoublyLinkedList.LInsert(7);
        DoublyLinkedList.LInsert(8);

        System.out.print("현재 데이터의 수 : " + DoublyLinkedList.LCount() + " ");
        if (DoublyLinkedList.LFirst()) {
            System.out.print(DoublyLinkedList.data + " ");

            while (DoublyLinkedList.LNext())
                System.out.print(DoublyLinkedList.data + " ");

            while (DoublyLinkedList.LPrevious())
                System.out.print(DoublyLinkedList.data + " ");
        }
        System.out.println();
        System.out.println();

        if (DoublyLinkedList.LFirst()) {
            if (DoublyLinkedList.data == 2)
                DoublyLinkedList.LRemove();

            while (DoublyLinkedList.LNext()) {
                if (DoublyLinkedList.data == 2)
                    DoublyLinkedList.LRemove();
            }
        }

        System.out.print("현재 데이터의 수 : " + DoublyLinkedList.LCount() + " ");
        if (DoublyLinkedList.LFirst()) {
            System.out.print(DoublyLinkedList.data + " ");

            while (DoublyLinkedList.LNext())
                System.out.print(DoublyLinkedList.data + " ");

            while (DoublyLinkedList.LPrevious())
                System.out.print(DoublyLinkedList.data + " ");
        }
    }
}
