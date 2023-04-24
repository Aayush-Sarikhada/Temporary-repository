package com.example.kotlinpractice

fun customGenerateSequence(start:Int,end:Int,inclusive:Boolean = true):List<Int>{
    if(start >end) return emptyList()
    val l = mutableListOf<Int>()
    for(i in start..if(inclusive)end else end-1){
        l.add(i)
    }
    return l.toList()
}

fun customGenerateSequence(size:Int,lambda:()->Int):List<Int>{
    val l = mutableListOf<Int>()
    repeat(size){
        l.add(lambda())
    }
    return l.toList()
}

fun main(){
    val listOfGeneratedInts = customGenerateSequence(1,10,false)
    println(listOfGeneratedInts)
}