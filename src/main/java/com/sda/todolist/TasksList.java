package com.sda.todolist;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sda.todolist.jackson.LocalDateDeserializer;
import com.sda.todolist.jackson.LocalDateSerializer;

import java.time.LocalDate;
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
        StringBuilder str = new StringBuilder();
        str.append(tasks.stream().map(String::valueOf).collect(Collectors.joining("\n", "\n My Tasks: \n", "\n")).toString());
        return str.toString();
    }
}
