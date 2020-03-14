package com.sda.todolist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {

        System.out.println("Welcome to ToDoList");
        System.out.println("You have X tasks todo and Y tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt(); //input from user

        if (option == 1) {
            List<Task> myTaskList = new ArrayList<>();
            myTaskList.add(new Task("meet psycologist ", new Date(2020, 02, 16), "project1  ", false)); //Adding object in arraylist
            myTaskList.add(new Task("meet psycologist ", new Date(2020, 02, 16), "project1  ", false)); //Adding object in arraylist
            System.out.println(myTaskList);
        } else {
            System.out.println("Other options are not implemented yet!");
        }
        in.close();
    }
}
