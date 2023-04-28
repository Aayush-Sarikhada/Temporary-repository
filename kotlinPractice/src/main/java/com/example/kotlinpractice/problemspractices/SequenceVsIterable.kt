package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example to check difference between interable vs sequence.
 */

data class Person(val id: Int, val name String)

val personList = listOf(
    Person(1, "Eren"),
    Person(2, "Bertold"),
    Person(3, "Mikasa"),
    Person(4, "Armin"),
    Person(5, "Reiner")
)

fun main() {
    println(personList)

    //iterable
    val namesLongerThanFour = personList.filter {
        println("filter called for iterable")
        it.name.length > 4
    }.map {
        println("map called for iterable")
        it.name
    }
    println(namesLongerThanFour)

    //Sequence
    val namesLongerThanTwo = personList.asSequence().filter {
        println("filter called for sequence")
        it.name.length > 2
    }.map {
        println("map called for sequence")
        it.name
    }.toList()
    println(namesLongerThanTwo)
}