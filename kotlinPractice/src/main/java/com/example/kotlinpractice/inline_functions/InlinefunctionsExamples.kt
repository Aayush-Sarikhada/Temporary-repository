package com.example.kotlinpractice.inline_functions

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example to see working of inline functions.
 */

inline fun printThis(whatToPrint:String,function:(String)->Unit){
    println("Hello im gonna start printing...")
    function(whatToPrint)
    println("Hello im gonna end printing...")
}

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true // returns from hasZeros
    }

    return false
}

fun main() {
    hasZeros(listOf(1,2,3,0))
}