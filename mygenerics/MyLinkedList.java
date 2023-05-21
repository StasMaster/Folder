package mygenerics;
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        validateIndex(index);
        Node<T> nodeToRemove = getNode(index);
        Node<T> prevNode = nodeToRemove.prev;
        Node<T> nextNode = nodeToRemove.next;

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            nodeToRemove.prev = null;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
            nodeToRemove.next = null;
        }

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        validateIndex(index);
        Node<T> node = getNode(index);
        return node.value;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

class MyLinkedListTest{
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("First");
        myList.add("Second");
        myList.add("Third");

        System.out.println("Size: " + myList.size()); // Output: Size: 3

        String secondElement = myList.get(1);
        System.out.println("Second element: " + secondElement); // Output: Second element: Second

        myList.remove(0);
        System.out.println("Size after removal: " + myList.size()); // Output: Size after removal: 2

        myList.clear();
        System.out.println("Size after clearing: " + myList.size()); // Output: Size after clearing: 0
        System.out.println("_______________________");


        MyLinkedList myList2 = new MyLinkedList();
        myList2.add("First");
        myList2.add(true);
        myList2.add(3.0d);
        myList2.add(567);
        for (int i = 0; i < myList2.size(); i++) {
            System.out.println(myList2.get(i));
        }
        System.out.println("_______________________");
    }
}