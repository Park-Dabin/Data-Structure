import java.lang.reflect.Array;

public class ArrayStack<T> {

    private static final int DEFAULT_ARRAY_SIZE = 8;
    private T[] stackArr;
    private int top;

    public ArrayStack(Class<T> type) {
        stackArr = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);
        top = -1;
    }

    public boolean SIsEmpty() {
        if (top == -1)
            return true;

        return false;
    }

    public void SPush(T data) {
        top++;
        this.stackArr[top] = data;
    }

    public T SPop() {
        if (SIsEmpty()) {
            new ArrayIndexOutOfBoundsException("Stack Memory Error!");
        }
        int rIdx = top;
        top--;
        return this.stackArr[rIdx];
    }

    public T SPeek() {
        if (SIsEmpty()) {
            System.out.println("Stack Memory Error!");
        }
        return this.stackArr[top];
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(Integer.class);

        stack.SPush(1);
        stack.SPush(2);
        stack.SPush(3);
        stack.SPush(4);
        stack.SPush(5);

        while (!stack.SIsEmpty())
            System.out.print(stack.SPop() + " ");
    }
}