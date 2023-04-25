package com.example.kotlinpractice.delegatingproperties

import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains example for Delegating Properties.
 */

class CustomImplOfLazyClass<T>(override val value: T) : Lazy<T> {
    override fun isInitialized() = true

    operator fun getValue(thisRef:Any?,prop:KProperty<*>): T {
        return value
    }
}

class CustomImplOfObservableProperty<T>(private val initialValue: T,
                                        val mAfterChange:(KProperty<*>, T, T)->Unit,
                                        val mBeforeChange:(KProperty<*>, T, T)->Boolean): ObservableProperty<T>(initialValue) {
    private var value = initialValue

    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T)  = mAfterChange(property, oldValue, newValue)

    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        return mBeforeChange(property, oldValue, newValue)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>):T {
        return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if(beforeChange(property, this.value, value)){
            this.value = value
        }
    }
}

fun main(){
    var observableStrObject:String by CustomImplOfObservableProperty("init", mAfterChange = { _, old, new->
        println("$old -> $new")
    }, mBeforeChange = {prop,old,new->
        println("before change")
        old.length < new.length
    })

    println(observableStrObject)    //init
    observableStrObject = "this is new"
    println(observableStrObject)    //this is new

}