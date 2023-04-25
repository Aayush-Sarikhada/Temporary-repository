package com.example.kotlinpractice.functions

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains notes and examples for lambdas in kotlin.
 */

//refer to AnonymousFunctionsAndLamdas file also
//also refer Notes_FunctionsWithReceiverType file

//kotlin function sare `first-class`:
//which means they can be store in variables and data structures
//can be passed as arguments to and returned from other `higher-order function`
//you can perform any operations on functions that are possible for other non-function values

//HIGHER ORDER FUNCTIONS
//a higher order function is a function that takes a function as argument or returns a function.

//A good example of a higher-order function is the functional programming idiom fold for collections. It takes an initial accumulator value and a combining function and builds its return value by consecutively combining the current accumulator value with each collection element, replacing the accumulator value each time:


//Instantiating a function type

//1. use a code block withing a function literal, in one of the following forms:
    //-> a lambda expression {a,b -> a+b}
    //-> an anonymous functin: fun(s:String): Int{return s.toIntOrNull() ?: 0}
    //->Function literals with receiver can be used as values of function types with receiver.

//2. Use a callable reference to an existing declaration:
//a top-level, local, member, or extension function: ::isOdd, String::toInt,
//
//a top-level, member, or extension property: List<Int>::size,
//
//a constructor: ::Regex


//3. Use instances of a custom class that implements a function type as an interface:
//
//class IntTransformer: (Int) -> Int {
//    override operator fun invoke(x: Int): Int = TODO()
//}
//
//val intFunction: (Int) -> Int = IntTransformer()

class IntToDoubleFun: (Int)->Double {
    override fun invoke(p1: Int): Double {
        return p1.toDouble()
    }
}

//
//fun <T,R> Collection<T>.fold(
//    initial:R,
//    combine: (acc:R,nextElement:T) -> R
//): R {
//    var accumulator = initial
//    for (item in this){
//        accumulator = combine(accumulator,item)
//    }
//    return accumulator
//}

fun imp(lambda:(Int, Int)->Int):Int {
    return lambda(2,3)
}

fun sum() {
    imp{a,b->               //lambda
        a+b
    }
}

fun main(){
    sum()
    print("hello")
    imp(fun(a,b):Int{return a+b})       //anonymous function

    print( arrayOf(2,3,4).fold(0){ acc, current->
        acc+current
    })

    IntToDoubleFun().invoke(10).apply {
        println(this)
    }
}