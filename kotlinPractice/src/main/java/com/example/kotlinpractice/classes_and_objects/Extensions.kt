package com.example.kotlinpractice.classes_and_objects

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains code and notes for Extensions functions.
 */


fun main(){

//    fun MutableList<Int>.swap(index1:Int, index2:Int){
//        val temp = this[index1]
//        this[index1] = this[index2]
//        this[index2] = temp
//    }

    //generic
    fun <T> MutableList<T>.swap(index1:Int, index2:Int){
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }

    val someList = mutableListOf<Int>(1,2,3,4,5,6)
    println(someList)
    someList.swap(3,5)
    println(someList)


    //NOTE: extensions are resolved statically
    //      extension do not actually modify the classes they extend. By defining an extension,
    //      you are not inserting new members into a class, only making new functions callable with the dot
    //      notation on variables of this type.
    //      extension functions are dispatched statically, which means they are not virtual by
    //      receiver type.

    //An extension function being called is determined by the type of the expression on
    // which the function is invoked, not by the type of the result from evaluating that
    // expression at runtime. For example:

    open class Shape
    class Rectangle:Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"



    fun printClassName(s: Shape) {
        println(s.getName())
    }

    printClassName(Rectangle()) //prints "Shape"

    //if a class has a member function and an extension function is defined which has the
    //same receiver type, the same name, and is applicable to given arguments, the member
    //always wins.

    //Null Receiver: Note that extensions can be defined with a nullable receiver type.
    //These extensions can be called on an object variable even if its value is null,
    // and they can check for this == null inside the body.

    //ex:
    fun Any?.toString():String{
        if (this == null) return "Null"

        return toString()
    }

    val listOfStrings = listOf<String>("A","B","C","D")
    listOfStrings.lastIndex

    //Companion Object extension
    MyClass.printCompanion()

    Connection(Host("kotl.in"), 443).connect()
    //Host("kotl.in").printConnectionString()  // error, the extension function is unavailable outside Connection

    //    Extensions utilize the same visibility modifiers as regular functions declared in the same scope would. For example:
    //
    //An extension declared at the top level of a file has access to the other private top-level declarations in the same file.
    //
    //If an extension is declared outside its receiver type, it cannot access the receiver's private or protected members.

}
//declaring extensions as members
//You can declare extensions for one class inside another class. Inside such an extension, there are multiple implicit receivers - objects whose members can be accessed
// without a qualifier. An instance of a class in which the extension is declared is called a dispatch receiver, and an instance of the receiver type of the extension
// method is called an extension receiver.

class Host(val hostname: String) {
    fun printHostname() { print(hostname) }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }

    fun Host.printConnectionString() {
        printHostname()   // calls Host.printHostname()
        print(":")
        printPort()   // calls Connection.printPort()
    }

    fun connect() {
        /*...*/
        host.printConnectionString()   // calls the extension function
    }
}

//companion object extension
class MyClass {
    companion object
}

fun MyClass.Companion.printCompanion(){
    println("Companion Object")
}

//extension properties
//since we don't add anything in class using extension, properties don't have backing field and there for in extension properties initializers are not allowed
val <T> List<T>.lastIndex:Int
    get() = size - 1