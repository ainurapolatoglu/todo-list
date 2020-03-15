package com.sda.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private Date dueDate;
    private String project;
    private boolean status;

    public Task(String name, Date dueDate, String project, boolean status) {
        this.name = name;
        this.dueDate = dueDate;
        this.project = project;
        this.status = status;
    }

    public String toString() {
        String str = " ";
        str += name;
        str += dateFormat.format(dueDate);
        str += project;
        str += status;
        return str;
    }
}
