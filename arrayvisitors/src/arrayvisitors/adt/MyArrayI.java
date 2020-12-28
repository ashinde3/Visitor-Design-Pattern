package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

/**
 * Methods Declaration
 */
public interface MyArrayI extends Element {
    public void addElement(int element);
    public void ensureCapacity(double minCapacity);
    public int getElement(int index);
    public int getSize();
    public int getCapacity();
}

