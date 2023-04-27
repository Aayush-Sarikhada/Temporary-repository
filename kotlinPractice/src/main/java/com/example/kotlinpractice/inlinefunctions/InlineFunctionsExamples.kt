package com.example.kotlinpractice.inlinefunctions

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains example to see working of inline functions.
 */

inline fun printStringUsingLambda(stringToBePrinted: String,  printingFunction: (String)->Unit) {
    println("start printing...")
    printingFunction(stringToBePrinted)                       //after compiling the code of lambda function is inlined here
    println("end printing...")
}

inline fun inlineFunction(crossinline crossInlinedFunction: () -> Unit, nonCrossInlinedFunction: () -> Unit) {
    crossInlinedFunction()
    nonCrossInlinedFunction()
    print("code inside inline function")
}

inline fun inlineFunctionExample(myFun: () -> Unit, noinline nxtFun: () -> Unit  ) {
    myFun()
    nxtFun()
    println("code inside inline function")
}

fun main() {
    printStringUsingLambda("Hello") {        //this functions code will be inlined here after compile
        println("$it world!")                                      //prints: "Hello world"
    }

    inlineFunction({ println("calling inline functions")
//        return                                        // compile time error (Because of `crossinline` keyword)
    },{ println("next parameter in inline functions")})

    inlineFunctionExample(
        { println("calling inline functions") },
        { println("next parameter in inline functions") }
    )
    println("main function ends here")
}