package com.example.kotlinpractice

import kotlin.properties.Delegates


/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains all examples which were told by our mentor to try and learn.
 */

data class A(val a:Int)

class B{
    val a = 10
}

class ClassForUnitCheck{
    fun funForUnitCheck(){
        return Unit
    }
}

class ABC(){
    var someVar:String = "this is class ABC"
    fun printSomeVar(){
        println(someVar)
    }
}

//To check how lazy variables are initialized at runtime (check through break points)
class ClassToCheckLazyVar{
    val someLazyVar by lazy {
        25
    }
    var someNormalVariable = 10
    fun printhello(){
        println("hello")
    }
    fun someTempfun(){
        println(someLazyVar)
    }
}

//Extension functions
open class ToTestExtensionFunctions{
    protected var name:String = "Aayush"
    open fun updateName(s:String) = run { this.name = s }
}

class Temp: ToTestExtensionFunctions(){
    fun printName(){
        println("Hello $name")
    }
}
fun ToTestExtensionFunctions.printName(){
    println("Hello")
}


fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with explicit label")
}

class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()
    val age:Int = 0
    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)

    }
    constructor(name:String,parent:Person,age:Int): this(name){

    }
}

//to understand working and limits of inner class and normal nested class
class OuterLevelClass{
    private val a:Int = 10
    protected val b:Int = 11
    public val c:Int = 12

    infix operator fun plus(s:Int):Double{
        return 1.0+s
    }

    fun accessCheckForOuterClass(){
//        println("${aOfNestedClass::class.simpleName}  ->  $aOfNestedClass")
//        println("${bOfNestedClass::class.simpleName}  ->  $bOfNestedClass")
//        println("${cOfNestedClass::class.simpleName}  ->  $cOfNestedClass")
    }
    class NestedClass{
        private val aOfNestedClass:Int = 13
        protected val bOfNestedClass:Int = 14
        public val cOfNestedClass:Int = 15

        fun accessCheckNestedClass(){
            println("${aOfNestedClass::class.simpleName}  ->  $aOfNestedClass")
            println("${bOfNestedClass::class.simpleName}  ->  $bOfNestedClass")
            println("${cOfNestedClass::class.simpleName}  ->  $cOfNestedClass")
        }
    }


    inner class InnerClass{
        private val aOfInnerClass:Int = 13
        protected val bOfInnerClass:Int = 14
        public val cOfInnerClass:Int = 15

        fun accessCheckForInnerClass(){
            println("${aOfInnerClass::class.simpleName}  ->  $aOfInnerClass")
            println("${bOfInnerClass::class.simpleName}  ->  $bOfInnerClass")
            println("${cOfInnerClass::class.simpleName}  ->  $cOfInnerClass")
            println("${a::class.simpleName}  ->  $a")
            println("${b::class.simpleName}  ->  $b")
            println("${c::class.simpleName}  ->  $c")

        }
    }

}

//To understand that extension functions are resolved statically and their called objects are resolved dynamically.
open class Base { }

class Derived : Base() { }

open class BaseCaller {
    open fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunctionInfo()   // call the extension function
    }
}

class DerivedCaller: BaseCaller() {
    override fun Base.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}


//creating extension function for operator overloads
operator fun Int.plus(t:Int):String{
    return "$t is int"
}

fun main() {

    val sequence = generateSequence(1) {
        if(it>11) return@generateSequence null
        it+1
    }

    sequence.forEach {
        print("$it ")
    }

    val abcd:Int by Delegates.vetoable(11){ _, n, y->
        return@vetoable n < y
    }
    println(abcd)
    println(OuterLevelClass() plus 190)

    val someIntToTestTryExpressions:Int = try{
        var d = 2/0
        d
    }catch (e:ArithmeticException){
       10
    }catch(e:Exception){
        11
    }finally {
        12
    }
    println(someIntToTestTryExpressions)

    val classToCheckLazyVar = ClassToCheckLazyVar()
    classToCheckLazyVar.printhello()
    classToCheckLazyVar.printhello()
    classToCheckLazyVar.printhello()
    println(classToCheckLazyVar.someNormalVariable)
    println(classToCheckLazyVar.someLazyVar)

    val a = A(10)
    val b = A(10)
    val c = A(10)

    val set = mutableSetOf(a, b, c)
    set.forEach {
        println("this -> $it")
    }

    //
    val d:B? = B()
    if (d != null){
        println(d.a)
    }

    val abc:ABC? = ABC()
    //    abc.let {         //here it:ABC?
    //
    //    }

            abc?.let {
                it.someVar
            }.let {

//                for(i in 1.4F..2.0F step 0.1){
//
//                }
            }


    val text = """
    Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)


    fun outerFuncForLambda(lambda:()->Int):Int{
        return lambda()
    }


    println(outerFuncForLambda {
        1+2
    })

}



