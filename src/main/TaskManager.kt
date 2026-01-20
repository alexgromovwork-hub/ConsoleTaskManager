package main

class TaskManager {
    private val tasks = mutableListOf<Task>()

    fun addTask(content: String) {
        val task = Task("", TaskStatus.TODO)
        task.title = content
        tasks.add(task)
    }

    fun removeTask(taskId: Int) {
        tasks.removeAt(taskId)
    }

    fun getAllTasks(): List<Task> {
        return tasks
    }

    fun getCompletedTasks(): List<Task> {
        return tasks.filter { it.status == TaskStatus.DONE }
    }



    fun start(taskId: Int): Boolean {
        if (taskId !in tasks.indices) return false
        tasks[taskId].start()
        return true
    }
    fun complete(taskId: Int): Boolean {
        if (taskId !in tasks.indices) return false
        tasks[taskId].complete()
        return true
    }

}
