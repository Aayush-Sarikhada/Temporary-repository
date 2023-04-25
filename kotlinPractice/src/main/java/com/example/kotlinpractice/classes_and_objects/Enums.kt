package com.example.kotlinpractice.classes_and_objects

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains examples of enums in kotlin.
 */

interface WeekDays{
    fun shortName():String
}

enum class Days(val nameInLowerCase: String):WeekDays {

    MONDAY("monday") {
        override fun shortName():String {
            return "mon"
        }
    },
    TUESDAY("tuesday") {
        override fun shortName():String {
            return "tue"
        }
    },
    WEDNESDAY("wednesday") {
        override fun shortName():String {
            return "wed"
        }
    },
    THURSDAY("thursday") {
        override fun shortName():String {
            return "thur"
        }
    },
    FRIDAY("friday") {
        override fun shortName():String {
            return "fri"
        }
    },
    SATURDAY("saturday") {
        override fun shortName():String {
            return "sat"
        }
    },SUNDAY("sunday") {
        override fun shortName():String {
            return "sun"
        }
    };
    init {
        println("init is called")
    }
}

fun main(){
    val firstDayOfTheWeek = Days.MONDAY
    println(firstDayOfTheWeek.nameInLowerCase)
    println(firstDayOfTheWeek.shortName())
}