package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class TaskExecutor {
    private final Task task;

    public TaskExecutor(Task task) {
        this.task = task;
    }

    public void work() {
        System.out.println("Выполняется задача: " + task);
        //throw new RuntimeException("exception in TaskExecutor");
       // return task.getDuration();
    }
}
