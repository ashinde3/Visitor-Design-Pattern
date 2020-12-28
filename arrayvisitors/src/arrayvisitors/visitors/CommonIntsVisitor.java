package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Logger;
import arrayvisitors.util.Results;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommonIntsVisitor implements Visitor  {
    private Results commonResult;

    /**
     * Constructor
     * @param commonResult
     */
    public CommonIntsVisitor(Results commonResult) {
        Logger.writeMessage("In CommonInts Constructor",Logger.DebugLevel.CONSTRUCTOR);
        this.commonResult = commonResult;
    }

    @Override
    public void visit(MyArrayI myArray) throws IOException {

    }

    /**
     * method to find common integers between 2 arrays of integers
     * @param myArrayList
     */
    @Override
    public void visit(MyArrayListI myArrayList) {
        Logger.writeMessage("In CommonInts visit method",Logger.DebugLevel.COMMONINT);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        MyArrayI firstArray= myArrayList.getMyArrayList().get(0);
        for(int i = 0; i < firstArray.getSize(); i++){
            map.put(firstArray.getElement(i),1);
        }
        MyArrayI secondArray= myArrayList.getMyArrayList().get(1);
        for(int i = 0; i < secondArray.getSize(); i++){
            map2.put(secondArray.getElement(i),1);
        }
         for(int num: map2.keySet()){
             if(map.get(num) != null){
                 //System.out.println("common"+num);
                 Logger.writeMessage("In Common ints write to file",Logger.DebugLevel.RESULTS);
                 if(num < 10)
                    commonResult.writeToFile("0"+num+"");
                 else if(num >= 10)
                     commonResult.writeToFile(num+"");
             }
         }

    }

    /**
     * debugging purpose
     * @return class name of string type
     */
    @Override
    public String toString() {
        return "CommonInts CLASS" + "\n" + getClass().getName() + "\n" ;
    }
}
