package com.example.kotlinpractice.higher_order_functions


//val areaFunction:(xAxis:Int,yAxis:Int)->Int = {xAxis, yAxis ->
//    xAxis*yAxis
//}

//different ways to get instance of a function type
//1 lambda

val areaFunction = {a:Int,b:Int->
    a*b
}
//or
val areaFunction2:(a:Int,b:Int)->Int = {a,b -> a * b }

//2 anonymous functions
val areaFunction3 = fun(a:Int,b:Int):Int {
    
    return a*b
}

fun main(){
    println(areaFunction(10,11))
    listOf<Int>(1,2,3).filter {
        it>0
    }
}