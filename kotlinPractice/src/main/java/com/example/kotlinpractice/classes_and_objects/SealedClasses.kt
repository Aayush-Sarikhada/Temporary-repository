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
sealed class Error {
    object MemoryError {
        var message: String = "Memory error occurred in OS"
    }
    class ThreadErrorsClass {
        var message: String = "Thread errors has occurred"
    }
}

fun main(){
    val memoryErrorAtRuntime = Error.MemoryError
    val memoryErrorAtCompileTime = Error.MemoryError

    println(memoryErrorAtRuntime.equals(memoryErrorAtCompileTime))
    println(memoryErrorAtRuntime === memoryErrorAtCompileTime)
    println(memoryErrorAtRuntime.message === memoryErrorAtCompileTime.message)

    println()

    val mainThreadError = Error.ThreadErrorsClass()
    val backGroundThreadError = Error.ThreadErrorsClass()
    println(mainThreadError.equals(backGroundThreadError))                       //different instances
    println(mainThreadError === backGroundThreadError)                           //not referring same instance in memory
    println(mainThreadError.message === backGroundThreadError.message)           //referred types are same
    println(mainThreadError.message == backGroundThreadError.message)            //referred strings values are same
}