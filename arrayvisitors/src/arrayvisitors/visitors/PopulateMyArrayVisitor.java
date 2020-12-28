package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PopulateMyArrayVisitor implements Visitor {

    private FileProcessor fileIn;
    private MyArrayListI myArrayList;

    /**
     * Constructor that takes instance of file processor
     * @param fileIn
     */
    public PopulateMyArrayVisitor(FileProcessor fileIn, Element myArrayList) {
        Logger.writeMessage("In Populate my array visitor constructor",Logger.DebugLevel.CONSTRUCTOR);
        this.fileIn = fileIn;
        this.myArrayList = (MyArrayList) myArrayList;
    }


    /**
     * Method to read the 2 input files and insert the elements i.e. integers
     * to MyArray and store it in MyArrayList
     * @param myArray
     * @throws IOException
     * @throws NumberFormatException
     */
    @Override
    public void visit(MyArrayI myArray) throws IOException, NumberFormatException {
        Logger.writeMessage("In Populate my array visitor visit",Logger.DebugLevel.POPULATE);
        String line;
        boolean emptyFileCheck = false;
        while(null != (line = fileIn.poll())) {
            emptyFileCheck = true;
            int number = Integer.parseInt(line);
            myArray.addElement(number);
        }
        if(emptyFileCheck == false) {
            System.err.println("Found empty file..Exiting");
            System.exit(0);
        }
        myArrayList.addMyElement(myArray);

    }

    @Override
    public void visit(MyArrayListI myArrayList) {

    }

    /**
     * debug purpose
     * @return class name of string type
     */
    @Override
    public String toString() {
        return "PopulateArray CLASS" + "\n" + getClass().getName() + "\n" ;
    }
}
