package arrayvisitors.adt;

/**
 * Citation: https://examples.javacodegeeks.com/dynamic-array-java-example/
 */

import arrayvisitors.util.Logger;
import arrayvisitors.visitors.Visitor;

import java.io.IOException;

public class MyArray implements MyArrayI {
    private int myElement[];
    private int size;
    private int capacity;

    /**
     * Constructor initialized with new array of size 10
     */
    public MyArray() {

    }

    public int[] getMyElement() {
        return myElement;
    }

    public void setMyElement(int[] myElement) {
        this.myElement = myElement;
    }

    public MyArray(int size) {
        Logger.writeMessage("In MyArray constructor",Logger.DebugLevel.CONSTRUCTOR);
        this.size = 0;
        myElement = new int[10];
        capacity = 10;
    }

    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }

    /**
     * Method to add integer element in the array
     * @param element
     */
    @Override
    public void addElement(int element) {
        if(size == capacity) {
            ensureCapacity(0.5);
        }
        myElement[size] = element;
        size++;
    }

    /**
     * Method to handle capacity i.e. if capacity is >10, increase it by 50% of original capacity
     * @param minCapacity
     */
    @Override
    public void ensureCapacity(double minCapacity) {
        int temp[] = new int[capacity + ((int)(capacity * 0.5))];
        for(int i = 0; i < capacity; i++) {
            temp[i] = myElement[i];
        }
        myElement = temp;
        capacity = capacity + ((int)(capacity * 0.5));
    }

    /**
     * Method to retrieve integers stored
     * @param index
     * @return myElement of type int
     */
    @Override
    public int getElement(int index) {
        return myElement[index];
    }

    /**
     * Method to return size of the array
     * @return size of type int
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to return capacity
     * @return capacity of type int
     */
    public int getCapacity() {
        return capacity;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void finalize() {
    }
    /**
     * toString method for debugging
     * @return class name of String type
     */
    @Override
    public String toString() {
        return "MyArray CLASS" + "\n" + getClass().getName() + "\n" ;
    }
}
