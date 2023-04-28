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

typealias rollNoTypeAlias = Int
typealias phoneNumberTypeAlias = Int

fun checkAssignmentCompatibilityForTypeAlis(rollNo: rollNoTypeAlias){
    println("checking.. $rollNo")
}

fun checkAssignmentCompatibilityForInlineClasses(rollNo: RollNo){
    println("checking.. $rollNo")
}

//inline classes with delegation
//START
interface SmartPhone {
    fun modelName()
    fun call(name: String) = "Calling $name..."
}

class SamsungM51: SmartPhone {
    override fun modelName() {
        println("SamsungM51")
    }
}

@JvmInline
value class SmartPhoneWrapper(private val phone: SmartPhone): SmartPhone by phone
//END

fun main() {
    val password = Password("abc123")
    println(password.hashCode())        //prints: -1424436592
    println(password)                   //prints: Password(password=abc123)

    //type alias are assignment-compatible
    val rollNum = RollNo(10)

    checkAssignmentCompatibilityForTypeAlis(10)       //no type safety    prints: checking.. 10

//  checkAssignmentCompatibilityForInlineClasses(10)          //direct won't work

    checkAssignmentCompatibilityForInlineClasses(rollNo = rollNum)        //this will work   prints: checking.. RollNo(rollNo=10)

    val samsungM51Phone = SamsungM51()
    val samsungWrapper = SmartPhoneWrapper(samsungM51Phone)
    samsungWrapper.call("Ajay")                             //prints: Calling Ajay...


}