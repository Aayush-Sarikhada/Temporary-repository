package com.example.kotlinpractice.classes_and_objects

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains examples and notes of inline class in kotlin.
 */

//purpose: Sometimes it is necessary for business logic to create a wrapper around some type. However, it introduces runtime overhead due to additional heap allocations. Moreover, if the wrapped type is primitive, the performance hit is terrible, because primitive types are usually heavily optimized by the runtime, while their wrappers don't get any special treatment.
//To solve such issues, Kotlin introduces a special kind of class called an inline class.

//NOTE: inline classes are a subset of "value-based classes".
//NOTE: inline classes don't have identity and can only hold values.

//@JVMInline is must for JVM backend
//"value" keyword is used for inline classes (inline keyword is deprecated)
//exactly one parameter is needed in primary constructor

@JvmInline
value class FirstInlineClass(private val s:String)

//NOTE: An inline class must have a single property initialized in the primary constructor. At runtime, instances of the inline class will be represented using this single property

@JvmInline
value class Password(private val s:String)
val securePassword = Password("Abcdefg")

//Inline classes can have properties, function and init block
//inline classes can NOT have backing fields. They can only have simple computable properties( no lateInit/delegated properties)

@JvmInline
value class Name(val s:String){
    init {
        require(s.isNotEmpty()){}                    //require(Boolean) throws IllegalArgumentException when its argument is false. Use it to test function arguments.
    }

    val length:Int
        get() = s.length

    fun greet(){
        println("Hello, $s")
    }
}

//inline classes are allowed to inherit from "interfaces"
//NOTE: It is forbidden for inline classes to participate in a class hierarchy. This means that inline classes cannot extend other classes and are always final.
interface Printable{
    fun prettyPrint():String
}
@JvmInline
value class Name2(val s:String):Printable{
    override fun prettyPrint(): String  = "Let's $s!"
}

//The Kotlin compiler will prefer using underlying types instead of wrappers to produce the most performant and optimized code. However, sometimes it is necessary to keep wrappers around. As a rule of thumb, inline classes are boxed whenever they are used as another type.

//NOTE: Because inline classes may be represented both as the underlying value and as a wrapper, referential equality is             pointless for them and is therefore prohibited.

//Inline classes can also have a generic type parameter as the underlying type. In this case, the compiler maps it to Any? or, generally, to the upper bound of the type parameter.
//@JvmInline
//value class UserId<T>(val value: T)
//
//fun compute(s: UserId<String>) {} // compiler generates fun compute-<hashcode>(s: Any?)
//Generic inline classes is an Experimental feature. It may be dropped or changed at any time. Opt-in is required with the -language-version 1.8 compiler option.


//MANGLING in kotlin for inline classes

interface I
@JvmInline
value class Foo(val i:Int): I

fun asInline(f:Foo){}
fun <T> asGeneric(x:T){}
fun asInterface(i:I){}
fun asNullable(i:Foo?){}
fun <T> id(x: T): T = x

//Mangling
//Since inline classes are compiled to their underlying type, it may lead to various obscure errors, for example unexpected platform signature clashes:
//
@JvmInline
value class UInt(val x: Int)

// Represented as 'public final void compute(int x)' on the JVM
fun compute(x: Int) { }

// Also represented as 'public final void compute(int x)' on the JVM!
fun compute(x: UInt) { }

//To mitigate such issues, functions using inline classes are mangled by adding some stable hashcode to the function name. Therefore, fun compute(x: UInt) will be represented as public final void compute-<hashcode>(int x), which solves the clash problem.

//NOTE:The mangling scheme has been changed in Kotlin 1.4.30. Use the -Xuse-14-inline-classes-mangling-scheme compiler flag to force the compiler to use the old 1.4.0 mangling scheme and preserve binary compatibility.


//calling from java code
//You can call functions that accept inline classes from Java code. To do so, you should manually disable mangling: add the @JvmName annotation before the function declaration:

//@JvmInline
//value

fun main(){
    println(securePassword)

    val name = Name("Kotlin")
    name.greet()
    println(name.length)

    val playName = Name2("Play")
    println(playName.prettyPrint()) // Still called as a static method

    val f = Foo(42)

    asInline(f)     //unboxed: used as Foo itself
    asGeneric(f)        //boxed: used as generic type T
    asInterface(f)      //boxed: used as type I
    asNullable(f)   //boxed: used as Foo?, which is different from Foo

    //below, 'f' first is boxed (while being passed to 'id' and then unboxed (when returned from 'id')
    //in the end, 'c' contains unboxed representation (just '42', as 'f'
    val c = id(f)
}