package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example to check difference between interable vs sequence.
 */

fun main() {
    val arrayInt:Array<Int> = Array(10){
       0
    }               //explicitly zero is initialized                //internally "Interger[]" type

    val intArray = IntArray(10)         //by default 0 is initialized           //internally "int[]" type
    arrayInt.forEach {
        print("$it ")
    };println()

    intArray.forEach {
        print("$it ")
    };println()



}