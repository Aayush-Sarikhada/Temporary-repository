package com.example.kotlinpractice.problems_practices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example to check difference between interable vs sequence.
 */

data class Person(val id:Int,val name:String)

val list1 = listOf(
    Person(1,"Eren"),
    Person(2,"Bertold"),
    Person(3,"Mikasa"),
    Person(4,"Armin"),
    Person(5,"Reiner")
)

fun main() {
    println(list1)

    //interable
    val names = list1.filter {
        it.name.length > 4
    }.map {
        it.name
    }
    println(names)

    val names2 = list1.asSequence().filter {
        it.name.length >4
    }.map {
        it.name
    }.toList()
    println(names2)

    generateSequence(1) { n -> n * 2 }
        .take(20)
        .forEach(::println)

}