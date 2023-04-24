package com.example.kotlinpractice.classes_and_objects

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains notes and examples of Sealed Classes.
 */

//sealed classes conform to restricted or bounded class hierarchies

//their constructors are protected by default and can be made private but not public.

//Sealed classes ensure type safety by restricting the types to be matched at compile-time rather than at runtime.

//A sealed class is implicitly abstract and hence it cannot be instantiated.

//Note: All the subclasses of the sealed class must be defined within the same Kotlin file.
// However, it not necessary to define them within the sealed class, they can be defined in any scope where the sealed class is visible.

//Direct subclasses of sealed classes and interfaces must be declared in the same package. They may be top-level or nested inside any number of other named classes, named interfaces, or named objects. Subclasses can have any visibility as long as they are compatible with normal inheritance rules in Kotlin.

//The same works for sealed interfaces and their implementations: once a module with a sealed interface is compiled, no new implementations can appear.

//In some sense, sealed classes are similar to enum classes: the set of values for an enum type is also restricted, but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have multiple instances, each with its own state.

//Constructors of sealed classes can have one of two visibilities: protected (by default) or private:
sealed class SomeEnum{
    object SomeObjectInSomeEnum{
        var s:String = "hello"
    }
    class SomeClassInSomeEnum{
        var s:String = "brother"
    }
}

fun main(){
    val s1 = SomeEnum.SomeObjectInSomeEnum
    val s2 = SomeEnum.SomeObjectInSomeEnum
    println(s1.equals(s2))
    println(s1 === s2)
    println(s1.s === s2.s)

    println()

    val s3 = SomeEnum.SomeClassInSomeEnum()
    val s4 = SomeEnum.SomeClassInSomeEnum()
    println(s3.equals(s4))          //different instances
    println(s3 === s4)              //not referring same instance in memory
    println(s3.s === s4.s)           //referred types are same
    println(s3.s == s4.s)           //referred strings values are same
}