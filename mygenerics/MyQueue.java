package mygenerics;
public class MyQueue<T> {
    private Object[] queue;
    private int size;
    private int front;
    private int rear;

    public MyQueue() {
        queue = new Object[10];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void add(T value) {
        if (size == queue.length) {
            resizeQueue();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    public void clear() {
        queue = new Object[10];
        size = 0;
        front = 0;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) queue[front];
    }

    public T poll() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void resizeQueue() {
        int newSize = queue.length * 2;
        Object[] newQueue = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}

class NoSuchElementException extends Throwable {
    public NoSuchElementException(String queueIsEmpty) {
    }
}
class MyQueueTest {
    public static void main(String[] args) throws NoSuchElementException {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        System.out.println("Size: " + myQueue.size()); // Output: Size: 3

        int firstElement = myQueue.peek();
        System.out.println("First element: " + firstElement); // Output: First element: 1

        int removedElement = myQueue.poll();
        System.out.println("Removed element: " + removedElement); // Output: Removed element: 1

        System.out.println("Size after removal: " + myQueue.size()); // Output: Size after removal: 2

        myQueue.clear();
        System.out.println("Size after clearing: " + myQueue.size()); // Output: Size after clearing: 0
    }
}