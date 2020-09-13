package mycode.section2;

import java.util.Arrays;

// AKA ArrayList
public class DynamicArray<T> {

    private Object[] data;

    // Counter for the number of elements in our array
    private int size = 0;

    // The capacity of our array - or how many elements it can hold.
    // What we double when the number of elements exceeds the capacity of the array.
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];     
    }

    public String get(int index) {
        return (String) data[index];
    }

    // |a|b|c|d|
    public void set(int index, String value) {
        if(size == data.length) {
            resize();
        }
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds!");
        }
        data[index] = value;
    }

    // |a|b|c|d|
    public void insert(int index, String value) {
        if(size == data.length) {
            resize();
        }
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    //
    // You try
    // Try implementing delete, isEmpty, and Contains on your own.
    // You can find the solution at the bottom

    // |a|b|b|c|
    public void delete(int index) {
        if(index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds!");
        }
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean Contains(String value) {
        for(int i = 0; i < size; i++) {
            String s = (String) data[i];
            if(value.equals(s)) {
                return true;
            }
        }
        return false;
    }
    

    private void resize() {
        Object[] resized = new Object[size * 2];
        for(int i = 0; i < size; i++) {
            resized[i] = data[i];
        }
        data = resized;
    }

    public int size() {
        return size;
    }

    public void print() {
    	System.out.println(Arrays.toString(data) + " size:" + size);
    }

    // Some array implementations offer methods like insert (also known as pushBack).
    // Which is like insert, only in does the insert at the end of the array.
    public void add(String value) {
        if(size == data.length) {
            resize();
        }
        data[size] = value;
        size++;        
    }
}
