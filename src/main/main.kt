package main

enum class TaskStatus {
    TODO,
    DONE
}

data class Task(
    var task: String = "",
    var status: TaskStatus = TaskStatus.TODO
)

fun main(args: Array<String>) {
    var TaskList = mutableListOf<Task>().also {
        println("Hello, it's a task manager")
    }
    var ext = false
    while (!ext) {
        actionQuestion()//сначала блок вопроса что делать - показать список; добавить новое задание; удалить выбранное
        printTaskList(TaskList) //если список пуст, то "Давайте создадим", если есть то "Вот ваш список н\ ${Список}"


    }


}

fun actionQuestion() {
    val basicAnswers = listOf(
        "1. Show task list",
        "2. Add new task",
        "3. Select and remove task",
    )
}

fun printTaskList(taskList: MutableList<Task>) {

}
