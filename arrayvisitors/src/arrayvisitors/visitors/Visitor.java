package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

import java.io.IOException;

public interface Visitor {
    public void visit(MyArrayI myArray) throws IOException;
    public void visit(MyArrayListI myArrayList);
}

