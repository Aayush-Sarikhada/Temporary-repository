package com.example.kotlinpractice.enums

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example for enums.
*/

//ex:1
enum class Months{
    JAN,FAB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC
}

//ex:2
enum class RGB(hexValue:String){

    RED("FF0000"),
    GREEN("FF0000"),
    BLUE("FF0000");

    fun printItsName(){
        println(this.name)
    }

}

fun main() {


    val enumObj = Months.valueOf("JAN")                         //throws illegalArgumentException if value doesn't match
    println("${enumObj.name} = ${enumObj.ordinal}")
    print("name: ")
    println(enumObj.declaringJavaClass.name)
    print("canonicalName: ")
    println(enumObj.declaringJavaClass.canonicalName)
//    println(enumObj.declaringJavaClass.packageName)           //won't work for below java 9
    print("simpleName: ")
    println(enumObj.declaringJavaClass.simpleName)
    print("typeName: ")
    println(enumObj.declaringJavaClass.typeName)

    val arrayOfEnumsConstants = Months.values()
    arrayOfEnumsConstants.forEach {
        println(it.name)
    }

    //2
    val red = RGB.RED.ordinal
    val blue = RGB.BLUE
    println(red)
    blue.printItsName()

}