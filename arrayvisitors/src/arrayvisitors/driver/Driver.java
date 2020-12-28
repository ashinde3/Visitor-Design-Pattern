package arrayvisitors.driver;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Logger;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

/**
 * @author Akshay Shinde
 *
 */
public class Driver {
    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

    public static void main(String[] args) throws IllegalArgumentException{

        /*
         * As the build.xml specifies the arguments as input,output or metrics, in case the
         * argument value is not given java takes the default value specified in
         * build.xml. To avoid that, below condition is used
         */
        try {
            if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}")) || (args[2].equals("${common}")) || (args[3].equals("${missing}")) || (args[4].equals("${debug}"))) {
                System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
                System.exit(0);
            }
            System.out.println("Let's start Assignment 4..");
            System.out.println();
            /**
             * Read arguments from command line and store in
             * instance variables
             */
            FileProcessor readInput1 = new FileProcessor(args[0]);
            FileProcessor readInput2 = new FileProcessor(args[1]);
            Results commonOutput = new Results(args[2]);
            Results missingOutput = new Results(args[3]);
            int debugValue = Integer.parseInt(args[4]);
            if(!(debugValue > 0 && debugValue <=6)) {
                throw new NumberFormatException("Debug value should be between 1 and 6 including");
            }
            Logger.setDebugValue(debugValue);
            Element myArray1 = new MyArray(0);
            Element myArray2 = new MyArray(0);
            Element myArrayList = new MyArrayList(0);
            Visitor populate1 = new PopulateMyArrayVisitor(readInput1,myArrayList);
            Visitor populate2 = new PopulateMyArrayVisitor(readInput2,myArrayList);
            Visitor missing = new MissingIntsVisitor(missingOutput);
            Visitor common = new CommonIntsVisitor(commonOutput);

            /**
             * calling visitors
             */
            myArray1.accept(populate1);
            myArray2.accept(populate2);
            missingOutput.writeToFile("Array 1 missing integers");
            myArray1.accept(missing);
            missingOutput.writeToFile("Array 2 missing integers");
            myArray2.accept(missing);
            commonOutput.writeToFile("Common integers in Array 1 and Array 2");
            myArrayList.accept(common);

            /**
             * close files
             */
            commonOutput.close();
            missingOutput.close();
            readInput1.close();
            readInput2.close();
            
        }
        /**
         * Exception handling
         */
        catch (FileNotFoundException file) {
            System.err.println("No File found...Exiting");
            System.err.println(file.getMessage());
            file.printStackTrace();
            System.exit(0);
        }
        catch (IOException io) {
            System.err.println("Invalid I/O processed...Exiting");
            System.err.println(io.getMessage());
            io.printStackTrace();
            System.exit(0);
        }
        catch(InvalidPathException path) {
            System.err.println("Invalid path...Exiting");
            System.err.println(path.getMessage());
            path.printStackTrace();
            System.exit(0);
        }
        catch(SecurityException security) {
            System.err.println("Security Exception check...Exiting");
            System.err.println(security.getMessage());
            security.printStackTrace();
            System.exit(0);
        }
        catch(NumberFormatException number) {
            System.err.println("Invalid number detected...Exiting");
            System.err.println(number.getMessage());
            number.printStackTrace();
            System.exit(0);
        }
        catch(IllegalArgumentException arg) {
            System.err.println("Illegal arguments...Exiting");
            System.err.println(arg.getMessage());
            arg.printStackTrace();
            System.exit(0);
        }
        catch(NullPointerException nullPtr) {
            System.err.println("Null pointer exception...Exiting");
            System.err.println(nullPtr.getMessage());
            nullPtr.printStackTrace();
            System.exit(0);
        }
        finally {

        }       
    }
}


