package com.example.kotlinpractice.functions

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
interface TopLevelInterface {
    fun doTask(arg:TopLevelInterface): Int
}

interface FirstInterface: TopLevelInterface {
     fun doTask(arg:FirstInterface): Int {
        println("firstInterface")
        return 0
    }
}

interface SecondInterface: TopLevelInterface {
     fun doTask(arg:SecondInterface): Int {
        println("secondInterface")
        return 1
    }
}

//class BottomLevelClass: FirstInterface, SecondInterface {
//    //    override fun doTask(arg:TopLevelInterface): Int {
////        if (arg is FirstInterface){
////            return super<FirstInterface>.doTask(arg)
////        }
////        else {
////            return super<SecondInterface>.doTask(arg)
////        }
////        return -1
////    }
//
//}

class Temp{
    var a:Int = 10
}


fun main(){
//    var argToPass = object: FirstInterface{}
//    var blc = BottomLevelClass().doTask(argToPass)
//    print(blc)

    val someObject:Temp = Temp()
    val s:Int? = 10

    s?.let{
        it+12
    }
    print(s)

    someObject.also {  }
    println(someObject.a)

}





//
//interface TopLevelClass{
//    fun doSomething():Int{
//        println("TopLevel")
//        return 0
//    }
//}
//
//interface FirstInterface: TopLevelClass{
//
//
//    override fun doSomething():Int {
//        super.doSomething()
//        println("FirstInterface")
//        return 10
//    }
//}
//interface SecondInterface: TopLevelClass{
//    override fun doSomething():Int {
//        super.doSomething()
//        println("SecondInterface")
//        return 11
//    }
//}
//
//class BottomLevelClass: FirstInterface, SecondInterface {
//    override fun doSomething(): Int {
//        super<FirstInterface>.doSomething()
//        println("Bottom Level with firstInterface")
//        return 20
//    }
//
//    fun getName(s: Enums):Int{
//        if(s == Enums.FIRSTINTERFACE) {
//            return super<FirstInterface>.doSomething()
//        }
//        return super<SecondInterface>.doSomething()
//    }
//
//
//}
//
//enum class Enums{
//    FIRSTINTERFACE,SECONDINTERFACE
//}
//fun main(){
//    BottomLevelClass().getName(Enums.FIRSTINTERFACE)
//    fun BottomLevelClass.getName(s:Enums):Int{
//        return 10
//    }
//    BottomLevelClass().getName(Enums.SECONDINTERFACE)
//}