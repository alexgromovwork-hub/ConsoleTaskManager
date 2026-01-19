package main

class Task(var title: String, var status: TaskStatus = TaskStatus.TODO) {
    fun start() {
        this.status = TaskStatus.IN_PROGRESS
    }

    fun complete() {
        this.status = TaskStatus.DONE
    }
}