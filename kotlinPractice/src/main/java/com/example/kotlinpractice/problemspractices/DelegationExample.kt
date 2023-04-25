package com.example.kotlinpractice.problemspractices

/*
Created By: Aayush Sarikhada
Updated on: 19 apr 2023

This file contains example that uses delegation.
 */
interface Task {
    fun execute()
}

// Define the class that delegates the task to different objects
class TaskDelegator(private val task: Task) : Task by task

// Define the employee class
class Employee2(private val name: String) {
    fun executeTask(task: Task) {
        println("$name is executing task")
        task.execute()
    }

    fun isManager(): Boolean {
        // return true if employee is a manager
        return false
    }

    fun isSupervisor(): Boolean {
        // return true if employee is a supervisor
        return false
    }
}

// Define the supervisor class
class Supervisor(private val name: String) {
    fun executeTask(task: Task) {
        println("$name is executing task")
    }
}

// Define the manager class
class Manager(private val name: String) {
    fun executeTask(task: Task) {
        println("$name is executing task")
    }
}

// Define a task to be executed
class SimpleTask : Task {
    override fun execute() {
        println("Task completed")
            // delegate the task to different objects based on their level of authorization
            if (employee.isManager()) {
                manager.executeTask(this)
            } else if (employee.isSupervisor()) {
                supervisor.executeTask(this)
            } else {
                employee.executeTask(this)
            }
    }
}


val employee = Employee2("John")
val supervisor = Supervisor("Jane")
val manager = Manager("Mike")

val simpleTask = SimpleTask()
val taskDelegator = TaskDelegator(simpleTask)

fun main(){
    taskDelegator.execute()
}