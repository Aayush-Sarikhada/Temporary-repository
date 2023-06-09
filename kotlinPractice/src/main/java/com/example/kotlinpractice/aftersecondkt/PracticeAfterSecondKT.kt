package com.example.kotlinpractice.aftersecondkt

/*
Created By: Aayush Sarikhada
Updated on: 27 apr 2023

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

fun main() {
    val teamAScore = Array(10){ 0 }
    val teamBScore = Array(10){ 0 }
    println(teamAScore === teamBScore)
    println(teamAScore.contentEquals(teamBScore))

    val arrayListOne = arrayListOf(0)
    val arrayListTwo = arrayListOf(0)
    println(arrayListOne === arrayListTwo)
    println(arrayListOne == arrayListTwo)
}