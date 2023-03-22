package ArrayList_BT1;

import java.util.Arrays;

public class MyList<E> {
    static final int DEFAULT_CAPACITY = 10;
    int size = 0;
    private Object[] elements;

    public MyList(int capacity) {
        elements = new Object[capacity];
    }
    //Tạo mảng mới với số lượng phần tử mới là số lượng phần tử cộng thêm

    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (size == elements.length) {
            ensureCapacity(1);
        }
        for (int i = size; i > index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " ,size: " + index);
        }
        Object temp = elements[index];
        for (int i = index; i < elements.length; i++) {
            elements[i] = elements[i + 1];
        }
        elements = Arrays.copyOf(elements, elements.length - 1);
        return (E) temp;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                size++;
            }
        }
        return size;
    }

    public E clone() {
        Object[] temp = new Object[size()];
        for (int i = 0; i < size(); i++) {
            temp[i] = elements[i];
        }
        return (E) temp;
    }

    public boolean contain(Object o) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    //Lấy ra giá trị trong mảng

    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size++] = element;
        return true;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + index );
        }
        return (E) elements[index];
    }
    public void clear() {
        elements= Arrays.copyOf(elements,0);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}