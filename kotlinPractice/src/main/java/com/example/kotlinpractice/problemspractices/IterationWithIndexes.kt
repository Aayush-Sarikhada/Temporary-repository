package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains different examples to iterate over arrays.
 */

val numberArray = arrayOf(1,2,3,4,5)

fun main() {

    for(i in 0..numberArray.size-1) {
        print("${ numberArray[i] } ")           //prints: 1 2 3 4 5
    };println()

    for(i in 0..numberArray.lastIndex) {
        print("${ numberArray[i] } ")
    };println()

    for(i in 0 until numberArray.size) {
        print("${ numberArray[i] } ")
    };println()

    for(i in numberArray.indices) {
        print("${ numberArray[i] } ")
    };println()

    for (elem in numberArray) {
        print("$elem ")
    };println()

    numberArray.forEach {
        print("$it ")
    };println()

    for ((ind,ele) in numberArray.withIndex()) {            /* 0: 1
                                                               1: 2
                                                               2: 3
                                                               3: 4
                                                               4: 5 */
        println("$ind: $ele")
    }
    println()

    numberArray.forEachIndexed { index, i ->                /* 0 -> 1
                                                               1 -> 2
                                                               2 -> 3
                                                               3 -> 4
                                                               4 -> 5 */
        println("$index -> $i")
    }
}
