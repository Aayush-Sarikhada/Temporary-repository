package com.example.kotlinpractice.enums

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example for enums.
*/

//ex:1
enum class Months {
    JAN,FAB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC
}

//ex:2
enum class RGB(private val hexValue: String) {

    RED("FF0000"),
    GREEN("FF0000"),
    BLUE("FF0000");

    fun printColorName(){
        println(this.name)
    }

    fun printHexValue(){
        println(this.hexValue)
    }
}

fun main() {

    val enumObj = Months.valueOf("JAN")                             //throws illegalArgumentException if value doesn't match

    println("${enumObj.name} = ${enumObj.ordinal}")                      //JAN = 0

    print("name: ")
    println(enumObj.declaringJavaClass.name)                             // com.example.kotlinpractice.enums.Months

    print("canonicalName: ")
    println(enumObj.declaringJavaClass.canonicalName)                    //canonicalName: com.example.kotlinpractice.enums.Months

    print("simpleName: ")
    println(enumObj.declaringJavaClass.simpleName)                       //simpleName: Months

    print("typeName: ")
    println(enumObj.declaringJavaClass.typeName)                         //typeName: com.example.kotlinpractice.enums.Months

    val monthsNames = Months.values()
    monthsNames.forEach {
        print("${it.name} ")                                             //JAN FAB MAR APR MAY JUN JUL AUG SEP OCT NOV DEC
    }
    println()

    //2
    val ordinalOfRed = RGB.RED.ordinal
    val blue = RGB.BLUE
    println(ordinalOfRed)                           //0
    blue.printColorName()                           //BLUE
    println(blue.printHexValue())
}