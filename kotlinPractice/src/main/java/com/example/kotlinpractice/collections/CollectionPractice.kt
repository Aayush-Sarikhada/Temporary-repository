package com.example.kotlinpractice.collections

import java.util.LinkedList
import kotlin.random.Random
/*
Created By: Aayush Sarikhada
Updated on: 25 apr 2023

This file contains notes and examples of collections in kotlin
types of collections : list, map and set
 */


fun main() {
    //list
    //mutable
    val numbers = mutableListOf(11, 12, 13)
    numbers.add(14)
    println(numbers)    //prints: 11 12 13

    //immutable
    val namesOfFriends = listOf("Ajay,Mehsur,Rick")
    println(namesOfFriends)     //prints: Ajay Mehsur Rick
    //set
    //immutable
    val immutableSetOfNumbers = setOf(1, 2, 3, 4, 6, 66, 6, 6, 6)
    println(immutableSetOfNumbers)      //prints: 1 2 3 4 6 66          //insertion order is preserved

    //mutable
    val mutableSetOfNumbers = mutableSetOf(1, 2, 3, 4, 5)
    println(mutableSetOfNumbers)        //prints: 1 2 3 4 5
    mutableSetOfNumbers.add(35)
    println(mutableSetOfNumbers)        //prints: 1 2 3 4 5 35

    //map
    //immutable
    val mapOfNumbersToTheirStringNames = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four"
    )
    println("All keys: ${mapOfNumbersToTheirStringNames.keys}")
    println("All values: ${mapOfNumbersToTheirStringNames.values}")

    //mutable
    val mapOfCountryToTheirCapital = mutableMapOf(
        "India" to "delhi",
        "USA" to "Washington DC",
        "UK" to "London",
        "Canada" to "Ottawa"
    )
    mapOfCountryToTheirCapital["South Korea"] = "Seoul"
    println(mapOfCountryToTheirCapital)      //prints: {India=delhi, USA=Washington DC, UK=London, Canada=Ottawa, South Korea=Seoul}

    //construct of collections
    //used functions to collections above

    //using builder
    val mapOfAlphabetToPosition = buildMap {
        put("a", 1)
        put("b", 2)
        put("c", 3)
    }
    println(mapOfAlphabetToPosition)    //prints: {a=1, b=2, c=3}

    val emptyMap = emptyMap<String, String>()
    val listOfDoubledValues = List(3) { it * 2 }    // or MutableList(){}
    println(listOfDoubledValues)        // prints:   [0, 2, 4]

    val linkedListImplOfDoubledValuesList = LinkedList<Int>(listOfDoubledValues)
    println(linkedListImplOfDoubledValuesList)  // prints: [0, 2, 4]
    val setWithInitialSize = HashSet<Int>(32)

    //Iterators
    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext())
        print("${numbersIterator.next()} ")         // prints: 11 12 13

    println()

    while (numbersIterator.hasNext()) {
        println("this won't be printed!")
        println(numbersIterator.next())
    }

    for (item in numbers)
        print("$item ")         // prints: 11 12 13

    println()

    numbers.forEach {
        print("$it ")           //prints: 11 12 13
    }

    println()

    val listIteratorOfNumbers = numbers.listIterator()
    while (listIteratorOfNumbers.hasNext()) {
        print(listIteratorOfNumbers.next())     //prints: 111213
    }

    println()

    while (listIteratorOfNumbers.hasPrevious()) {
        print("${listIteratorOfNumbers.previous()} ")       //prints: 14 13 12 11
    }

    println()

    //mutable iterators
    val listOfNumbersForMutableIteratorDemo = mutableListOf(100, 200, 300, 400, 500)
    val mutableIterator = listOfNumbersForMutableIteratorDemo.listIterator()

    println("before: $listOfNumbersForMutableIteratorDemo")         //prints: "before: [100, 200, 300, 400, 500]"
    mutableIterator.next()
    mutableIterator.remove()
    println("after removal $listOfNumbersForMutableIteratorDemo")   //prints: "after: [200, 300, 400, 500]"

    mutableIterator.add(600)
    println("after adding $listOfNumbersForMutableIteratorDemo")    //prints: "after adding [600, 200, 300, 400, 500]"

    mutableIterator.next()
    mutableIterator.set(900)
    println("after updating $listOfNumbersForMutableIteratorDemo")  //prints: "after updating [600, 900, 300, 400, 500]"

    //Ranges and Progressions
    val rangeFromOneToTwelve = 1..12
    for(i in rangeFromOneToTwelve) {
        print("$i ")            //prints: 1 2 3 4 5 6 7 8 9 10 11 12
    }

    println()

    for(i in 4 downTo 1)
        print("$i ")            //prints: 4 3 2 1

    println()

    for(i in 1..100 step 10) print("$i ")
    println()

    for(i in 10 downTo 1 step 2) print("$i ")
    println()

    //Sequence
    //Constructing Sequences

    //from elements
    val numberSequence = sequenceOf("Four","Three", "Two", "One")

    //from iterable
    val numberSequenceFromNumbersList = numbers.asSequence()

    //from a function
    //creates infinite sequence but lazily
    val oddNumbers = generateSequence(1){it+2}
    println(oddNumbers.take(5).toList())

    //to create finite return null
    val oddNumbersLessThan10 = generateSequence(1) { if(it<8) it+2 else null  }
    println(oddNumbersLessThan10)

    //from chunks
    val oddNumbersFromChunks = sequence {
        yield(1)
        yieldAll(listOf(3,5))
        yieldAll(generateSequence(7){it+2})
    }
    println(oddNumbersFromChunks.take(5).toList())


    //extension functions
    //1. Transformations
    //2. Filtering
    //3. Plus and Minus
    //4. Grouping
    //5. Retrieving collection parts
    //6. Retrieving single elements
    //7. Ordering
    //8. Aggregate operations
    //doesn't change the original collection

    //filter extension function
    var numberFromOneToFiveAsStrings = listOf("One","Two","Three","Four","Five")
    numberFromOneToFiveAsStrings.filter{
        it.length > 3
    }
    println("numbers are still $numberFromOneToFiveAsStrings")
    val longerThan3 = numberFromOneToFiveAsStrings.filter {
        it.length > 3
    }
    println("Numbers longer than 3 chars are $longerThan3")

    //Operations with destinations (they have "To" postfix)
    val filteredResults = mutableListOf<String>()       //destination
    numberFromOneToFiveAsStrings.filterTo(filteredResults){
        it.length > 3
    }
    //they append the result so above and below both are stored in destination here
    numberFromOneToFiveAsStrings.filterIndexedTo(filteredResults){index,_->
        index == 0
    }
    println(filteredResults)

    val result = numberFromOneToFiveAsStrings.mapTo(HashSet()){
        it.length
    }
    println("distinct item length are $result")

    //sort and sorted
    val sortedNumbers = numberFromOneToFiveAsStrings.sorted()
    println(numberFromOneToFiveAsStrings == sortedNumbers)
    numberFromOneToFiveAsStrings = numberFromOneToFiveAsStrings.toMutableList()
    numberFromOneToFiveAsStrings.sort()
    println(numberFromOneToFiveAsStrings == sortedNumbers)


    //Collection transformation operations
    //1. Mapping transformation
    val setOfNumbersToBeUsedInTransformations = setOf(1,2,3,4,5,6,7)
    println(setOfNumbersToBeUsedInTransformations.map{it*4})
    println(setOfNumbersToBeUsedInTransformations.mapIndexed{ ind, i->
        ind*i
    })

    println(setOfNumbersToBeUsedInTransformations.mapNotNull {
        if(it == 2) null else it*4
    })
    println(setOfNumbersToBeUsedInTransformations.mapIndexedNotNull{ ind, i->
        if(ind == 0) null else i
    })

    //mapping maps
    val numbersMap = mapOf(
        "key1" to 1,
        "key2" to 2,
        "key3" to 3
    )
    println(numbersMap.mapKeys {
        it.key.uppercase()
    })
    println(numbersMap.mapValues {
        it.value + it.key.length
    })

    //zipping transformation function
    val colors = listOf("red","brown","grey")
    val animals = listOf("fox","bear","wolf")
    println(colors zip animals)

    val twoAnimals = listOf("Fox","Bear")
    println(colors.zip(twoAnimals))

    println(colors.zip(animals){color,animal->
        "The ${animal.replaceFirstChar { it.uppercase() }} is $color"
    })

    val numberPairs = listOf("one" to 1,"two" to 2, "three" to 3)
    println(numberPairs.unzip())

    //Association transformations
    //associateWith()
    println(numberFromOneToFiveAsStrings.associateWith { it.length })

    //associateBy()
    println(numberFromOneToFiveAsStrings.associateBy { it.first().uppercaseChar() })
    println(numberFromOneToFiveAsStrings.associateBy(keySelector = {
        it.first().uppercaseChar()
    },
    valueTransform = {
        it.length
    }
        ))


    //Flattening transformation
    val numbersSet = listOf(setOf(1,2,3,4), setOf(4,5,6,7),setOf(1,2))
    println(numbersSet.flatten())

    data class StringContainer(val values: List<String>)


    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap {
        it.values })

    println(numberFromOneToFiveAsStrings.joinToString(separator = " - ", prefix = "Start: ", postfix = " :End"))
    println(numberFromOneToFiveAsStrings.joinToString(limit = 3, truncated = "<...>"))


    //2. Filtering
    val animalNames = listOf("Tiger","lion","elephant","leopard")
    val longerThan3AnimalNames = animalNames.filter{
        it.length >3
    }
    println(longerThan3AnimalNames)

    val filteredIndexed = numberFromOneToFiveAsStrings.filterIndexed{ind,i->
        (ind != 0) && (i.length < 5)
    }
    val filteredNot = mapOfNumbersToTheirStringNames.filterNot{
        it.key <= 3
    }
    println(filteredIndexed)
    println(filteredNot)

    val numbersInDifferentTypes = listOf(null,1,"two",3.0,"four",null)
    println("All String elements in upper case: ")
    numbersInDifferentTypes.filterIsInstance<String>().forEach {
        println(it.uppercase())
    }

    val listOfNumbersInStringWithNulls = listOf(null,"one","two","three",null)
    listOfNumbersInStringWithNulls.filterNotNull().forEach {
        println(it.length)
    }

    val studentsNames = listOf("Aniket","Aayush","Atul","Rahul","Divyang")
    val (studsWithNameStartA,rest) = studentsNames.partition { it.first().uppercaseChar() == 'A' }
    println("Students whose names start with 'A': $studsWithNameStartA")
    println("rest of the students: $rest")

    //Test predicates : any(), none() and all()

    println(studentsNames.any { it.endsWith("h") })
    println(studentsNames.none { it.endsWith("h") })
    println(studentsNames.all{it.endsWith("h")})

    //any() and none() can also be used to check the collection emptiness.
    val someEmptyCollection = emptyList<String>()
    println(someEmptyCollection.any())
    println(someEmptyCollection.none())

    //3. plus and minus operators
    val animalNamesListWithPlus = animalNames + "Monkey"
    val animalNamesListWithMinus = animalNames - "Tiger"
    println(animalNamesListWithPlus)
    println(animalNamesListWithMinus)


    //4. Grouping
    //using groupBy()
    val listOfBooks = listOf("Atomic habits","Harry potter pt1","Harry potter pt2", "12 rules for life")
    println(listOfBooks.groupBy { it.first().uppercase() })
    println(listOfBooks.groupBy(keySelector = {
        it.first()
    }, valueTransform = {
        it.uppercase()
    }))

    //groupingBy() and eachCount(),fold(),reduce() and aggregate()

    println(listOfBooks.groupingBy {
        it.first()
    }.eachCount())


    //5. Retrieving collection parts
    //slice()
    val numbersFrom1to100 = (1..100).toList()
    println(numbersFrom1to100)
    println(numbersFrom1to100.slice(1..10))
    println(numbersFrom1to100.slice(0..40 step 4))
    println(numbersFrom1to100.slice(setOf(3,5,0)))

    //take and drop
    println(numbersFrom1to100.take(10))
    println(numbersFrom1to100.takeLast(10))
    println(numbersFrom1to100.drop(10))
    println(numbersFrom1to100.dropLast(10))

    println(numbersFrom1to100.takeWhile {
        it<10
    })
    println(numbersFrom1to100.takeLastWhile {
        it<10
    })
    println(numbersFrom1to100.dropWhile {
        it<50
    })
    println(numbersFrom1to100.dropLastWhile {
        it>50
    })

    //chunked
    println(numbersFrom1to100.chunked(10))
    numbersFrom1to100.chunked(10).forEach {
        println(it.average())
    }
    println(numbersFrom1to100.chunked(10){
        it.average()
    })
    println("direct avg: ${numbersFrom1to100.average()}")
    println("indirect avg: ${numbersFrom1to100.chunked(10){it.average()}.average()}")

    //Windowed
    println(numbersFrom1to100.windowed(10))
    val numbersFrom1To20 = (1..20).toList()
    println(numbersFrom1To20.windowed(3,step=2, partialWindows = true))
    println(numbersFrom1To20.windowed(3){it.sum()})

    //zipWIthNext()
    val listFrom1to4 = (1..4).toList()
    println(listFrom1to4.zipWithNext())
    println(listFrom1to4.zipWithNext(){first,second->
        first > second
    })

    //6. Retrieving single elements
    //retrieve by position
    println(numbersFrom1to100.elementAt(10))
    println(numbersFrom1to100.first())
    println(numbersFrom1to100.last())

    println(numbersFrom1to100.elementAtOrNull(101))
    println(numbersFrom1to100.elementAtOrElse(101){
        "The value for index $it is not available"
    })

    //retrieve by condition
    println(animalNames.first {
        it.startsWith('T')
    })
    println(animalNames.last {
        it.length > 3
    })

    println(animalNames.lastOrNull { it.length > 10 })
    //or firstOrNull

    //alias for firstOrNull() ==> find()
    //alias for lastOrNull() ==> findLast()

    //Retrieve with selector
    //firstNotNullOf()
    val aListOfAny = listOf<Any>(0,"true",false)
    val longEnough = aListOfAny.firstNotNullOf {
        it.toString().takeIf {
            it.length >=4
        }
    }

    //Random element
    val someRandomNumberFrom1T0100 = numbersFrom1to100.random()
    //randomOrNull is used when we try to get random on a empty collection

    //check element existance
    //contains() or `in`
    println(animalNames.contains("Tiger"))
    println("panther" in animalNames)

    //if there are elements at all
    //isEmpty() or isNotEmpty()

    //7. Ordering
    //natural order : `Comparable` interface(compareTo function)

    class Version(val major:Int,val minor:Int):Comparable<Version>{
        override fun compareTo(other: Version): Int {
            return when{
                this.major != other.major -> this.major compareTo other.major
                this.minor != other.minor -> this.minor compareTo other.minor
                else -> 0
            }
        }
    }

    println(Version(1,2) > Version(1,3))

    //custom orders: `Comparator` interface( compare() function)
    val lengthComparator = Comparator{str1:String,str2:String->
        str1.length - str2.length
    }
    println(listOf("aaa","bb","c").sortedWith(lengthComparator))


    //shorter way to define a Comparator is CompareBy()
    println(listOf("aaa","bb","c").sortedWith(compareBy{
        it.length
    }))

    //sorting with natural order
    //sorted and sortedDescending

    val someRandomShuffledNumbers = numbersFrom1to100.shuffled()
    println(someRandomShuffledNumbers)
    println(someRandomShuffledNumbers.sorted())
    println(someRandomShuffledNumbers.sortedDescending())

    println(animalNames.sortedBy { it.length })
    println(animalNames.sortedByDescending { it.length })

    //Reverse order( reversed()-> creates a copy of collection and asReversed()->Does not create copy but create a view(means the change in original will be reflected on the copy
    println(animalNames.reversed())

    //8. Aggregate functions

    val someRandomNumberList = mutableListOf<Int>()
    for(i in 1..10) someRandomNumberList.add(Random(1000).nextInt())

    println(someRandomNumberList)
    println("Count: ${someRandomNumberList.count()}")
    println("Max: ${numbers.maxOrNull()}")
    println("Min: ${numbers.minOrNull()}")
    println("Average: ${numbers.average()}")
    println("Sum: ${numbers.sum()}")


    //fold and reduce
    println(someRandomNumberList.fold(0){sum,i->
        sum+i
    })
    println(someRandomNumberList.reduce{sum,el->
        sum+el
    })
    println(someRandomNumberList.foldRight(0){element,sum->
        sum+element
    })
    println(someRandomNumberList.reduceRight{el,sum->
        sum+el
    })
    println(someRandomNumberList.foldIndexed(0){ind,sum,i->
        sum+i+ind
    })
    println(someRandomNumberList.reduceIndexed{ind,sum,el->
        sum+el+ind
    })
    println(someRandomNumberList.foldRightIndexed(0){ind,element,sum->
        sum+element+ind
    })
    println(someRandomNumberList.reduceRightIndexed{ind,el,sum->
        sum+el+ind
    })


    //Collection write operations
    //add
    val mutableListOfNumbersFrom1To30 = (1..30).toMutableList()
    mutableListOfNumbersFrom1To30.add(31)
    mutableListOfNumbersFrom1To30.addAll(setOf(32,33))
    println(mutableListOfNumbersFrom1To30)
    mutableListOfNumbersFrom1To30.addAll(5,listOf(0,0,0))
    println(mutableListOfNumbersFrom1To30)

    mutableListOfNumbersFrom1To30 += 50
    mutableListOfNumbersFrom1To30 += listOf(51,52,53)
    println(mutableListOfNumbersFrom1To30)

    //remove
    mutableListOfNumbersFrom1To30.remove(53)
    println(mutableListOfNumbersFrom1To30)
    mutableListOfNumbersFrom1To30.removeAll(setOf(50,51,52))
    mutableListOfNumbersFrom1To30.retainAll((1..30).toList())
    println(mutableListOfNumbersFrom1To30)
    mutableListOfNumbersFrom1To30 -= listOf(24,25,26)
    println(mutableListOfNumbersFrom1To30)
    mutableListOfNumbersFrom1To30.clear()
    println(mutableListOfNumbersFrom1To30)

    //List-specific operations
    val listOfCityNames = listOf("mumbai","ahmedabad","pune","delhi")
    println(listOfCityNames)

    //retrieve element by index
    //different get()
    println(listOfCityNames.get(3))
    println(listOfCityNames[2])
    println(listOfCityNames.getOrNull(5))
    println(listOfCityNames.getOrElse(5){
        println("This index is out of bound")
    })

    //retrieving list parts
    val listOfComputerParts = mutableListOf("monitor","CPU","RAM","GPU","COOLING KIT")
    println(listOfComputerParts)
    println(listOfComputerParts.subList(1,3))

    //find element position in the list
    //linear search
    println("the position of monitor in list is: ${listOfComputerParts.indexOf("monitor")}")
    println("the position of CPU in list is: ${listOfComputerParts.lastIndexOf("CPU")}")

    println(listOfComputerParts.indexOfFirst { it.length > 3 })
    println(listOfComputerParts.indexOfLast { it.length > 3 })

    //binary search
    listOfComputerParts.sort()
    listOfComputerParts.binarySearch("CPU")

    //Set specific operations
    val setOfNumbersFrom1to5 = setOf(1,2,3,4,5)
    println(setOfNumbersFrom1to5 union setOf(2,5,6,7))
    println(setOfNumbersFrom1to5 intersect  setOf(2,5,6,7))
    println(setOfNumbersFrom1to5 subtract   setOf(2,5,6,7))


    //Map Specific operations
    val mapOfNumbersWithString = mapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )
    println(mapOfNumbersWithString.get(1))
    println(mapOfNumbersWithString[2])
    println(mapOfNumbersWithString[2])
    println(mapOfNumbersWithString.getOrDefault(5,"No such key"))

    println("All keys are: ${mapOfNumbersWithString.keys}")
    println("All values are: ${mapOfNumbersWithString.values}")

    //filter map
    val newMap = mapOfNumbersWithString.filter {
        it.value.length >3
    }
    println(newMap)

    //filterKeys and filterValues
    println(mapOfNumbersWithString.filterKeys {
        it>1
    })
    println(mapOfNumbersWithString.filterValues {
        it.length<=3
    })

    //plus and minus operators
    val someMapOfStringtoInt = mutableMapOf(
        "Hello" to 5,
        "Bye" to 3,
        "Good morning" to 11
    )

    someMapOfStringtoInt + ("Hey" to 3)
    println(someMapOfStringtoInt)
    someMapOfStringtoInt + mapOf("H" to 1,"k" to 1)


    //adding or removing in/from map
    someMapOfStringtoInt.put("YO",2)
    someMapOfStringtoInt["Dance"] = 5

    println(someMapOfStringtoInt)

    someMapOfStringtoInt.remove("YO")
    println(someMapOfStringtoInt)
}