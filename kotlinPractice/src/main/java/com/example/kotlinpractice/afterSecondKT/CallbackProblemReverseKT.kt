package com.example.kotlinpractice.afterSecondKT

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023
This file contains callback problem solution given by prembhai in reverse KT.
*/

// problem given in second KT (related to callbacks)

//TODO: add enum for response
data class User(val firstName: String, val secondName: String) {
    val userName:String = "$firstName@$secondName"
}

class ApiService {
    fun getResponseWithDelay(userName: String, response: (String) -> Unit) {
        if(userName == "Aayush@Sarikhada")
            response("AVAILABLE")
        else
            response("NOT-AVAILABLE")
    }
}

class Authenticator {
    inline fun authenticate(userName: String, crossinline onResponse:(String)->Unit) {
       ApiService().getResponseWithDelay(userName){
           onResponse(it)
       }
    }
}

fun main() {
    var entryPermit = "NO-DATA"
    val user = User("Aayush", "Sarikhada")
    Authenticator().authenticate(userName = user.userName) {
        entryPermit = it
    }
    println(entryPermit)
}