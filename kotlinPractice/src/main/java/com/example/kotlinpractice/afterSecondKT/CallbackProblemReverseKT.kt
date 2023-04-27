package com.example.kotlinpractice.afterSecondKT

/*
Created By: Aayush Sarikhada
Updated on: 27 apr 2023

This file contains callback problem solution given by prembhai in reverse KT.
*/

// problem given in second KT (related to callbacks)

//TODO: add enum for response
enum class Response{
    AVAILABLE,
    NOT_AVAILABLE,
    NO_DATA
}
data class User(val firstName: String, val secondName: String) {
    val userName:String = "$firstName@$secondName"
}

class ApiService {
    fun getResponseWithDelay(userName: String, response: (Response) -> Unit) {
        if(userName == "Aayush@Sarikhada")
            response(Response.AVAILABLE)
        else
            response(Response.NOT_AVAILABLE)
    }
}

class Authenticator {
    inline fun authenticate(userName: String, crossinline onResponse:(Response)->Unit) {
       ApiService().getResponseWithDelay(userName){
           onResponse(it)
       }
    }
}

fun main() {
    var entryPermit = Response.NO_DATA
    val user = User("Aayush", "Sarikhada")
    Authenticator().authenticate(userName = user.userName) {
        entryPermit = it
    }
    println(entryPermit)
}