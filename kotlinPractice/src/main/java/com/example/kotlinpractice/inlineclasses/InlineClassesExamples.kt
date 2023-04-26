package com.example.kotlinpractice.inlineclasses

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains examples of inline classes and their workings.
 */

@JvmInline
value class Password(private val password: String)

//Inline classes vs type aliases
@JvmInline
value class RollNo(val rollNo: Int)
@JvmInline
value class PhoneNumber(val number: Int)

typealias rollNoTypeAlis = Int
typealias phoneNumberTypeAlias = Int

fun checkForAssignmentCompatiblityForTypeAlis(rollNo: rollNoTypeAlis){
    println("checking.. $rollNo")
}

fun checkForAssignmentCompatiblityForInlineClasses(rollNo: RollNo){
    println("checking.. $rollNo")
}

//inline classes with delegation
//START
interface SmartPhone{
    fun modelName()
    fun call(name: String) = "Calling $name..."
}

class SamsungM51: SmartPhone{
    override fun modelName() {
        println("SamsungM51")
    }
}

@JvmInline
value class SmartPhoneWrapper(private val phone: SmartPhone): SmartPhone by phone

//END

fun main(){
    val password = Password("abc123")
    println(password.hashCode())        //prints: -1424436592
    println(password)                   //prints: Password(password=abc123)

    //type alias are assignment-compatible
    val rollNum = RollNo(10)

    checkForAssignmentCompatiblityForTypeAlis(10)       //no type safety    prints: checking.. 10

//  checkForAssignmentCompatiblityForInlineClasses(10)          //direct won't work

    checkForAssignmentCompatiblityForInlineClasses(rollNo = rollNum)        //this will work   prints: checking.. RollNo(rollNo=10)

    val samsungM51Phone = SamsungM51()
    val samsungWrapper = SmartPhoneWrapper(samsungM51Phone)
    samsungWrapper.call("Ajay")                             //prints: Calling Ajay...


}