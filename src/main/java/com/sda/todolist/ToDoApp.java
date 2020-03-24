package com.sda.todolist;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;


public class ToDoApp {

    public static void main(String[] args) throws ParseException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Scanner in = new Scanner(System.in);
        int option = 0;
        System.out.println("Welcome to ToDoList");
        System.out.println("You have X tasks todo and Y tasks are done!");
        TasksList myTaskList = null;

        try {
            File taskFile = new File("ToDo.json");
            myTaskList = mapper.readValue(taskFile, TasksList.class);   // creates object of members from file and assigns it to variable
            System.out.println(taskFile + " file is loaded.");

        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());
        }

        do {
            System.out.println("Pick an option:");
            System.out.println("(1) Show Task List (by date or project)");
            System.out.println("(2) Add New Task");
            System.out.println("(3) Edit Task (update, mark as done, remove)");
            System.out.println("(4) Save and Quit");
            option = Integer.parseInt(in.nextLine()); //input from user

            if (option == 1) { // Show list of tasks
                System.out.println(myTaskList);
            } else if (option == 2) {  //Add new Task
                System.out.println("Write name of the task:");
                String name = in.nextLine();

                System.out.println("Write due date in format YYYY-MM-DD:");
                String enteredDate = in.nextLine();
                LocalDate dueDate = LocalDate.parse(enteredDate);

                System.out.println("Write name of the project:");
                String project = in.nextLine();

                Task newTask = new Task(name, dueDate, project, false);
                myTaskList.getTasks().add(newTask);

                try {
                    //Convert object to JSON string and save into file directly
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("ToDo.json"), myTaskList);
                    System.out.println("Your new task: " + newTask);
                    //Write to json file with pretty printer
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myTaskList);
                } catch (JsonGenerationException e) {
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (option == 3) {
                System.out.println("Choose a task id to Edit");
                String name = in.nextLine();
                String taskName = myTaskList.getTasks().toString();
                System.out.println(taskName);


            } else if (option == 4) {
                System.out.println(" Save and Quit option was chosen!");
                System.out.println(" Good Bye!");
                break;
            } else {
                System.out.println("Entered option doesn't exist. Please enter correct option!");
            }
        } while (option > 0);
        in.close();
    }
}



