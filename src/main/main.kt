package main

enum class TaskStatus {
    TODO,
    DONE
}

data class Task(
    var task: String = "",
    var status: TaskStatus= TaskStatus.TODO
)

fun main(args: Array<String>) {
    var TaskList = mutableListOf<String>().also {
        println("Hello, it's a task manager")

    }


}