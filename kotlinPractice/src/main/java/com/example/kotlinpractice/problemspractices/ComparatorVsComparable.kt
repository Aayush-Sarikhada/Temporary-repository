package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example for different implementation of comparator and comparable interfaces.
 */

class Student(val id:Int,val name:String): Comparator<Student>{
    override fun compare(p0: Student?, p1: Student?): Int {
        if(p0 == null || p1 == null){
            throw IllegalArgumentException()
        }
        return if(p0.id == p1.id) 0
            else if(p0.id > p1.id) 1
                else -1
    }

}

class Employee(val id:Int,val name:String): Comparable<Employee>{
    override fun compareTo(other: Employee): Int {
        return if(this.id == other.id) return 0
            else if(this.id > other.id) return 1
             else return -1
    }
}

fun main() {
    val listOfUsers = listOf<Student>(
        Student(1,"Aayush"),
        Student(2,"atul"),
        Student(3,"Aniket")
    )
}