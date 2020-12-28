Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in arrayvisitors/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile arrayvisitors/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile arrayvisitors/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

```commandline
ant -buildfile arrayvisitors/src/build.xml run -Dinput1="input1.txt" -Dinput2="src/input2.txt" -Dcommon="common.txt" -Dmissing="src/missing.txt" -Ddebug=2
```

Note: Arguments accept the absolute path of the files. Debug values: 1/2/3/4/5/6


-----------------------------------------------------------------------
## Description:

This is Visitor Pattern implementation. There are three visitors PopulateMyArrayVisitor, CommonIntsVisitor, MissingIntsVisitor.
There are 2 input files that is to be read and stored in dynamically created array i.e. MyArray whose initial capacity is 10, and if the capacity grows greater that 10, then the capacity is increased by 50% every time. MyArrayList class contains the ArrayList of MyArray objects that stores MyArray elements in the list.
PopulateMyArrayVisitor visitor class is used to read the input files and store the integers in MyArray eventually adding them to the list.
CommonIntsVisitor takes the instance of MyArrayList to find out the common integers between two input files containing integers.
MissingIntsVisitor takes the instance of MyArray to find out missing integers ranging from 00-99 inclusive with respect to input files.
Driver.java accepts the arguments from command line, stores them in the instance variables, creates instance of MyArray to accept the visitors PopulateMyArrayVisitor and MissingIntsVisitor, and creates instance of MyArrayList to accept the CommonIntsVisitor visitor.


## Justification for Data Structures used in this project:
1. Array : Dynamic array has been created in the class MyArray to insert element, increase capacity by 50% if the size is greater than 10(initial capacity)
Time Complexity: O(n)

2. List : List is used to store the MyArray objects i.e. Elements of MyArray.
Time Complexity: O(n)

3. Map : Map is used to find common integers in 2 input files and missing integers from range 00-99 inclusive.
Time Complexity : O(1) in average case




## Citations:
1. Visitor Pattern : http://www.newthinktank.com/2012/11/visitor-design-pattern-tutorial/
2. Dynamic array for MyArray : https://examples.javacodegeeks.com/dynamic-array-java-example/
