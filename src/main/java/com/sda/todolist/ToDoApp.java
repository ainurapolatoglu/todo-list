package com.sda.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.todolist.model.Task;
import com.sda.todolist.model.TasksList;
import com.sda.todolist.util.FileUtil;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class ToDoApp {

    public static void main(String[] args) throws ParseException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Scanner in = new Scanner(System.in);
        String option;
        System.out.println("Welcome to ToDoList");

        TasksList myTaskList = null;
        FileUtil fileUtil = new FileUtil();
        myTaskList = fileUtil.loadTaskListFile();         // calling a method from FileUtil class to load a file with tasks.
        System.out.println("You have  " + myTaskList.getTasks().size() + " tasks");

        do {
            System.out.println("Pick an option:");
            System.out.println("(1) Show Task List (by date or project)");
            System.out.println("(2) Add New Task");
            System.out.println("(3) Edit Task (update, mark as done, remove)");
            System.out.println("(4) Save and Quit");
            option = in.nextLine();   //input from user

            if (option.equals("1")) {   // Show list of tasks
                myTaskList.printWithIndex();
                System.out.println("If you want to sort tasks: (1) by project, (2) by due date");
                String sortOption = in.nextLine();
                if (sortOption.equals("1")) {  // show sorted list by Project
                    myTaskList.sortByProject();
                    myTaskList.printWithIndex();
                } else if (sortOption.equals("2")) { // show sorted list by Due Date
                    myTaskList.sortByDate();
                    myTaskList.printWithIndex();
                } else {
                    System.out.print("Sorting was not chosen. \n");  // if user did not choose any sorting or entered wrong character.
                }

            } else if (option.equals("2")) {  //Add new Task
                System.out.println("Write name of the task:");
                String name = in.nextLine();

                System.out.println("Write due date in format YYYY-MM-DD:");
                String enteredDate = in.nextLine();
                LocalDate dueDate = null;
                try {
                    dueDate = LocalDate.parse(enteredDate);    // parse input from user into LocalDate format
                } catch (DateTimeParseException d) {
                    System.out.println("Entered date is in the wrong format. Date was not assigned!!!"); // otherwise Task will not have due Date
                }

                System.out.println("Write name of the project:");
                String project = in.nextLine();

                Task newTask = new Task(name, dueDate, project, false);  // new task
                myTaskList.addTask(newTask);   // calling method from TaskList class to add new Task
                System.out.println("Your new task: " + newTask);

            } else if (option.equals("3")) { // Edit task
                System.out.println("Choose a task number to Edit");
                int index;

                try{
                    index = Integer.parseInt(in.nextLine());  // checking if input from user is number
                } catch (NumberFormatException e) {
                    System.out.println("That's not a number!");
                    continue;
                }

                Task taskToEdit = myTaskList.getTask(index - 1);  // calling method from TasksList class to get Task
                if (taskToEdit == null) {  // if entered task by index does not exist in the list
                    continue;
                }
                System.out.println(taskToEdit);
                System.out.println("To edit task press 1, To mark as done press 2, To delete task press 3");
                String choice = in.nextLine();
                if (choice.equals("1")) {                               // Edit title, due date and project name
                    System.out.println("Change task title to:");
                    String newTitle = in.nextLine();
                    if (!newTitle.isEmpty()) {
                        taskToEdit.setName(newTitle);
                    } else {
                        System.out.println("Task name was NOT changed"); // if user leave input empty program will keep old title
                    }

                    System.out.println("Change due date to:");
                    String newDueDate = in.nextLine();
                    if (!newDueDate.isEmpty()) {
                        LocalDate changedDueDate = LocalDate.parse(newDueDate);
                        taskToEdit.setDueDate(changedDueDate);
                    } else {
                        System.out.println("Due date was NOT changed "); // if user leave input empty program will keep old due date
                    }

                    System.out.println("Change project name to:");
                    String newProject = in.nextLine();
                    if (!newProject.isEmpty()) {
                        taskToEdit.setProject(newProject);
                    } else {
                        System.out.println("Project name was NOT changed"); // if user leave input empty program will keep old project name
                    }
                    System.out.println("Task details after edit" + taskToEdit);
                } else if (choice.equals("2")) {                      // Mark task as done
                    taskToEdit.setCompletionStatus(true);
                } else if (choice.equals("3")) {                     // Delete task
                    myTaskList.deleteTask(index - 1);    //calling method from TasksList class
                } else {
                    System.out.println("Choose correct option.");  // if input is not 1,2 or 3
                }

            } else if (option.equals("4")) {                          // Save and Quit
                fileUtil.saveAll(myTaskList);   // calling a method from "FileUtil class to save everything to the json file (update list)
                System.out.println(" Save and Quit option was chosen!");
                System.out.println(" Good Bye!");
                break;
            } else {
                System.out.println("Entered option doesn't exist. Please enter correct option!");
            }
        } while (true);
        in.close();
    }
}



