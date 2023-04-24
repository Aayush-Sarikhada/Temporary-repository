package com.example.kotlinpractice.utils

object Utils{
    fun showDiff(obj:Any?,change:()->Unit){
        println("before: $obj")
        change()
        println("after: $obj")
    }
}