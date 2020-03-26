package com.sda.todolist.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.sda.todolist.ProjectComparator;
import com.sda.todolist.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void printWithIndex() {
        int numberOfTasks = tasks.size();
        IntStream.range(0, numberOfTasks).mapToObj(i -> (i + 1) + " " + tasks.get(i)).forEachOrdered(System.out::println);
    }


    public Task getTask(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
        return null;
    }

    public void sortByProject() {
        System.out.println("Sorted by Project name");
        Collections.sort(tasks, new ProjectComparator());
    }

    public void sortByDate() {
        System.out.println("Sorted by Date");
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getDueDate().compareTo(t2.getDueDate());
            }
        });
    }


    public String toString() {
        return tasks.stream().map(String::valueOf).collect(Collectors.joining("\n", " My Tasks: \n", "\n")).toString();
    }
}
