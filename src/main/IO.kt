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
                    if (!inputIntCheck(taskNum)){
                        println("Wrong input. You need to enter a number of task\n")
                        continue
                    }
                    val tNum = taskNum.toInt()-1
                    if(!tasks.rangeCheck(tNum)){
                        println("There is no such task")
                        continue
                    }
                    println("You've chosen task: ${tasks.getAllTasks()[tNum].title}")
                    println("Select action:\n1. Change task status to \"IN PROGRESS\"\n2. Change task status to \"DONE\"\n3. Delete task")
                    when (readln()){
                        "1" -> if(!tasks.start(taskNum.toInt())) println("Unable to start the task. There's no such task or it's already completed\n")
                        "2" -> if(!tasks.complete(taskNum.toInt())) println("Unable to complete the task. There's no such task or it's already completed\n")
                        "3" -> if(!tasks.removeTask(taskNum.toInt())) println("Unable to remove the task. There's no such task\n")
                        else -> continue
                    }
                }
                "5" -> exitProcess(0)
                else -> continue
            }
        }
    }
    fun showAll(tasks: TaskManager){
        if (tasks.getAllTasks().isEmpty()) {
            println("YOU HAVE NO TASKS YET\n")
        } else {
            tasks.getAllTasks().forEachIndexed { index, task ->
                println("${index+1}. ${task.title} | ${task.status}")
            }
            println()}
    }

    fun showCompleted(tasks: TaskManager){
        if (tasks.getAllTasks().isEmpty()) {
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
    fun inputIntCheck(input: String): Boolean{
        return input.toIntOrNull() != null
    }
}