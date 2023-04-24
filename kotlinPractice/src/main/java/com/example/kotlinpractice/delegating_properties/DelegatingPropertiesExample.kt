package com.example.kotlinpractice.delegating_properties

import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example for Delegating Properties.
 */

class MyLazy<T>(override val value: T) : Lazy<T> {
    override fun isInitialized(): Boolean = true

    operator fun getValue(thisRef:Any?,prop:KProperty<*>): T{
        return value
    }
}

class MyOberver<T>(val initialValue: T,val mAfterChange:(KProperty<*>,T,T)->Unit,val mBeforeChange:(KProperty<*>,T,T)->Boolean) : ObservableProperty<T>(initialValue) {
    private var value = initialValue


    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T)  = mAfterChange(property,oldValue,newValue)

    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        return mBeforeChange(property,oldValue,newValue)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if(beforeChange(property,this.value,value)){
            this.value = value
        }
    }
}

fun main(){
    var someVar:String by MyOberver<String>("init", mAfterChange = {_,old,new->
        println("$old -> $new")
    }, mBeforeChange = {prop,old,new->
        println("before change")
        old.length > new.length
    })

    println(someVar)
    someVar = "this is new"
    println(someVar)
}