package com.example.kotlinpractice.classes_and_objects

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains examples of enums in kotlin.
 */

class NormalClassForEnums{
    var sem:Int = 10
}

interface NormalInterface{
    var temp:Int
    fun someTempFun():Int
}

sealed class SealedClassForEnum{

   class SealedClassForEnum1{
       var temp1 = 10
       fun sealedClassFunForEnum1(){
           println("from ${this::class.members.elementAt(1)}")
       }
   }
    class SealedClassForEnum2{
       var temp2 = 20
   }
}

class OuterA{
    private val someValue:Int = 10
    inner class InnerClassB{
        fun printOuterValue(){
            println(someValue)
        }
    }


}

fun String.Companion.newFunction(){
    println("hello this is me from NewFunction in $this")
}

enum class Days(val s:String):NormalInterface {

    MONDAY("monday") {
        override var temp: Int
            get() = 0
            set(value){}

        override fun someTempFun(): Int {
            println("temp is $temp")
            return temp
        }
    };

    init {
        println("init is called")
    }

    constructor() : this("Temp")
}

fun main(){
    val varForSealedClassForEnum = SealedClassForEnum.SealedClassForEnum1()
    varForSealedClassForEnum.sealedClassFunForEnum1()

    var sb:StringBuilder = StringBuilder("Hello")
    String.newFunction()

    OuterA().InnerClassB().printOuterValue()

}