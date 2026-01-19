package main

import kotlin.system.exitProcess

class IO() {
    fun screen(user: User){
        while(true){
            println("1. Show all your tasks \n2. Show your completed tasks \n3. Add new task \n4. Select task to delete or change status\n5. Exit app")
            val answer = readln()
            when(answer){
                "1" -> user.tasks.showAll()
                "2" -> user.tasks.showCompleted()
                "3" -> user.tasks.addTask()
                "4" -> {
                    println("Select task")
                    val taskNum = readln().toInt()-1
                    println("Select action:\n1. Change task status to \"IN PROGRESS\"\n2. Change task status to \"DONE\"\n3. Delete task")
                    when (readln()){
                        "1" -> user.tasks.start(taskNum)
                        "2" -> user.tasks.complete(taskNum)
                        "3" -> user.tasks.removeTask(taskNum)
                        else -> continue
                    }
                }
                "5" -> exitProcess(0)
                else -> continue
            }
        }
    }
}