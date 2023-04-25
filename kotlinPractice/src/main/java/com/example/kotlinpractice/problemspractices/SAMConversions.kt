package com.example.kotlinpractice.problemspractices

//	                Java interface	    Kotlin interface

//Java method	    SAM conversion	    Object expression
//Kotlin method	    SAM constructor	    Object expression

fun interface ClickListener{
    fun click()
}

class Button{
    private lateinit var onClickList:ClickListener
    fun setOnClickListener(clickListener: ClickListener){
        onClickList = clickListener
    }


}

fun main() {
    val button = Button()
    button.setOnClickListener{
        println("damn")
    }

}