package com.example.kotlinpractice.problemspractices

fun main(){
    val listOfNumbers = listOf<Int>(1,4,3,6,-1,600,600)
    println(listOfNumbers.sortedDescending())
    println(listOfNumbers.sorted())
    println(listOfNumbers.toSortedSet())
    println(listOfNumbers.sortedBy {
        it.toString()
    })

    println(listOfNumbers.indexOfFirst { it>100 })
    println(listOfNumbers.indexOfLast { it>100 })

}