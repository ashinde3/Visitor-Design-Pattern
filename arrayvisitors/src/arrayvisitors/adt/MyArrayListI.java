package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

import java.util.List;

/**
 * Methods Declaration
 */
public interface MyArrayListI extends Element {
    public void addMyElement(MyArrayI myElement);
    public int getSize();
    public List<MyArrayI> getMyArrayList();
    public MyArrayI getMyElement(int index);
}
