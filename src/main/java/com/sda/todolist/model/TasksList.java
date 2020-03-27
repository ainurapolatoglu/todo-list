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

    public void sortByProject() {
        System.out.println("Sorted by Project name");
        Collections.sort(tasks, new ProjectComparator());
    }

    public void sortByDate() {
        System.out.println("Sorted by Date");
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.getDueDate() == null) {
                    return -1; //consider null as smallest, so it should be up in the list after sorting
                }
                if (t2.getDueDate() == null) {
                    return 1;
                }
                return t1.getDueDate().compareTo(t2.getDueDate());
            }
        });
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int index) {
        if (index > tasks.size()) {
            System.out.println("Entered number is less than number of tasks in the list.");
            return null;
        } else {
            return tasks.get(index);
        }
    }

    public String toString() {
        return tasks.stream().map(String::valueOf).collect(Collectors.joining("\n", " My Tasks: \n", "\n")).toString();
    }
}
