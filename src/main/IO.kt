package main

import kotlin.system.exitProcess

class IO() {
    fun screen(tasks: TaskManager){
        while(true){
            println("1. Show all your tasks \n2. Show your completed tasks \n3. Add new task \n4. Select task to delete or change status\n5. Exit app")
            val answer = readln()
            when(answer){
                "1" -> showAll(tasks)
                "2" -> showCompleted(tasks)
                "3" -> addTask(tasks)
                "4" -> {
                    println("Select task")
                    val taskNum = readln()
                    if (taskNum.toIntOrNull() == null || taskNum.toInt() !in tasks.getAllTasks().indices){
                        println("There are no such task\n")
                        continue
                    }

                    println("Select action:\n1. Change task status to \"IN PROGRESS\"\n2. Change task status to \"DONE\"\n3. Delete task")
                    when (readln()){
                        "1" -> tasks.start(taskNum.toInt())
                        "2" -> tasks.complete(taskNum.toInt())
                        "3" -> tasks.removeTask(taskNum.toInt())
                        else -> continue
                    }
                }
                "5" -> exitProcess(0)
                else -> continue
            }
        }
    }
    fun showAll(tasks: TaskManager){
        if (tasks.getAllTasks().size == 0) {
            println("YOU HAVE NO TASKS YET\n")
        } else {
            tasks.getAllTasks().forEachIndexed { index, task ->
                println("${index+1}. ${task.title} | ${task.status}")
            }
            println()}
    }

    fun showCompleted(tasks: TaskManager){
        if (tasks.getAllTasks().size == 0) {
            println("YOU HAVE NO TASKS YET\n")
        }else{
            tasks.getCompletedTasks().forEachIndexed { index, task ->
                println("${index+1}. ${task.title}")
            }
            println()}
    }
    fun addTask(tasks: TaskManager){
        println("Enter your task:")
        val string = readln()
        tasks.addTask(string)
    }
}