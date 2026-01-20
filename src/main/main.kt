package main

fun main() {
    val testUser = User(1, "Sasha")
    val taskList = TaskManager()
    val screen = IO()
    screen.screen(taskList)
}


