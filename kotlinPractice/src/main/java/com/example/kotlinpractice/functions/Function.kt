package com.example.kotlinpractice.functions

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains Notes and examples related to functions in kotlin.
 */

open class ArithmeticOperationClass {
    open fun sumThese(x: Int = 0, y: Int = 0) = x + y
    open fun multiplyThese(x: Int = 0, y: Int = 0) = x * y
    open fun divideThese(x: Int = 0, y: Int = 0) = x / y
    open fun moduloThese(x: Int = 0, y: Int = 0) = x % y

}
class OverridingArithmeticOperationClass:ArithmeticOperationClass()

//note:When calling Java functions on the JVM, you can't use the named argument syntax because Java bytecode does not always preserve the names of function parameters.

//You can pass a variable number of arguments (vararg) with names using the spread operator(*):

fun sumTheseNumbers(vararg numbers: Int) = numbers.sum()

//Single-expression functions
//When a function returns a single expression, the curly braces can be omitted and the body is specified after a = symbol:

//functions with block body must always specify return types explicitly, unless it's intended for them to return Unit, in which case specifying the return type is optional.
//
//Kotlin does not infer return types for functions with block bodies because such functions may have complex control flow in the body, and the return type will be non-obvious to the reader (and sometimes even for the compiler).

//functions marked with the infix keyword can also be called using the infix notation (omitting the dot and the parentheses for the call). Infix functions must meet the following requirements:
//
//They must be member functions or extension functions.
//
//They must have a single parameter.
//
//The parameter must not accept variable number of arguments and must have no default value.


infix fun String.getAppendedBy(appendingString: String):String {
    return this + appendingString
}
//Infix function calls have lower precedence than arithmetic operators, type casts, and the rangeTo operator. The following expressions are equivalent:
//
//1 shl 2 + 3 is equivalent to 1 shl (2 + 3)
//
//0 until n * 2 is equivalent to 0 until (n * 2)
//
//xs union ys as Set<*> is equivalent to xs union (ys as Set<*>)
//
//On the other hand, an infix function call's precedence is higher than that of the boolean operators && and ||, is- and in-checks, and some other operators. These expressions are equivalent as well:
//
//a && b xor c is equivalent to a && (b xor c)
//
//a xor b in c is equivalent to (a xor b) in c

//scope of functions
//1. top level functions are define in files directly.
//2. we can also define functions locally as member functions and extension functions

//Kotlin supports a style of functional programming known as tail recursion. For some algorithms that would normally use loops, you can use a recursive function instead without the risk of stack overflow. When a function is marked with the tailrec modifier and meets the required formal conditions, the compiler optimizes out the recursion, leaving behind a fast and efficient loop based version instead:

val eps = 1E-10 // "good enough", could be 10^-15
tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

//This code calculates the fixpoint of cosine, which is a mathematical constant. It simply calls Math.cos repeatedly starting at 1.0 until the result no longer changes, yielding a result of 0.7390851332151611 for the specified eps precision. The resulting code is equivalent to this more traditional style:
//
//val eps = 1E-10 // "good enough", could be 10^-15
//
//private fun findFixPoint(): Double {
//    var x = 1.0
//    while (true) {
//        val y = Math.cos(x)
//        if (Math.abs(x - y) < eps) return x
//        x = Math.cos(x)
//    }
//}
//To be eligible for the tailrec modifier, a function must call itself as the last operation it performs. You cannot use tail recursion when there is more code after the recursive call, within try/catch/finally blocks, or on open functions. Currently, tail recursion is supported by Kotlin for the JVM and Kotlin/Native.

fun main(){
    val functionCreatedUsingLambda:()->Int = {
        println("hello")
        10
    }

    println(functionCreatedUsingLambda())       //10

    println(sumTheseNumbers(1,2,3,4))
    //or use spread operator
    println(sumTheseNumbers(*intArrayOf(1,3,6,6,9)))

    //extension function demonstration (getAppendedBy)
    var greetingsForCrowd = "Hello ladies!"
    greetingsForCrowd = greetingsForCrowd getAppendedBy "and gentlemen"
    println(greetingsForCrowd)
}