package com.example.kotlinpractice.objectexpressionsandobjectdeclarations


class C {
    private  fun getObject() = object {
        val xString: String = "x"
    }
    fun printX() {
        println(getObject().xString)
    }
}

//object declarations
//normal data class
data class Car(val name:String,val numOfWheels:Int)

object Bmw {
    val name:String = "Car"
    override fun toString(): String {
        return "BMW car"
    }

}

fun main() {
    C().printX()

    println(Bmw)
}