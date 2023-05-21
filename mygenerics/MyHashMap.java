package mygenerics;
public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node<K, V> currentNode = table[index];
            Node<K, V> prevNode = null;

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            prevNode.next = newNode;
            size++;
        }

        if (shouldResize()) {
            resizeTable();
        }
    }

    public void remove(K key) {
        int index = getIndex(key);

        if (table[index] == null) {
            return;
        }

        Node<K, V> currentNode = table[index];
        Node<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    table[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % table.length);
    }

    private boolean shouldResize() {
        double loadFactor = (double) size / table.length;
        return loadFactor >= LOAD_FACTOR;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> currentNode : table) {
            while (currentNode != null) {
                int newIndex = getIndex(currentNode.key);
                Node<K, V> newNode = new Node<>(currentNode.key, currentNode.value);

                if (newTable[newIndex] == null) {
                    newTable[newIndex] = newNode;
                } else {
                    Node<K, V> currentNewNode = newTable[newIndex];

                    while (currentNewNode.next != null) {
                        currentNewNode = currentNewNode.next;
                    }

                    currentNewNode.next = newNode;
                }

                currentNode = currentNode.next;
            }
        }

        table = newTable;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
class MyHashMapTest{
    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("one", 1);
        myHashMap.put("two", 2);
        myHashMap.put("three", 3);

        System.out.println("Size: " + myHashMap.size()); // Output: Size: 3

        int value = myHashMap.get("two");
        System.out.println("Value for key 'two': " + value); // Output: Value for key 'two': 2

        myHashMap.remove("one");
        System.out.println("Size after removal: " + myHashMap.size()); // Output: Size after removal: 2

        myHashMap.clear();
        System.out.println("Size after clearing: " + myHashMap.size()); // Output: Size after clearing: 0
    }
}