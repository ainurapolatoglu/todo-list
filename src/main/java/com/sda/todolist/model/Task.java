package com.sda.todolist.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sda.todolist.jackson.LocalDateDeserializer;
import com.sda.todolist.jackson.LocalDateSerializer;

import java.time.LocalDate;

@JsonRootName(value = "name")
@JsonPropertyOrder({"name", "dueDate", "project", "completionStatus"})
public class Task {
    private String name;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;
    private String project;
    private boolean completionStatus;

    public Task(String name, LocalDate dueDate, String project, boolean completionStatus) {
        this.name = name;
        this.dueDate = dueDate;
        this.project = project;
        this.completionStatus = completionStatus;
    }

    public Task() {

    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("dueDate")
    public LocalDate getDueDate() {
        return dueDate;
    }

    @JsonSetter("dueDate")
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @JsonGetter("project")
    public String getProject() {
        return project;
    }

    @JsonSetter("project")
    public void setProject(String project) {
        this.project = project;
    }

    @JsonGetter("completionStatus")
    public boolean isCompletionStatus() {
        return completionStatus;
    }

    @JsonSetter("completionStatus")
    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("name: ");
        str.append(name);
        str.append(", due date: ");
        str.append(dueDate);
        str.append(", project: ");
        str.append(project);
        str.append(", Done?: ");
        str.append(completionStatus);
        return str.toString();
    }



}
