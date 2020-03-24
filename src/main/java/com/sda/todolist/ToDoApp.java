package com.sda.todolist;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class ToDoApp {

    public static void main(String[] args) throws ParseException, IOException {


        ObjectMapper mapper = new ObjectMapper();
        Scanner in = new Scanner(System.in);
        int option = 0;

        System.out.println("Welcome to ToDoList");
        System.out.println("You have X tasks todo and Y tasks are done!");
        TasksList myTaskList = new TasksList();

        do {
            System.out.println("Pick an option:");
            System.out.println("(1) Show Task List (by date or project)");
            System.out.println("(2) Add New Task");
            System.out.println("(3) Edit Task (update, mark as done, remove)");
            System.out.println("(4) Save and Quit");
            option = Integer.parseInt(in.nextLine()); //input from user

            if (option == 1) { // Show list of tasks
                // IntStream.range(0, myTaskList.size()).mapToObj(i -> (i + 1) + " " + myTaskList.get(i).toString()).forEach(System.out::println);

            } else if (option == 2) {  //Add new Task
                System.out.println("Write name of the task:");
                String name = in.nextLine();

                System.out.println("Write due date in format YYYY-MM-DD:");
                String enteredDate = in.nextLine();
                LocalDate dueDate = LocalDate.parse(enteredDate);

                System.out.println("Write name of the project:");
                String project = in.nextLine();

                Task newTask = new Task(name, dueDate, project, false);
                System.out.println(myTaskList.getTasks().add(newTask));


                try {
                    //Convert object to JSON string and save into file directly
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("ToDo.json"), myTaskList);

                    //Convert object to JSON string
                    String jsonInString = mapper.writeValueAsString(myTaskList);
                    System.out.println(jsonInString);

                    //Convert object to JSON string and pretty print
                    jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myTaskList);
                    System.out.println(jsonInString);


                } catch (JsonGenerationException e) {
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            } else if (option == 3) {
                System.out.println("Choose a task id to Edit");


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



