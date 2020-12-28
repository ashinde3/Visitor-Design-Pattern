package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Logger;
import arrayvisitors.util.Results;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MissingIntsVisitor implements Visitor {
    private Results missingResult;

    /**
     * Constructor
     * @param missingResult
     */
    public MissingIntsVisitor(Results missingResult) {
        Logger.writeMessage("In MissingInts Constructor",Logger.DebugLevel.CONSTRUCTOR);
        this.missingResult = missingResult;
    }

    /**
     * Method to return missing integers from 00-99 range
     * @param myArray
     * @throws IOException
     */
    @Override
    public void visit(MyArrayI myArray) throws IOException {
        Logger.writeMessage("In MissingInts visit",Logger.DebugLevel.MISSINGINT);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<myArray.getSize();i++){
            map.put(myArray.getElement(i),1);
        }

        for (int i=0; i<100; i++){
            if(map.get(i) == null){
                //System.out.println("missing"+i);
                Logger.writeMessage("In Missing ints write to file",Logger.DebugLevel.RESULTS);
                if(i<10)
                    missingResult.writeToFile("0"+i+"");
                else if(i>=10)
                    missingResult.writeToFile(i+"");
            }
        }


    }

    @Override
    public void visit(MyArrayListI myArrayList) {

    }

    /**
     * debugging purpose
     * @return class name of string type
     */
    @Override
    public String toString() {
        return "MissingInts CLASS" + "\n" + getClass().getName() + "\n" ;
    }
}
