package com.example.kotlinpractice

/*
Created By: Aayush Sarikhada
Updated on: 27 apr 2023

This file contains notes and examples of classes in kotlin.
*/

fun main() {
        //classes & objects
        class Animal(val name: String) {
            val sound = "Woof!".also { println(it) }

            init {
                println("first init ran")
            }

            init {
                println("second init ran")
            }
        }

        val dog = Animal(name = "dog")
        dog.name                                // we can only have a constructor parameter as property if we have prefixed it in constructor as val/var
                                                // or if we assign it in a property in init block other wise they are only available in init block
                                                // If the constructor has annotations or visibility modifiers, the constructor keyword is required and the modifiers go before it:
                                                // class Customer public @Inject constructor(name: String) { /*...*/ }
                                                // secondary constructors
                                                // If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor, either directly or indirectly through another secondary constructor(s). Delegation to another constructor of the same class is done using the this keyword:
        class Person(val name: String) {
            var age: Int = 0

            init{                               //just like the body of primary constructor
                println("primary constructor ran")
            }

            constructor(name: String, age: Int): this(name) {
                this.age = age
                println("secondary constructor ran")
            }
        }

        // init blocks and primary constructor runs before secondary constructors
        // here this object is only created for checking which constructor or block runs first

        var person = Person("aayush",25)

        // If a non-abstract class does not declare any constructors (primary or secondary), it will have a generated primary constructor with no arguments.The visibility of the constructor will be public.
        // If you don't want your class to have a public constructor, declare an empty primary constructor with non-default visibility:
        // no need to add "open" to inherit this class since it's an abstract class

        abstract class Polygon {
            abstract fun draw()
            init {
                println("polygons constructor called")
            }
        }

        class PolygonImpl: Polygon() {
            init {
                println("implementations constructor called")
            }
            override fun draw() {
                println("Drawing polygon...")
            }
        }

        val polygon = PolygonImpl()
        polygon.draw()

        //Companion objects
        //If you need to write a function that can be called without having a class instance but that needs access to the internals of a class (such as a factory method), you can write it as a member of an object declaration inside that class.
        //
        //Even more specifically, if you declare a companion object inside your class, you can access its members using only the class name as a qualifier.
    }


