import java.lang.reflect.Array;
import java.util.Queue;

public class ArrayQueue<T> {

    private static final int DEFAULT_ARRAY_SIZE = 8;
    private T[] queueArr;
    private int front;
    private int rear;

    public ArrayQueue(Class<T> type) {
        queueArr = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);
        front = 0;
        rear = 0;
    }

    private int NextPosIdx(int pos) {
        if (pos == DEFAULT_ARRAY_SIZE - 1)
            return 0;

        return pos + 1;
    }

    private boolean QIsEmpty() {
        if (front == rear)
            return true;

        return false;
    }

    private void Enqueue(T data) {
        rear = NextPosIdx(rear);
        if (rear == front)
            new ArrayIndexOutOfBoundsException("Queue Memory Full!");

        queueArr[rear] = data;
    }

    private T Dequeue() {
        if (QIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Empty!");

        front = NextPosIdx(front);
        return queueArr[front];
    }

    private T Qpeek() { //맨 처음 저장된 데이터 찾
        if (QIsEmpty())
            new ArrayIndexOutOfBoundsException("Queue Memory Empty!");
        int rIdx = NextPosIdx(front);
        return queueArr[rIdx];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(Integer.class);

        arrayQueue.Enqueue(1);
        arrayQueue.Enqueue(2);
        arrayQueue.Enqueue(3);
        arrayQueue.Enqueue(4);
        arrayQueue.Enqueue(5);

        System.out.println(arrayQueue.Qpeek());

        while (!arrayQueue.QIsEmpty())
            System.out.print(arrayQueue.Dequeue() + " ");
    }
}
