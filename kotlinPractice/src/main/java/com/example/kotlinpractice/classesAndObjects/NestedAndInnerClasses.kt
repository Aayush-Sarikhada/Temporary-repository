package com.example.kotlinpractice.classesAndObjects

/*
Created By: Aayush Sarikhada
Updated on: 27 apr 2023

This file contains one example of difference between Nested class and Inner class.
*/

class OuterClass {
    var outerClassString: String = "Outer class"

    inner class NestedInnerClass {
        var nestedInnerClassString: String = "nested inner class"

        fun printOuterClassString() {
            println("hello $outerClassString")
        }
    }

    class NestedClass {
        var nestedClassString: String = "nested class"

        fun printOuterClassString() {
            println("hello ${OuterClass().outerClassString}")
        }
    }
}

fun main(){

    var nestedClassStringInOuterClass = OuterClass.NestedClass().nestedClassString

    // we have to create an object of outer class to actually access the inner nested class
    OuterClass().NestedInnerClass().printOuterClassString()      // prints "hello outer class
}