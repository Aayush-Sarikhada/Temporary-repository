package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains different examples to iterate over arrays.
 */

val numbers = arrayOf(1,2,3,4,5)

fun main() {

    for(i in 0..numbers.size-1) {
        print("${ numbers[i] } ")           //prints: 1 2 3 4 5
    };println()

    for(i in 0..numbers.lastIndex) {
        print("${ numbers[i] } ")
    };println()

    for(i in 0 until numbers.size) {
        print("${ numbers[i] } ")
    };println()

    for(i in numbers.indices) {
        print("${ numbers[i] } ")
    };println()

    for (elem in numbers) {
        print("$elem ")
    };println()

    numbers.forEach {
        print("$it ")
    };println()

    for ((ind,ele) in numbers.withIndex()) {            /* 0: 1
                                                               1: 2
                                                               2: 3
                                                               3: 4
                                                               4: 5 */
        println("$ind: $ele")
    }
    println()

    numbers.forEachIndexed { index, i ->                /* 0 -> 1
                                                               1 -> 2
                                                               2 -> 3
                                                               3 -> 4
                                                               4 -> 5 */
        println("$index -> $i")
    }
}
