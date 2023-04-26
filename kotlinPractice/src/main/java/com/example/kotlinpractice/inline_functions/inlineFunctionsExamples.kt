package com.example.kotlinpractice.inline_functions

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains example to see working of inline functions.
 */

inline fun printStringWithLambda(whatToPrint: String,function: (String)->Unit){
    println("start printing...")
    function(whatToPrint)
    println("end printing...")
}

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true    // returns from hasZeros
    }
    return false
}

fun main() {
    hasZeros(listOf(1,2,3,0))
}