package mycode.section2;

import java.util.Arrays;

public class DynamicArray<T> {

    private Object[] data;

    // Counter for the number of elements in our array
    private int size = 0;

    // The capacity of our array - or how many elements it can hold.
    // What we double when the number of elements exceeds the capacity of the array.
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[this.initialCapacity];
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        if(index > -1) {
            data[index] = value;
        }
        if(index == size) {
        	size++;
        }
    }

    // |a|b|c|d|
    public void insert(int index, String value) {
        if(data.length == size) {
            this.resize();
        }
        if(index > -1) {
            for(int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = value;
            size++;
        } 
    }

    //
    // You try
    // Try implementing delete, isEmpty, and Contains on your own.
    // You can find the solution at the bottom

    // |a|b|b|c|
    public void delete(int index) {
        if(!isEmpty()) {
            if(index > -1 && index < size) {
            	// if delete last item
                if(index == size - 1) {
                	data[index] = null;
                	size--;
                	return;
                }
                for(int i = index; i < size; i++) {
                    data[i] = data[i + 1];
                }
                size--;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean Contains(String value) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(value)) {
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
        if(data.length == size) {
            this.resize();
        }
        data[size] = value;
        size++;
    }
}