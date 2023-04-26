package com.example.kotlinpractice.afterSecondKT

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023
This file contains practices i did after my SecondKT of kotlin language.
 */

interface Months {
    fun getDays(): Int
}
enum class FirstTwoMonths: Months {
    JAN {
        override fun getDays(): Int {
            return 31
        }},
    FAB {
        override fun getDays(): Int {
            return 29
        }}
}

@JvmInline
value class Password(private val pass: String) {
    init {
        println("init ran in inline class")
    }
    init {
        println("another init ran in inline class")
    }
}

fun main(){
    val arrayOne = Array(10){0}
    val arrayTwo = Array(10){0}
    println(arrayOne === arrayTwo)
    println(arrayOne.contentEquals(arrayTwo))

    val arrayListOne = arrayListOf(0)
    val arrayListTwo = arrayListOf(0)
    println(arrayListOne === arrayListTwo)
    println(arrayListOne == arrayListTwo)
}