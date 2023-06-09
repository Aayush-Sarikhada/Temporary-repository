package com.example.kotlinpractice.delegations

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
Created By: Aayush Sarikhada
Updated on: 27 apr 2023

This file contains examples for delegation in kotlin.
 */

//Ex:3
class SubmarineModelNumberDelegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "ABC10001"
    }
    operator fun setValue(thisRef: Any?, prop: KProperty<*>,value: String) {
        println("Value $value will be assigned to property ${prop.name}")
    }
}

class Submarine {
    var submarineModelNumber: String by SubmarineModelNumberDelegate()                          //  this tells us to either initialize this  property or provide getter or                                                                                                   getter+setters but we can use delegation here as well
}

fun main(){

    //  If the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.
    val morningGreeting: String by lazy {
        // under the hood it initializes the property using synchronized (default) way( there are three mods in which lazy can initialize a property ( sychronized, unsafe and safe)
        "hello good morning"
    }
    var planetName: String by Delegates.vetoable("earth") { _, old, new->              //will change the value only if the returned true from lambda else it will ignore it.
        new.length < old.length
    }
    var starName: String by Delegates.observable("sun") { _, old, new->
        println("change observed: $old -> $new")
    }

    planetName = "jupiter"
    starName = "dhruv"

    println(planetName)
    println(starName)
}

//NOTES from KOTLIN DOCS:

//With some common kinds of properties, even though you can implement them manually every time you need them, it is more helpful to implement them once, add them to a library, and reuse them later. For example:
//
//Lazy properties: the value is computed only on first access.
//
//Observable properties: listeners are notified about changes to this property.
//
//Storing properties in a map instead of a separate field for each property.
//
//To cover these (and other) cases, Kotlin supports delegated properties:

//The syntax is:
// val/var <property name>: <Type> by <expression>. The expression after by is a delegate, because the get() (and set()) that correspond to the property will be delegated to its getValue() and setValue() methods. Property delegates don't have to implement an interface, but they have to provide a getValue() function (and setValue() for vars).

//Standard Delegates:
//1. Lazy in kotlin
//working of LAZY
//lazy() is a function that takes a lambda and returns an instance of Lazy<T>, which can serve as a delegate for implementing a lazy property. The first call to get() executes the lambda passed to lazy() and remembers the result. Subsequent calls to get() simply return the remembered result.

//2. Delegates.Observable()
//syntax: take a initial value and a lambda that has three parameters ,prop, old, and new
//M.IMP: lambda is called everytime we assign something to var AFTER the assignment of new data.

//3. Delegates.Vetoable()
//The handler passed to vetoable will be called BEFORE the assignment of a new property value.