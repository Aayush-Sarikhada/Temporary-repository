package com.example.kotlinpractice.after_second_kt


/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains callback problem solution given by prembhai in reverse KT.
 */

//problem given in second KT (related to callbacks)
data class User(val firstName:String, val secondName:String) {
    val userName:String = "$firstName@$secondName"

}

class ApiService {
    fun getResponseWithDelay(userName:String, callBack:(String)->Unit) {
        if(userName == "Aayush@Sarikhada")
            callBack("AVAILABLE")
        else
            callBack("NOT-AVAILABLE")
    }

}
class Authenticator {
    inline fun isAuthenticate(userName: String, crossinline callBack:(String)->Unit) {
       ApiService().getResponseWithDelay(userName){
           callBack(it)
       }
    }
}
fun main() {

    var entryPermit = "NO-DATA"
    val firstUser = User("Aayush", "Sarikhada")
    Authenticator().isAuthenticate(userName = firstUser.userName) {
        entryPermit = it
    }


}