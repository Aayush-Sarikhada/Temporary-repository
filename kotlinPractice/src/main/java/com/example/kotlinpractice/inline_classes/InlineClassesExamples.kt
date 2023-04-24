package com.example.kotlinpractice.inline_classes

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains examples of inline classes and their workings.
 */

@JvmInline
value class Password(private val ps:String){
}

//Inline classes vs type aliases
@JvmInline
value class FirstInlineClass(val n:Int)

@JvmInline
value class SecondInlineClass(val n:Int)

typealias FirstInline = Int
typealias SecondInline = Int

fun checkForAssignmentCompatiblityForTypeAlis(s:FirstInline){
    println("checking.. $s")
}

fun checkForAssignmentCompatiblityForInlineClasses(s:FirstInlineClass){
    println("checking.. $s")
}

//check for can we access class or functions without import in other files
//checked in other file called com.example.kotlinpractice.classes_and_objects.Classes.kt
//START
internal class TEMP(){
    fun first(){

    }
}

internal fun TEMP.second(){
    println("Second")
}
//END


//inline classes with delegation
//START
interface MyInterface{
    fun emptyFun()
    fun nonEmptyFun() = "its non Empty Fun"
}

class ImplMyInterface: MyInterface{
    override fun emptyFun() {
        println("its empty fun")
    }

}

@JvmInline
value class MyInterfaceWrapper(private val x:MyInterface): MyInterface by x

//END


fun main(){
    val ps = Password("abcdefg")
    println(ps.hashCode())
    println(ps)

    //type alias are assignment-compatible
    val first = FirstInlineClass(10)
    val second = SecondInlineClass(11)

    checkForAssignmentCompatiblityForTypeAlis(10)
//  checkForAssignmentCompatiblityForInlineClasses(10)          //direct won't work
    checkForAssignmentCompatiblityForInlineClasses(FirstInlineClass(10))        //this will work

    val impl = ImplMyInterface()
    val myIntefaceWrapper = MyInterfaceWrapper(impl)
    myIntefaceWrapper.nonEmptyFun()


}