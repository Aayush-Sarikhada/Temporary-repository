package com.example.kotlinpractice.objectexpressionsandobjectdeclarations

//object declaration example
object God {
    fun takeBlessings() {
        println("getting god's blessings")
    }
}

interface MouseEvenHandler {
    fun onLeftButtonClicked()
    fun onRightButtonClicked()
}

fun main() {
    val allah = God
    val christ = God
    print(allah === christ)

    //object expression example
    val mouseEvenHandler = object: MouseEvenHandler {
        override fun onLeftButtonClicked() {
            println("left button clicked")
        }

        override fun onRightButtonClicked() {
            println("right button clicked")
        }
    }
    mouseEvenHandler.onRightButtonClicked()
    mouseEvenHandler.onLeftButtonClicked()
}