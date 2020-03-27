import com.sda.todolist.model.Task;
import com.sda.todolist.model.TasksList;
import com.sda.todolist.util.FileUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTaskList {
    @Test
    public void addNewTaskToTaskList() {
        TasksList myTaskList = new TasksList();

        Task task = new Task("Test task", LocalDate.of(2020, 2, 5), "Test porject", false);
        myTaskList.addTask(task);
        Task result = myTaskList.getTask(0);
        assertEquals(task, result);
    }
    @Test
    public void deleteTaskFromTaskList() {
        TasksList myTaskList = new TasksList();

        Task task = new Task("Test task", LocalDate.of(2020, 2, 5), "Test porject", false);
        myTaskList.addTask(task);
        Task result = myTaskList.getTask(0);
        assertEquals(task, result);

        myTaskList.deleteTask(0);
        assertNull(myTaskList.getTask(0));
    }
}


