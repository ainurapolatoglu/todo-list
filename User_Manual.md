# ToDoApp Manual

This imanual is for the ToDo App program which was build in Java language and placed in  [GitLab](https://git.2020.school/ainura_polatoglu/todo-list) 

This program's main information:
* Application is based on user's input. 
* com.sda.todolist - main package which has inside following packages: 
  - jackson
  - model
  - util
* Main directory has: 7 Java classes. 
* Unit Tests 

## com.sda.todolist

This package has ToDoApp class, which is main class of this program. 
   ![The Creative Commons Attribution-ShareAlike logo](main.png)
It is responsible for showing options for the user and processing user's input. 
First it loads json file with list of tasks by calling loadTaskListFile() method from FileUtil class. If there is no such file, program creates a new json file namde ToDo.json. 
It provides number of tasks in the list and shows options to the user. 

* 1. - Show Tasks 
   First it shows tasks using printWithIndex method from TaskList class to print list with indexes. 
   After that it asks if user wishes to sort: by due date, by project. If sorting was not chosen or other character was entered, porgramm will give an error and will show main options again. 
* 2. - Add new task
   Program asks to enter title, due date, project of the new task. If wrong format or nothing was entered to due date is will assign to NULL, which means task will not have due date. And then will add new task to the list. 
* 3. - Edit task. 
    User needs to enter index of the task which he/she wishes to etid. 
	Edit options consist of 3 options: 1. Edit title,due date,project. 2. Mark task as done. 3. Delete task. If none of the options was chosen program will continue and show main options. 
* 4. - Save and Quit. 
    Program is designed that all changes made during running will not be saved automatically. It will save all changes to the json file only when user choose to Save and Quit program. One of the purpose to do this way, is that saving tasks each time user makes changes or adds some task, it is cotly since program will need to access every time to the file. 

## model package
   It consits of Task.java and TaskList.java to collect models in seprate package. Both classes has fields and methods which makes a task or list of tasks. 

## util 
   This package has FileUtil.java to load and save changes to the file. In other words all methods that consider file. 

## jackson
   It has two classes LocalDateSerializer and LocalDateDeserializer to read and write LocalDate to/from json file in formatted way. 



### Validations

- Validations to the user input has been implemented in this program. 
  For example:
  - if wrong format date was entered it will give a message that wrong format was entered and save dueDate as null, so task will not have any dueDate. 
  - if user input number of index of task to edit and it this number is bigger than the list size, program will give an error message and continue with program. 


## jackson annotations

Task class uses jackson.annotation to specify methods and fields. In particular it is very important to specify    @JsonSerialize(using = LocalDateSerializer.class) @JsonDeserialize(using = LocalDateDeserializer.class) , so program doesnt crash because due date was written in not serialized format. 

### Jackson dependency 
   In this program, I used jackson to be able to work with JSON files, such as write and read. 
 * build.gradle has following dependency: 
dependencies {
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.10.3'
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

## Exceptions

Program uses exceptions to handle different kind of possible errors. 
For example when opening the json file or entering wrong format for date. 

## Git usage

GitLab was used to store version and development of this program.
I have learnt usage of branches, merge, pull requests and commits with correct usage of issues and milestones, which helped to track improvment of my program. 

