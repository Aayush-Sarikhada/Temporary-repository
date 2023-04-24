package com.example.kotlinpractice.after_second_kt

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains practices i did after my SecondKT of kotlin language.
 */

interface MonthsInterface{
    fun getDays():Int
}
enum class FirstTwoMonths: MonthsInterface{
    JAN{
        override fun getDays(): Int {
            return 31
        }}
,
FAB{
    override fun getDays(): Int {
return 29
    }}
}

@JvmInline
value class Password(private val pass:String){
    val encriptedPass:String
        get() = pass.hashCode().toString()
    init {
        println("init ran in inline class")
    }
    init {
        println("another init ran in inline class")
    }
    constructor(anotherPass:String, encription:Boolean) : this(anotherPass)
}
//call
class TopLevelClassForMyCallbackInterfaceResult{
    val temp:MyCallbackInterface = TestMyCallbackInterface()

    fun giveResult(){
        //    work()
        val result = true
        temp.callback(result)
    }
}
fun interface MyCallbackInterface{
    fun callback(result:Boolean)
}

class TestMyCallbackInterface:MyCallbackInterface{
    override fun callback(result: Boolean) {
        println("result is $result")
    }
}

fun main(){

    val ar1 = Array<Int>(10){0}
    val ar2 = Array<Int>(10){0}
    println(ar1 === ar2)
    println(ar1.contentEquals(ar2))

    val arl1 = arrayListOf(0)
    val arl2 = arrayListOf(0)
    println(arl1 === arl2)
    println(arl1 == arl2)

}