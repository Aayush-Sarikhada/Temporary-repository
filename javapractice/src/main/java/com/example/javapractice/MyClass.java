package com.example.javapractice;

import static com.sun.tools.classfile.AccessFlags.Kind.InnerClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




class OuterClass  {
        static int someVar = 10;
          static class SomeInnerClass {
                void printOuterVar(){
                    System.out.println(someVar);
                }
        }

}
class DataClass{
    private int numOfLines = 20;
    public int getNumOfLines(){
        return numOfLines;
    }
    public void setNumOfLines(int lines){
        this.numOfLines = lines;
    }
}
public class MyClass{

        OuterClass.SomeInnerClass v =  new OuterClass.SomeInnerClass();
        public static void main(String[] args) {

        }



}

