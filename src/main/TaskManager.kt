package main

class TaskManager {
    private val tasks = mutableListOf<Task>()

    fun addTask(content: String) {
        tasks.add(Task(content))
    }

    fun removeTask(taskId: Int): Boolean {
        if (taskId !in tasks.indices) return false
        tasks.removeAt(taskId)
        return true
    }

    fun getAllTasks(): List<Task> {
        return tasks.toList()
    }

    fun getCompletedTasks(): List<Task> {
        return tasks.filter { it.status == TaskStatus.DONE }.toList()
    }



    fun start(taskId: Int): Boolean {
        if (taskId !in tasks.indices) return false
        if (tasks[taskId].status == TaskStatus.DONE) return false
        tasks[taskId].start()
        return true
    }
    fun complete(taskId: Int): Boolean {
        if (taskId !in tasks.indices) return false
        if (tasks[taskId].status == TaskStatus.DONE) return false
        tasks[taskId].complete()
        return true
    }
    fun rangeCheck(taskId: Int): Boolean {
        return taskId in tasks.indices
    }

}
