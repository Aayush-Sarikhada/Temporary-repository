package com.example.kotlinpractice.functions;

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains code for diamond problem given by soham bhai.
 */

interface TopLevelInterfaceTop {
     int getValue(String f);
}
interface Interface1Mid {

      int getValueInterface1() ;
}

interface Interface2Mid {
    int getValueInterface2() ;
}
abstract class AbstractClass  implements TopLevelInterfaceTop,Interface1Mid, Interface2Mid{
    @Override
    public int getValue(String f) {
        if (f == "first"){
            return getValueInterface1();
        }else if (f ==  "second"){
            return getValueInterface2();
        }
        return -1;
    }

    @Override
    public int getValueInterface1() {
        return 1;
    }

    @Override
    public int getValueInterface2() {
        return 2;
    }
}
class LowerClass extends AbstractClass{

}

//old tries that did not work
//interface Interface1 {
//    default void commonMethod() {
//        System.out.println("Interface1 method implementation");
//    }
//}
//
//interface Interface2 {
//    default void commonMethod() {
//        System.out.println("Interface2 method implementation");
//    }
//}
//
//class Implementer implements Interface1, Interface2 {
//    @Override
//    public void commonMethod() {
//        commonMethodImpl(this);
//    }
//
//    private static void commonMethodImpl(Interface1 i) {
//        i.commonMethod();
//    }
//
//    private static void commonMethodImpl(Interface2 i) {
//        i.commonMethod();
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Implementer impl = new Implementer();
//        impl.commonMethod();
//    }
//}

//
//interface TopLevelClass{
//    void someFun();
//}
//
//interface FirstMiddleInterface extends TopLevelClass {
//
//}
//
//interface SecondMiddleInterface extends TopLevelClass {
//
//}
//
//abstract class HiddenClass implements FirstMiddleInterface, SecondMiddleInterface{
//    void doSomething(){
//
//    }
//
//    @Override
//    public void someFun() {
//
//    }
//}
//
//public class DiamondProblem {
//
//
//    public static void main(String[] args) {
//
//    }
//}
