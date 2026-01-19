package main

class TaskManager1 {
    private val tasks = mutableListOf<Task>()

    fun addTask() {
        val task = Task("", TaskStatus.TODO)
        task.title = readln()
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

    fun showAll(){
        if (tasks.size == 0) {
            println("YOU HAVE NO TASKS YET\n")
        } else {
        getAllTasks().forEach {
            println("${tasks.indexOf(it)+1}. ${it.title} | ${it.status}")
        }
        println()}
    }
    fun showCompleted(){
        if (tasks.size == 0) {
            println("YOU HAVE NO TASKS YET\n")
        }else{
        getCompletedTasks().forEach {
            println("${tasks.indexOf(it)+1}. ${it.title}")
        }
        println()}
    }
    fun start(taskId: Int) {
        tasks[taskId].start()
    }
    fun complete(taskId: Int) {
        tasks[taskId].complete()
    }

}
