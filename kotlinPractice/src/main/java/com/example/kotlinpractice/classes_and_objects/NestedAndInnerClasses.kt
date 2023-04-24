package com.example.kotlinpractice.classes_and_objects

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains one example of difference between Nested class and Inner class.
 */



class TopClass{
    var someStringVar:String = ""
    inner class NestedInnerClass{
        var anotherVar:String = "nested1"
        fun helloGuys(){
            println("hello guys!! ${someStringVar}")
        }
    }
    class NestedClass{
        var anotherVar:String = "nested2"
        fun helloGuys(){
            println("hello guys!!  ${TopClass().someStringVar}")
        }
    }
}

fun main(){

    var tc1 = TopClass.NestedClass().anotherVar

    //we have to create an object of outer class to actually access the inner nested class
    var tc2 = TopClass().NestedInnerClass().helloGuys()
}