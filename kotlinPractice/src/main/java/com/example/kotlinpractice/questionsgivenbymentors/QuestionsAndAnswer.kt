package com.example.kotlinpractice.questionsgivenbymentors

interface InterfaceWithNestedClass{
    class FirstNestedClass{
        fun printName(){
            println("first nested class")
        }
    }
    fun methodInWhichWeWillUseFirstNestedClass()
}

class ClassThatImplementsInterfaceWithNestedClass{
    fun deo(){
        InterfaceWithNestedClass.FirstNestedClass()
    }
}

class TempClassToUseInQuestionAndAnswerClass(){
    var d:Int = 10
}

  class QuestionsAndAnswer {
    var c:TempClassToUseInQuestionAndAnswerClass? = null
    val a = {i:Int, b:Int->
        println(i)
    }
}

data class DemoDataClass(val someValue:Int){
    val anotherValue:Int = 10

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        var result = someValue
        result = 31 * result + anotherValue
        return result
    }
}

val m = mutableMapOf<String,Int>(
    "Hello" to 1,
    "Hell" to 2,
    "Hel" to 3
)

val l = mutableListOf(1,2,34)

interface ForExtension{
    fun tempForEnum()
}

abstract class AbstractClassForExtension{
    abstract fun ForExtension.newMethod()
}

enum class TempForTesting: ForExtension {
    START{
        override fun tempForEnum() {
            println("from start")
        }
         },
    END{
        override fun tempForEnum() {
            println("from end")
        }
         };

    //ok
//    override fun tempForEnum() {
//            println("tempforenum from overriden")
//    }
}


class MyTempClass{
    fun printNameGreet(){
        println("Hello mytempclass")
    }
}

fun MyTempClass.printAnothernameGree(){
    println("hello from another name greet")
}

val v23:String.(Int)->Unit = {
    println("hll")
}
fun (String.(Int)->Unit).anotherFun(){
    println("AnotherFun")
}

data class MYDATA( var numOfLines:Int)

fun main(){



    v23.anotherFun()

    val mtc = MyTempClass()
    val tempFun:MyTempClass.()->Unit = {
        println("hello from one more greet function")
    }
    mtc.run {

    }
    run {
        println("Run")
    }

    val range = 1 until 20 step 2
    val temp22:Int? = null
    println(m.getOrDefault("Heo",10))

    val minusedL = l.minus(34)
    println(minusedL)
    println(l)
    val s = mutableSetOf<Int>(1,2,3,4,4)
    println(s)
    val s2 = temp22 ?: return

    val firstList = listOf(1,2,3,4)
    val secondList = listOf(10,20)

    val zippedList = firstList zip secondList
    println(zippedList)

    QuestionsAndAnswer().a(19,18)
    println(QuestionsAndAnswer().c?.d)

    val demo = DemoDataClass(10)
    val anotherDemo = DemoDataClass(11)
    println(demo == anotherDemo)
    val a:Int? = null
    println(a)
    val abc = {i:Int->
        println("Hello")
    }

    val c1 = DemoDataClass(10).component1()

}