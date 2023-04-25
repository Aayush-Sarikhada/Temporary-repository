package com.example.kotlinpractice.delegations

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains examples for delegation in kotlin.
 */

//Ex:3
class CustomGetterAndSettersForString{
    operator fun getValue(thisRef: Any?, prop: KProperty<*>):String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, prop: KProperty<*>,value: String) {
        println("Value $value is assigned to property ${prop.name}")
    }
}

class ClassForDemoOfGetterSetterForString {
    var strWithGetterAndSetterDelegated:String by CustomGetterAndSettersForString()                          //this tells us to either initialize this  property or provide getter or                                                                                getter+setters but we can use delegation here as well
}

class DemoForDelegation{
    val strWithCustomGetter: String by object {
        operator fun getValue(thisRef: Any?,prop: KProperty<*>):String {
            return "this is a delegation value"
        }
    }

    val laziedValue:Int by lazy {
        println("lazy is called!")
        10
    }
}

fun main(){

    ClassForDemoOfGetterSetterForString().strWithGetterAndSetterDelegated = "hello"

    println(DemoForDelegation().laziedValue)

    //  If the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.
    val lazilyCreatedString: String by lazy {
        // under the hood it initializes the property using synchronized (default) way( there are three mods in which lazy can initialize a property ( sychronized, unsafe and safe)
        "hello brother"
    }
    var strDelegatedToVetoable: String by Delegates.vetoable("hello") { _, old, new->              //will change the value only if the returned true from lambda else it will ignore it.
        new.length > old.length
    }
    var strDelegatedToObservable: String by Delegates.observable("hello") { _, old, new->              //will change the value only if the returned true from lambda else it will ignore it.
        new.length > old.length
    }
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