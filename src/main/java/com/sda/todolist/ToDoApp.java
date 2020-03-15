package com.sda.todolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {

        System.out.println("Welcome to ToDoList");
        System.out.println("You have X tasks todo and Y tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        List<Task> myTaskList = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        int option = Integer.parseInt(in.nextLine()); //input from user
        if (option == 1) {
            myTaskList.add(new Task("meet psycologist ", new Date(2020, 02, 16), "project1  ", false)); //Adding object in arraylist
            myTaskList.add(new Task("meet psycologist ", new Date(2020, 02, 16), "project1  ", false)); //Adding object in arraylist
            System.out.println(myTaskList);
        } else if (option == 2) {
            System.out.println("Give me the name of the task:");
            String name = in.nextLine();

            System.out.println("Give me the due date in format dd/MM/yyyy:");
            String date = in.nextLine();
            Date dueDate = dateFormat.parse(date);

            System.out.println("Give me the name of the project:");
            String project = in.nextLine();

            Task newTask = new Task(name, dueDate, project, false);
            myTaskList.add(newTask);
            System.out.println("New task has been added to the ToDo List:");
            System.out.println(myTaskList);
        }
        in.close();
    }
}
