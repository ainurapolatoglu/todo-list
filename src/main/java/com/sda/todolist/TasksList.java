package com.sda.todolist;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonRootName("tasks")
public class TasksList {
    private List<Task> tasks;

    public TasksList() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String toString() {
        return tasks.stream().map(String::valueOf).collect(Collectors.joining("\n", "\n My Tasks: \n", "\n")).toString();
    }
}
