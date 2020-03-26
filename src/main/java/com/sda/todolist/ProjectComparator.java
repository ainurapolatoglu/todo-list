package com.sda.todolist;

import java.util.Comparator;

public class ProjectComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getProject().compareTo(t2.getProject());
    }

}