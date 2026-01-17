package main

class TaskManager {
    private val tasks = mutableSetOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun removeTask(taskId: Int) {

    }
}