package arrayvisitors.adt;

import arrayvisitors.util.Logger;
import arrayvisitors.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements MyArrayListI {


    private List<MyArrayI> myElementList;
    private MyArrayI myElement;
    private int size;

    public List<MyArrayI> getMyElementList() {
        return myElementList;
    }

    public void setMyElementList(List<MyArrayI> myElementList) {
        this.myElementList = myElementList;
    }

    /**
     * explicit value constructor
     * @param size
     */
    public MyArrayList(int size) {
        Logger.writeMessage("In MyArrayList constructor",Logger.DebugLevel.CONSTRUCTOR);
        this.size = 0;
        myElementList = new ArrayList<>();
    }

    /**
     * method to retrieve array list size
     * @return size of int type
     */
    @Override
    public int getSize() {
        return myElementList.size();
    }

    /**
     * Method to return myElementList
     * @return myElementList
     */
    public List<MyArrayI> getMyArrayList(){
       return  myElementList;
    }

    @Override
    public MyArrayI getMyElement(int index) {
        return myElementList.get(index);
    }

    /**
     * initalize new array list in constructor
     */
    public MyArrayList() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * method to add integers to the list
     * @param myElement
     */
    @Override
    public void addMyElement(MyArrayI myElement) {
        myElementList.add(myElement);
    }

    /**
     * Clone method overridden
     * @return super clone
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * debug purpose
     * @return class name of string type
     */
    @Override
    public String toString() {
        return "MyArrayList CLASS" + "\n" + getClass().getName() + "\n" ;
    }

    public void finalize() {
    }
}
