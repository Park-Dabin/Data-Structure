public class LinkedListStack<T> {
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

    private Node head;

    public LinkedListStack() {
        head = null; //빈 스택
    }

    public boolean SIsEmpty() {
        if (head == null)
            return true;

        return false;
    }

    public void SPush(T data) {
        Node newNode = new Node(data);
        newNode.nextLink = head;
        head = newNode;
    }

    public T SPop() {
        if (SIsEmpty())
            new ArrayIndexOutOfBoundsException("Stack Memory Error!");

        T rdata = head.data;
        head = head.nextLink;
        return rdata;
    }

    public T SPeek() {
        if (SIsEmpty())
            new ArrayIndexOutOfBoundsException("Stack Memory Error!");

        return head.data;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        stack.SPush(1);
        stack.SPush(2);
        stack.SPush(3);
        stack.SPush(4);
        stack.SPush(5);

        System.out.println(stack.SPeek());

        while (!stack.SIsEmpty())
            System.out.print(stack.SPop() + " ");
    }


}
