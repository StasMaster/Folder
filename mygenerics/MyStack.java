package mygenerics;
public class MyStack<T> {
    private Object[] stack;
    private int size;
    private int top;

    public MyStack() {
        stack = new Object[10];
        size = 0;
        top = -1;
    }

    public void push(T value) {
        if (size == stack.length) {
            resizeStack();
        }
        top++;
        stack[top] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(stack, index + 1, stack, index, elementsToMove);
        }
        stack[top] = null;
        top--;
        size--;
    }

    public void clear() {
        stack = new Object[10];
        size = 0;
        top = -1;
    }

    public int size() {
        return size;
    }

    public T peek() throws NoSuchQueueElementException {
        if (isEmpty()) {
            throw new NoSuchQueueElementException("Stack is empty");
        }
        return (T) stack[top];
    }

    public T pop() throws NoSuchQueueElementException {
        if (isEmpty()) {
            throw new NoSuchQueueElementException("Stack is empty");
        }
        T value = (T) stack[top];
        stack[top] = null;
        top--;
        size--;
        return value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void resizeStack() {
        int newSize = stack.length * 2;
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }
}
class NoSuchQueueElementException extends Throwable {
    public NoSuchQueueElementException(String queueIsEmpty) {
    }
}
class MyStackTest{
    public static void main(String[] args) throws NoSuchQueueElementException {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("Size: " + myStack.size()); // Output: Size: 3

        int topElement = myStack.peek();
        System.out.println("Top element: " + topElement); // Output: Top element: 3

        int poppedElement = myStack.pop();
        System.out.println("Popped element: " + poppedElement); // Output: Popped element: 3

        System.out.println("Size after popping: " + myStack.size()); // Output: Size after popping: 2

        myStack.clear();
        System.out.println("Size after clearing: " + myStack.size()); // Output: Size after clearing: 0
    }
}