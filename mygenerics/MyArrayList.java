package mygenerics;
public class MyArrayList<T> {
    private T[] array;
    private int size;

    public MyArrayList() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    public void add(T value) {
        if (size == array.length) {
            // Увеличиваем размер массива в два раза, если достигли его предела
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        // System.arraycopy(array, index + 1, array, index, size - index - 1);

        array[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
//        list.add(1.0d); // Ошибка компиляции: неправильный тип если типизоровать <String>
//        list.add(true); // Ошибка компиляции: неправильный тип если типизоровать <String>

        System.out.println("Size: " + list.size());  // Output: Size: 3
        System.out.println("Elements:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(1);
        System.out.println("Size after removal: " + list.size());  // Output: Size after removal: 2
        System.out.println("Elements after removal:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.clear();
        System.out.println("Size after clearing: " + list.size());  // Output: Size after clearing: 0
        System.out.println("_______________________");



        MyArrayList list2 = new MyArrayList();
        list2.add("Elem1");
        list2.add("Elem2");
        list2.add(1.0d); // Нет ошибки компиляции так как не типизирован <String>
        list2.add(true); // Нет ошибки компиляции так как не типизирован <String>

        System.out.println("Size: " + list2.size());  // Output: Size: 3
        System.out.println("Elements:");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        list2.remove(1);
        System.out.println("Size after removal: " + list2.size());  // Output: Size after removal: 2
        System.out.println("Elements after removal:");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        list2.clear();
        System.out.println("Size after clearing: " + list2.size());  // Output: Size after clearing: 0
        System.out.println("_______________________");
    }
}