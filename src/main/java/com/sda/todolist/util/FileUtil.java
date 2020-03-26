package com.sda.todolist.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.todolist.model.TasksList;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    ObjectMapper mapper = new ObjectMapper();

    public TasksList loadTaskListFile(){
        TasksList myTaskList = null;
        try {
            File taskFile = new File("ToDo.json");
            myTaskList = mapper.readValue(taskFile, TasksList.class);   // creates object of members from file and assigns it to variable
            System.out.println(taskFile + " file is loaded.");

        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());
            myTaskList = new TasksList();
        }
        return myTaskList;
    }

    public void saveAll(TasksList mytaskList){
        try {
            //Convert object to JSON string and save into file directly
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("ToDo.json"), mytaskList);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
