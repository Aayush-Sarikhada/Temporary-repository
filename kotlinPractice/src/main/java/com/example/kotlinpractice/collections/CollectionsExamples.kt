package com.example.kotlinpractice.collections

import com.example.kotlinpractice.utils.Utils
import kotlin.properties.Delegates

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains examples of collections Examples in kotlin.
 */

//object temp {
//    fun printName(){
//        println(this::class.simpleName)
//    }
//}

fun main(){

    val pair = "A" to "B"

    val mylist1 = mutableListOf(1,2,3,4,5,6)
    Utils.showDiff(mylist1){
        mylist1[3] = 25
    }
    Utils.showDiff(mylist1){
        mylist1.add(3,256)
    }

    //Read only collections are COVARIANT and Mutable collections are Not COVARIANT
    //Array in kotlin
    var normalArray = Array<Int>(2){0}          //immutable
    normalArray[0] = 10
    normalArray[1] = 11
    normalArray.plus(9)
    println(normalArray.size)   //size of array
    for (iterator in  normalArray.iterator()){
        print("$iterator ")
    }
//    for (iterator in  normalArray.indices){
//        print("$iterator ")
//    }

    var anotherNormalArray = arrayOf(1,2,3,4,5)  //another way to create fixed size mutable array

    var specialIntArray = intArrayOf(1,2,3,4,5,6)  //same as above but only for ints.
    var firstEvenIndex = specialIntArray.indexOfFirst {
        it%2 == 0
    }
    println(firstEvenIndex)


    //two types of collections 1. mutable and 2. immutable

    val numList1 = mutableListOf<Int>(10,20,30)
    numList1.shuffle()
    var numList2 = listOf<Int>(10,20,30)
    numList2.asReversed()
    var subListFromNumList1 = numList1.subList(1,3)
    numList1[2] = 50

    println(subListFromNumList1.toString())             //prints: 20, 50 even though we have different list here because the returned list is still backed by the original list
                                                        // so both the list will reflect each others changes as long as they are non structural changes( such as adding or removing element(which will change the size of the list))
    subListFromNumList1[0] = -1
    println(numList1.toString())                        //prints: 10 -1 50

    println("address of ${numList1}")
    println("address of $subListFromNumList1")
    var temp = numList2.dropLast(1)                 //some methods such ass droplast,elementAt etc are in _Collection( auto generated file) they are added there as                                                             extension functions
    println(temp)


    //ArrayList in kotlin
    //var arrayListOfNums = ArrayList               //kotlins arrayList class is just an typealis for java.util.ArrayList declared in kotlin.collection package
    val emptyArrayListOfNums = ArrayList<Int>()      //empty arraylist
    emptyArrayListOfNums.add(1)
    emptyArrayListOfNums.add(2)
    emptyArrayListOfNums.add(3)
    emptyArrayListOfNums.add(4)
    val arrayListOfNumsWithInitialCapacity = ArrayList<Int>(10)        //initial capacity given in constructor
    val arrayListOfNumsFromAnotherCollection = ArrayList<Int>(emptyArrayListOfNums)
    println(emptyArrayListOfNums)
    println(arrayListOfNumsFromAnotherCollection)
    println(arrayListOfNumsWithInitialCapacity)

    var arrayListWithString = arrayListOf<String>("Aayush","Atul","Aniket")

    println(arrayListWithString.size)
    println(arrayListWithString.ensureCapacity(10))


    //maps in kotlin
    var myNormalMap = mapOf<Int,String>(
        1 to "hello",
        2 to "hell",
        3 to "hel",
        4 to "he"
    )

    println(myNormalMap.getValue(2))
    println(myNormalMap.contains(6))
    println(myNormalMap.asIterable())
    println(myNormalMap.asSequence())
    var oneMoreNormalMap = myNormalMap.plus(Pair(5,"h"))            //we can't add to the original but we can create a new immutable map from old immutable map
    println(myNormalMap)
    println(oneMoreNormalMap)

    oneMoreNormalMap = myNormalMap.minus(5)

    println("hello" in "hello guys")



    var mySmallHashMap = HashMap<Int,String>(
        6
    )
    println(mySmallHashMap.size)
    mySmallHashMap.set(1,"Hello")
    mySmallHashMap.set(2,"ello")
    mySmallHashMap.set(3,"llo")
    mySmallHashMap.put(3,"oollo")
    mySmallHashMap.set(2,"different")
    mySmallHashMap.forEach {
        println("${it.key} is associated wit ${it.value}")
    }

    var anotherHashMap = hashMapOf(
        "first" to 1,
        "second" to 2,
        "third" to 3
    )
    anotherHashMap.replace("second",10)
    val numberOfKeysEndingWithd = anotherHashMap.count {
        it.key.endsWith("d")
    }
    println(numberOfKeysEndingWithd)

    anotherHashMap.replace("second",10,5)
    println(anotherHashMap)

    repeat(100){
        println(anotherHashMap)
    }//order doesn't change why??

    anotherHashMap.replaceAll{ _, i->
        i+100
    }
    println(anotherHashMap)

    var inti = anotherHashMap.getOrElse("fourth"){
        10
    }

    println(inti)
    anotherHashMap.count()
    anotherHashMap.entries.distinct()

    var myHashSet = hashSetOf<Int>(1,2,3,4)
    println(myHashSet.retainAll(listOf(2,4)))


    var listofNums = MutableList(4){
        it*2
    }
    println(listofNums)

    val anotherListOfNums = listofNums.toMutableList()
    println(listofNums)
    println(anotherListOfNums)

    listofNums[2] = 10
    println(listofNums)
    println(anotherListOfNums)

    val filteredListofNums = listofNums.filter {
        it % 2 == 0
    }
    println(filteredListofNums)
    println(listofNums)

    val mappedListOfNums = listofNums.map {
        it*120 - 98*it
    }
    println(mappedListOfNums)

    val listOfStrings = listOf("One","Two","Three")
    println(listOfStrings.associateWith {
        when(it){
            "One" -> 1
            "Two" -> 2
            "Three" -> 3
            else -> {"Fail"}
        }
    })

    var listOfPairs = listOf<Pair<Int,Int>>(Pair(1,2),Pair(1,2),Pair(1,2),Pair(1,2))
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))


    println(numberSets.associateBy(keySelector = {it}, valueTransform = {
        it.count()
    }))

    data class FullName (val firstName: String, val lastName: String)

    fun parseFullName(fullName: String): FullName {
        val nameParts = fullName.split(" ")
        if (nameParts.size == 2) {
            return FullName(nameParts[0], nameParts[1])
        } else throw Exception("Wrong name format")
    }
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })

    var pairOfChars = 'a' to 'A'
    println(pairOfChars)

    numberSets.filterIsInstance<String>().forEach{
        println(it)
    }
    val s:Int by Delegates.observable(initialValue = 10, onChange = { prop, old, new->


    })

    var (a,b) = 1 to 10
    mapOf(1 to 1,2 to 2)

}




