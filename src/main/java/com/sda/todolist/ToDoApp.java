package com.sda.todolist;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {

    private static final String filepath = "ToDoList.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException, IOException {

        List<Task> myTaskList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int option = 0;
        System.out.println("Welcome to ToDoList");
        System.out.println("You have X tasks todo and Y tasks are done!");

        do {
            System.out.println("Pick an option:");
            System.out.println("(1) Show Task List (by date or project)");
            System.out.println("(2) Add New Task");
            System.out.println("(3) Edit Task (update, mark as done, remove)");
            System.out.println("(4) Save and Quit");
            option = Integer.parseInt(in.nextLine()); //input from user

            if (option == 1) {
                myTaskList.forEach(System.out::println);
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

                System.out.println("Your new task is:");
                System.out.println(newTask);

            } else if (option == 3) {
                System.out.println("Edit option was chosen");
            } else if (option == 4) {
                System.out.println(" Save and Quit option was chose!");
                System.out.println(" Good Bye!");
                break;
            } else {
                System.out.println("Entered option doesn't exist. Please enter correct option!");
            }
        } while (option > 0);



           /* FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            try {
                objectOut.writeObject(newTask.toString());
                System.out.println("New task was successfully added to a ToDo List");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                objectOut.close();
            }
            */

        // String input = FileUtil.readTextFile(filepath);
        // System.out.println(input);
        //FileUtil.writeToTextFile("ToDoList.txt", myTaskList.toString());

        // System.out.println(FileUtil.readTextFile("Task"));

        //FileUtil.readTextFileByLines("file.txt");
        //Path path = Paths.get("file.txt");
        in.close();

    }
}
