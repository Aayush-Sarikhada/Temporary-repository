package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains different examples to iterate over arrays.
 */

val normalArray = arrayOf(1,2,3,4,5)

fun main() {

    for(i in 0..normalArray.size-1){
        println(normalArray[i])
    }

    for(i in 0..normalArray.lastIndex){
        println(normalArray[i])
    }

    for(i in 0 until normalArray.size){
        println(normalArray[i])
    }

    for(i in normalArray.indices){
        println(normalArray[i])
    }

    for (elem in normalArray){
        print("$elem ")
    };println()

    normalArray.forEach {
        print("$it ")
    };println()

    for ((ind,ele) in normalArray.withIndex()){
        println("$ind: $ele")
    }
    println()

    normalArray.forEachIndexed { index, i ->
        println("$index -> $i")
    }


}
