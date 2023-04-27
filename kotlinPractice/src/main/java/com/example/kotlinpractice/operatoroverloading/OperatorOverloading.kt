package com.example.kotlinpractice.operatoroverloading

data class Point(val x: Int,val y: Int){
    operator fun unaryMinus() = Point(-x,-y)
    operator fun unaryPlus() = Point(+x,+y)
}

class Car(var objName: String) {
    // Overloading the function
    operator fun plus(data: Int) {
        objName = "Name is $objName and data is $data"
    }

    override fun toString(): String {
        return objName
    }
}

// Assignments are NOT expressions in Kotlin.
// === and !== (identity checks) are not overloadable, so no conventions exist for them.
// provideDelegate, getValue and setValue operator functions are described in Delegated properties.

fun main() {
    val point = Point(10,11)
    println(point.unaryMinus())
    println(point)

//    val obj = Object("obj")
//    println(obj + 10)                   //prints: "Name is obj and data is 10"
}

