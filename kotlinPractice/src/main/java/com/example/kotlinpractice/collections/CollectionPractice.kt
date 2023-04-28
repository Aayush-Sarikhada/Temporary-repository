package com.example.kotlinpractice.collections

import java.util.LinkedList
import kotlin.random.Random

/*
Created By: Aayush Sarikhada
Updated on: 27 apr 2023

This file contains notes and examples of collections in kotlin
 */

//types of collections : list, map and set
fun main() {
    // list
    // mutable
    val numbers = mutableListOf(11, 12, 13)
    numbers.add(14)
    println(numbers)    //prints: 11 12 13

    //immutable
    val namesOfFriends = listOf("Ajay, Mehsur, Rick")
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

    println("before: $listOfNumbersForMutableIteratorDemo")         // prints: "before: [100, 200, 300, 400, 500]"
    mutableIterator.next()
    mutableIterator.remove()
    println("after removal $listOfNumbersForMutableIteratorDemo")   // prints: "after: [200, 300, 400, 500]"

    mutableIterator.add(600)
    println("after adding $listOfNumbersForMutableIteratorDemo")    // prints: "after adding [600, 200, 300, 400, 500]"

    mutableIterator.next()
    mutableIterator.set(900)
    println("after updating $listOfNumbersForMutableIteratorDemo")  // prints: "after updating [600, 900, 300, 400, 500]"

    //Ranges and Progressions
    val rangeFromOneToTwelve = 1..12
    for (i in rangeFromOneToTwelve) {
        print("$i ")            //prints: 1 2 3 4 5 6 7 8 9 10 11 12
    }

    println()

    for (i in 4 downTo 1)
        print("$i ")            //prints: 4 3 2 1

    println()

    for (i in 1..100 step 10) print("$i ")           //prints: 1 11 21 31 41 51 61 71 81 91
    println()

    for (i in 10 downTo 1 step 2) print("$i ")       //prints: 10 8 6 4 2
    println()

    //from a function
    //creates infinite sequence but lazily
    val oddNumbers = generateSequence(1) { it + 2 }
    println(oddNumbers.take(5).toList())

    //to create finite return null
    val oddNumbersLessThan10 = generateSequence(1) { if (it < 8) it + 2 else null }
    println(oddNumbersLessThan10)

    //from chunks
    val oddNumbersFromChunks = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(oddNumbersFromChunks.take(5).toList())

    // extension functions
    // 1. Transformations
    // 2. Filtering
    // 3. Plus and Minus
    // 4. Grouping
    // 5. Retrieving collection parts
    // 6. Retrieving single elements
    // 7. Ordering
    // 8. Aggregate operations
    // doesn't change the original collection

    // filter extension function
    var numberFromOneToFiveAsStrings = listOf("One", "Two", "Three", "Four", "Five")
    numberFromOneToFiveAsStrings.filter {
        it.length > 3
    }
    println("numbers are still $numberFromOneToFiveAsStrings")// prints: Numbers are still [One, Two, Three, Four, Five]

    val longerThan3 = numberFromOneToFiveAsStrings.filter {
        it.length > 3
    }
    println("Numbers longer than 3 chars are $longerThan3")  // prints: Numbers longer than 3 chars are [Three, Four, Five]

    //Operations with destinations (they have "To" postfix)
    val filteredResults = mutableListOf<String>()            // destination
    numberFromOneToFiveAsStrings.filterTo(filteredResults) {
        it.length > 3
    }

    //they append the result so above and below both are stored in destination here
    numberFromOneToFiveAsStrings.filterIndexedTo(filteredResults) { index, _ ->
        index == 0
    }
    println(filteredResults)                                // prints: [Three, Four, Five, One]

    val result = numberFromOneToFiveAsStrings.mapTo(HashSet()) {
        it.length
    }
    println("distinct item length are $result")             // prints: distinct item length are [3, 4, 5]

    //sort and sorted
    val sortedNumbers = numberFromOneToFiveAsStrings.sorted()
    println(numberFromOneToFiveAsStrings == sortedNumbers)  // prints: false

    numberFromOneToFiveAsStrings = numberFromOneToFiveAsStrings.toMutableList()
    numberFromOneToFiveAsStrings.sort()
    println(numberFromOneToFiveAsStrings == sortedNumbers)  // prints: true


    // Collection transformation operations
    // 1. Mapping transformation
    val setOfNumbersToBeUsedInTransformations = setOf(1, 2, 3, 4, 5, 6, 7)
    println(setOfNumbersToBeUsedInTransformations.map { it * 4 })        // prints: [4, 8, 12, 16, 20, 24, 28]
    println(setOfNumbersToBeUsedInTransformations.mapIndexed { ind, i ->  // prints: [0, 2, 6, 12, 20, 30, 42]
        ind * i
    })

    println(setOfNumbersToBeUsedInTransformations.mapNotNull {     // prints: [4, 12, 16, 20, 24, 28]
        if (it == 2) null else it * 4
    })

    println(setOfNumbersToBeUsedInTransformations.mapIndexedNotNull { ind, i ->   // prints: [2, 3, 4, 5, 6, 7]
        if (ind == 0) null else i
    })

    //mapping maps
    val numbersMap = mapOf(
        "key1" to 1,
        "key2" to 2,
        "key3" to 3
    )

    println(numbersMap.mapKeys {    //prints: {KEY1=1, KEY2=2, KEY3=3}
        it.key.uppercase()
    })

    println(numbersMap.mapValues {  //prints: {key1=5, key2=6, key3=7}
        it.value + it.key.length
    })

    //zipping transformation function
    val colors = listOf("red", "brown", "gray")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)                         // prints: [(red, fox), (brown, bear), (gray, wolf)]

    val carnivorousAnimals = listOf("Tiger", "Lion")
    println(colors.zip(carnivorousAnimals))             // prints: [(red, Tiger), (brown, Lion)]

    println(colors.zip(animals) { color, animal ->      // prints: [The Fox is red, The Bear is brown, The Wolf is gray]
        "The ${animal.replaceFirstChar { it.uppercase() }} is $color"
    })

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3)
    println(numberPairs.unzip())                        // ([one, two, three], [1, 2, 3])

    //Association transformations
    //associateWith()
    println(numberFromOneToFiveAsStrings.associateWith { it.length })                   // {Five=4, Four=4, One=3, Three=5, Two=3}

    //associateBy()
    println(numberFromOneToFiveAsStrings.associateBy { it.first().uppercaseChar() })    // {F=Four, O=One, T=Two}
    println(numberFromOneToFiveAsStrings.associateBy(keySelector = {            // {F=4, O=3, T=3}
        it.first().uppercaseChar()
    },
        valueTransform = {
            it.length
        }
    ))

    //Flattening transformation
    val numbersSet = listOf(setOf(1, 2, 3, 4), setOf(4, 5, 6, 7), setOf(1, 2))
    println(numbersSet.flatten())                                                       //[1, 2, 3, 4, 4, 5, 6, 7, 1, 2]

    data class StringContainer(val values: List<String>)

    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap {                                        // [one, two, three, four, five, six, seven, eight]
        it.values
    })

    println(
        numberFromOneToFiveAsStrings.joinToString(                                    // Start: Five - Four - One - Three - Two :End
            separator = " - ",
            prefix = "Start: ",
            postfix = " :End"
        )
    )
    println(numberFromOneToFiveAsStrings.joinToString(limit = 3, truncated = "<...>"))  // Five, Four, One, <...>


    //2. Filtering
    val animalNames = listOf("Tiger", "lion", "elephant", "leopard")
    val longerThan3AnimalNames = animalNames.filter {
        it.length > 3
    }
    println(longerThan3AnimalNames)                                                     //[Tiger, lion, elephant, leopard]

    val filteredIndexed = numberFromOneToFiveAsStrings.filterIndexed { ind, i ->
        (ind != 0) && (i.length < 5)
    }
    val filteredNot = mapOfNumbersToTheirStringNames.filterNot {
        it.key <= 3
    }
    println(filteredIndexed)                                                            //[Four, One, Two]
    println(filteredNot)                                                                //{4=four}

    val numbersInDifferentTypes = listOf(null, 1, "two", 3.0, "four", null)
    println("All String elements in upper case: ")
    numbersInDifferentTypes.filterIsInstance<String>().forEach {
        println(it.uppercase())                                                         //TWO FOUR
    }

    val listOfNumbersInStringWithNulls = listOf(null, "one", "two", "three", null)
    listOfNumbersInStringWithNulls.filterNotNull().forEach {                    //3
                                                                                        //3
                                                                                        //5
        println(it.length)
    }

    val studentsNames = listOf("Aniket", "Aayush", "Atul", "Rahul", "Divyang")
    val (studentsWithPrefixA, restOfStudents) = studentsNames.partition { it.first().uppercaseChar() == 'A' }
    println("Students whose names start with 'A': $studentsWithPrefixA")            // Students whose names start with 'A': [Aniket, Aayush, Atul]
    println("rest of the students: $restOfStudents")                                // rest of the students: [Rahul, Divyang]

    //Test predicates : any(), none() and all()

    println(studentsNames.any { it.endsWith("h") })                           // true
    println(studentsNames.none { it.endsWith("h") })                          // false
    println(studentsNames.all { it.endsWith("h") })                           // false

    //any() and none() can also be used to check the collection emptiness.
    val someEmptyCollection = emptyList<String>()
    println(someEmptyCollection.any())                                              // false
    println(someEmptyCollection.none())                                             // true

    //3. plus and minus operators
    val animalNamesListWithMonkeyAdded = animalNames + "Monkey"
    val animalNamesListWithTigerRemoved = animalNames - "Tiger"
    println(animalNamesListWithMonkeyAdded)                                         // [Tiger, lion, elephant, leopard, Monkey]
    println(animalNamesListWithTigerRemoved)                                        // [lion, elephant, leopard]

    //4. Grouping
    //using groupBy()
    val listOfBooks =
        listOf("Atomic habits", "Harry potter pt1", "Harry potter pt2", "12 rules for life")
    println(listOfBooks.groupBy { it.first().uppercase() })                         // {A=[Atomic habits], H=[Harry potter pt1, Harry potter pt2], 1=[12 rules for life]}
    println(listOfBooks.groupBy(keySelector = {                             // {A=[ATOMIC HABITS], H=[HARRY POTTER PT1, HARRY POTTER PT2], 1=[12 RULES FOR LIFE]}
        it.first()
    }, valueTransform = {
        it.uppercase()
    }))

    //groupingBy() and eachCount(),fold(),reduce() and aggregate()
    println(listOfBooks.groupingBy {                                        // {A=1, H=2, 1=1}
        it.first()
    }.eachCount())


    //5. Retrieving collection parts
    //slice()
    val numbersFrom1to100 = (1..100).toList()
    println(numbersFrom1to100)                                                       // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13...99, 100]
    println(numbersFrom1to100.slice(1..10))                             // [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    println(numbersFrom1to100.slice(0..40 step 4))                      // [1, 5, 9, 13, 17, 21, 25, 29, 33, 37, 41]
    println(numbersFrom1to100.slice(setOf(3, 5, 0)))                                // [4, 6, 1]

    //take and drop
    println(numbersFrom1to100.take(10))                                             // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    println(numbersFrom1to100.takeLast(10))                                         // [91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
    println(numbersFrom1to100.drop(10))                                             // [11, 12, 13, 14, 15, 16, 17..., 99, 100]
    println(numbersFrom1to100.dropLast(10))                                         // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10...90]

    println(numbersFrom1to100.takeWhile {                                       // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        it < 10
    })
    println(numbersFrom1to100.takeLastWhile {                                   // []
        it < 10
    })
    println(numbersFrom1to100.dropWhile {                                       // [50, 51, 52, 53..., 100]
        it < 50
    })
    println(numbersFrom1to100.dropLastWhile {                                   // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10..., 49, 50]
        it > 50
    })

    //chunked
    println(numbersFrom1to100.chunked(10))                                      // [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]..., [81, 82, 83, 84, 85, 86, 87, 88, 89, 90], [91, 92, 93, 94, 95, 96, 97, 98, 99, 100]]
    numbersFrom1to100.chunked(10).forEach {
        print("${ it.average() }")                                                   // 5.5 15.5 25.5 35.5 45.5 55.5 65.5 75.5 85.5 95.5
    }

    println("direct avg: ${numbersFrom1to100.average()}")                            // direct avg: 50.5
    println("indirect avg: ${numbersFrom1to100.chunked(10) { it.average() }.average()}")    // indirect avg: 50.5

    //Windowed
    println(numbersFrom1to100.windowed(10))                                     // [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]..., [90, 91, 92, 93, 94, 95, 96, 97, 98, 99], [91, 92, 93, 94, 95, 96, 97, 98, 99, 100]]
    val numbersFrom1To20 = (1..20).toList()
    println(numbersFrom1To20.windowed(3, step = 2, partialWindows = true))      // [[1, 2, 3], [3, 4, 5], [5, 6, 7], [7, 8, 9], [9, 10, 11], [11, 12, 13], [13, 14, 15], [15, 16, 17], [17, 18, 19], [19, 20]]
    println(numbersFrom1To20.windowed(3) { it.sum() })                          // [6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57]

    //zipWIthNext()
    val listFrom1to4 = (1..4).toList()
    println(listFrom1to4.zipWithNext())                                              // [(1, 2), (2, 3), (3, 4)]
    println(listFrom1to4.zipWithNext() { first, second ->                            // [false, false, false]
        first > second
    })

    //6. Retrieving single elements
    //retrieve by position
    println(numbersFrom1to100.elementAt(10))        // 11
    println(numbersFrom1to100.first())                    // 1
    println(numbersFrom1to100.last())                     // 100

    println(numbersFrom1to100.elementAtOrNull(101)) // null
    println(numbersFrom1to100.elementAtOrElse(101) {
        "The value for index $it is not available"        // The value for index 101 is not available
    })

    //retrieve by condition
    println(animalNames.first {                   // Tiger
        it.startsWith('T')
    })
    println(animalNames.last {                    // leopard
        it.length > 3
    })

    println(animalNames.lastOrNull { it.length > 10 })    // null
    //or firstOrNull

    //alias for firstOrNull() ==> find()
    //alias for lastOrNull() ==> findLast()

    //check element existance
    //contains() or `in`
    println(animalNames.contains("Tiger"))                  // true
    println("panther" in animalNames)                       // false

    //if there are elements at all
    //isEmpty() or isNotEmpty()

    //7. Ordering
    //natural order : `Comparable` interface(compareTo function)

    class Version(val major: Int, val minor: Int) : Comparable<Version> {
        override fun compareTo(other: Version): Int {
            return when {
                this.major != other.major -> this.major compareTo other.major
                this.minor != other.minor -> this.minor compareTo other.minor
                else -> 0
            }
        }
    }

    println(Version(1, 2) > Version(1, 3))  // false

    //custom orders: `Comparator` interface( compare() function)
    val lengthComparator = Comparator { str1: String, str2: String ->
        str1.length - str2.length
    }
    println(listOf("Fan", "AC", "Cooler").sortedWith(lengthComparator)) // [AC, Fan, Cooler]

    //shorter way to define a Comparator is CompareBy()
    println(listOf("Fan", "AC", "Cooler").sortedWith(compareBy {// [AC, Fan, Cooler]
        it.length
    }))

    //Reverse order( reversed()-> creates a copy of collection and asReversed()->Does not create copy but create a view(means the change in original will be reflected on the copy
    println(animalNames.reversed()) // [lion, Tiger, leopard, elephant]

    //8. Aggregate functions
    val randomNumberList = mutableListOf<Int>()
    for (i in 1..10) randomNumberList.add(Random(1000).nextInt())

    println(randomNumberList)   // [1811705957, 1811705957, 1811705957, 1811705957, 1811705957, 1811705957, 1811705957, 1811705957, 1811705957, 1811705957]
    println("Count: ${randomNumberList.count()}")   //Count: 10
    println("Max: ${numbers.maxOrNull()}")  // Max: 14
    println("Min: ${numbers.minOrNull()}")  // Min: 11
    println("Average: ${numbers.average()}")    // Average: 12.5
    println("Sum: ${numbers.sum()}")    // Sum: 50

    //fold and reduce
    println(randomNumberList.fold(0) { sum, i ->    // 937190386
        sum + i
    })
    println(randomNumberList.reduce { sum, el ->    // 937190386
        sum + el
    })
    println(randomNumberList.foldRight(0) { element, sum ->
        sum + element   // 937190386
    })
    println(randomNumberList.reduceRight { el, sum ->
        sum + el    // 937190386
    })
    println(randomNumberList.foldIndexed(0) { ind, sum, i ->
        sum + i + ind   // 937190431
    })
    println(randomNumberList.reduceIndexed { ind, sum, el ->
        sum + el + ind  // 937190431
    })
    println(randomNumberList.foldRightIndexed(0) { ind, element, sum ->
        sum + element + ind // 937190431
    })
    println(randomNumberList.reduceRightIndexed { ind, el, sum ->
        sum + el + ind  // 937190422
    })

    //Collection write operations
    //add
    val mutableListOfNumbersFrom1To30 = (1..30).toMutableList()
    mutableListOfNumbersFrom1To30.add(31)
    mutableListOfNumbersFrom1To30.addAll(setOf(32, 33))
    println(mutableListOfNumbersFrom1To30)  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33]

    mutableListOfNumbersFrom1To30.addAll(5, listOf(0, 0, 0))
    println(mutableListOfNumbersFrom1To30)  // [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33]

    mutableListOfNumbersFrom1To30 += 50
    mutableListOfNumbersFrom1To30 += listOf(51, 52, 53)
    println(mutableListOfNumbersFrom1To30)  // [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 50, 51, 52, 53]

    //remove
    mutableListOfNumbersFrom1To30.remove(53)
    println(mutableListOfNumbersFrom1To30)  // [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 50, 51, 52]
    mutableListOfNumbersFrom1To30.removeAll(setOf(50, 51, 52))
    mutableListOfNumbersFrom1To30.retainAll((1..30).toList())
    println(mutableListOfNumbersFrom1To30)  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]

    mutableListOfNumbersFrom1To30 -= listOf(24, 25, 26)
    println(mutableListOfNumbersFrom1To30)  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 27, 28, 29, 30]

    mutableListOfNumbersFrom1To30.clear()
    println(mutableListOfNumbersFrom1To30)  // []

    //List-specific operations
    val listOfCityNames = listOf("mumbai", "ahmedabad", "pune", "delhi")
    println(listOfCityNames)    // [mumbai, ahmedabad, pune, delhi]

    //retrieve element by index
    //different get()
    println(listOfCityNames.get(3)) // delhi
    println(listOfCityNames[2]) // pune
    println(listOfCityNames.getOrNull(5))   // null
    println("This index is out of bound") // This index is out of bound

    //retrieving list parts
    val listOfComputerParts = mutableListOf("monitor", "CPU", "RAM", "GPU", "COOLING KIT")
    println(listOfComputerParts)    // [monitor, CPU, RAM, GPU, COOLING KIT]
    println(listOfComputerParts.subList(1, 3))  // [CPU, RAM]

    //find element position in the list
    //linear search
    println("the position of monitor in list is: ${listOfComputerParts.indexOf("monitor")}")        // the position of monitor in list is: 0
    println("the position of CPU in list is: ${listOfComputerParts.lastIndexOf("CPU")}")    // the position of CPU in list is: 1

    println(listOfComputerParts.indexOfFirst { it.length > 3 }) // 0
    println(listOfComputerParts.indexOfLast { it.length > 3 })  // 4

    //binary search
    listOfComputerParts.sort()
    listOfComputerParts.binarySearch("CPU")

    //Set specific operations
    val setOfNumbersFrom1to5 = setOf(1, 2, 3, 4, 5)
    println(setOfNumbersFrom1to5 union setOf(2, 5, 6, 7))       // [1, 2, 3, 4, 5, 6, 7]
    println(setOfNumbersFrom1to5 intersect setOf(2, 5, 6, 7))   // [2, 5]
    println(setOfNumbersFrom1to5 subtract setOf(2, 5, 6, 7))    // [1, 3, 4]

    //Map Specific operations
    val mapOfNumbersWithString = mapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )

    println(mapOfNumbersWithString.get(1))  // One
    println(mapOfNumbersWithString[2])      // One
    println(mapOfNumbersWithString[2])      // Two
    println(mapOfNumbersWithString.getOrDefault(5, "No such key"))  // No such key

    println("All keys are: ${mapOfNumbersWithString.keys}") // All keys are: [1, 2, 3]
    println("All values are: ${mapOfNumbersWithString.values}") // All values are: [One, Two, Three]

    //filter map
    val newMap = mapOfNumbersWithString.filter {
        it.value.length > 3
    }
    println(newMap) // {3=Three}

    //filterKeys and filterValues
    println(mapOfNumbersWithString.filterKeys { // {2=Two, 3=Three}
        it > 1
    })

    println(mapOfNumbersWithString.filterValues {   // {1=One, 2=Two}
        it.length <= 3
    })
}