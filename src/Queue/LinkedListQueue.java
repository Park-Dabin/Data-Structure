import sun.tools.tree.NewArrayExpression;

public class LinkedListQueue<T> {

    private Node front;
    private Node rear;

    private class Node {
        private T data;
        private Node nextLink;

        private Node(T data) {
            this.data = data;
            this.nextLink = null;
        }
    }

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    private boolean QIsEmpty() {
        if (front == null)
            return true;

        return false;
    }

    private void Enqueue(T data) {
        Node newNode = new Node(data);

        if (QIsEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.nextLink = newNode;
            rear = newNode;
        }
    }

    private T Dequeue() {
        if (QIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Empty!");

        Node rNode = front;
        front = front.nextLink;

        return rNode.data;
    }

    private T QPeek() {
        if (QIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Empty!");

        Node rNode = front;

        return rNode.data;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        linkedListQueue.Enqueue(1);
        linkedListQueue.Enqueue(2);
        linkedListQueue.Enqueue(3);
        linkedListQueue.Enqueue(4);
        linkedListQueue.Enqueue(5);

        System.out.println(linkedListQueue.QPeek());
        System.out.print(linkedListQueue.Dequeue() + " ");
        System.out.println(linkedListQueue.Dequeue());

        while (!linkedListQueue.QIsEmpty())
            System.out.print(linkedListQueue.Dequeue() + " ");
    }
}
