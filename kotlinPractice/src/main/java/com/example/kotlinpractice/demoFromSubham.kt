package com.example.kotlinpractice

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains code created by subham and is reviewed by aayush sarikhada to check for any errors.
 */

data class Mobile(val model: String, val price: Float)

interface StockRoom {
    fun getMobile(mobile: Mobile): Boolean
    fun updateInventory(packages: MutableMap<String, Int>)
}

interface Manufacturer {
    fun dispatchMobiles(): MutableMap<String, Int>
}

class WareHouse : StockRoom {
    private var mobileInventory: MutableMap<String, Int> = mutableMapOf("galaxy" to 1, "iphone" to 2)

    override fun getMobile(mobile: Mobile): Boolean {
            if (!isMobileAvailable(mobile)) {
                println("mobile is not available currently , will be in stock soon")
                return false
            }
        println ("customer is Buying mobile having model of ${mobile.model}")
        updateMobileCount (mobile)
        println("number of ${mobile} available ${mobileInventory.getValue(mobile.model)}")
        return true
        }
    private fun isMobileAvailable(mobile: Mobile): Boolean =
            mobileInventory.contains(mobile.model) && mobileInventory.getValue(mobile.model) > 0

    private fun updateMobileCount(
                mobile: Mobile
            ) {
                mobileInventory[mobile.model] = mobileInventory.getValue(mobile.model) - 1
            }
    override fun updateInventory(packages: MutableMap<String, Int>) {
                packages.forEach {
                    if (mobileInventory.contains(it.key))
                        mobileInventory[it.key] = mobileInventory.getValue(it.key) + it.value
                }
            }
}

class Portal(private val phoneWale: StockRoom, private val xiaomi: Manufacturer) :
    StockRoom by phoneWale, Manufacturer by xiaomi {
    fun customerBuysMobile(mobile: Mobile, customer: String) {
        println("Welcome $customer")
        if (getMobile(mobile))
            updateInventory(dispatchMobiles())          //put some condition before updating inventory. (e.g. if mobile count < some fixed number of phones
    }
}


class Xiaomi : Manufacturer {
    override fun dispatchMobiles(): MutableMap<String, Int> {
        return mutableMapOf("galaxy" to 10, "iphone" to 10)     //why xiomi is making galaxy and iphones?
    }
}



fun main() {
    val goDown = WareHouse()
    val flipkart = Portal(goDown, Xiaomi())
    val mobile = Mobile("galaxy", 56f)
    flipkart.customerBuysMobile(mobile, "Shubham")
    flipkart.customerBuysMobile(mobile,"Aayush")
}