package com.example.kotlinpractice.problems_practices

fun main(){
    val firstNumber:Int? = 10
    val secondNumber:Int? = 20

    if(firstNumber != null){
        println(firstNumber)
    }

    if(secondNumber != null){
        println(secondNumber)       //works fine: (but i read in a blog that for "vars" smart cast does not apply
    }
}