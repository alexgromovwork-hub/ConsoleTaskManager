package main

fun main() {
    val testUser: User = User(1, "Sasha", TaskManager1())
    val screen = IO()
    screen.screen(testUser)
}


