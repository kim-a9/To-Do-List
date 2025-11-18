package com.example.demo;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.services.TaskServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoListApplicationTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServices taskServices;

    @AfterEach
    void tearDown() {
        taskRepository.deleteAll();
    }


    @Test
	void createTask() {

        Long taskId = 1L;
        Task expectedTask = new Task(taskId, "Finish unit tests", false);
        Task saveTask = new Task(taskId, "Finish unit tests", false);

        when(taskRepository.save(expectedTask)).thenReturn(saveTask);

        Task result = taskServices.createTask(expectedTask);

        assertEquals(expectedTask.getTask(), result.getTask());
        verify(taskRepository, times(1)).save(expectedTask);

	}

    @Test
    void getAllTasks() {
        Long t1 = 1L;
        Long t2 = 2L;
        Task task1 = new Task(t1, "Implement createTask test", true);
        Task task2 = new Task(t2, "Implement getAll test", false);

//        List<Task> t = new java.util.ArrayList<>(List.of(task1, task2));
        when(taskRepository.save(task1)).thenReturn(task1);
        when(taskRepository.save(task2)).thenReturn(task2);
        when(taskRepository.findAll()).thenReturn(List.of());


        Task savedT1 = taskServices.createTask(task1);
        Task savedT2 = taskServices.createTask(task2);
        List<Task> allTasks = taskServices.getAllTasks();

        assertNotNull(allTasks);
        assertThat(allTasks).isNotNull().isEmpty();

    }

    @Test
    void getTaskById() {
        Long t1 = 1L;
        Long t2 = 2L;
        Task task1 = new Task(t1, "Implement createTask test", true);
        Task task2 = new Task(t2, "Implement getAll test", false);

        when(taskRepository.save(task1)).thenReturn(task1);
        when(taskRepository.save(task2)).thenReturn(task2);
        when(taskRepository.findById(t1)).thenReturn(Optional.of(task1));


        Task savedT1 = taskServices.createTask(task1);
        Task savedT2 = taskServices.createTask(task2);
        Optional<Task> taskId = taskServices.getTaskId(t1);

        verify(taskRepository, times(1)).findById(t1);
        assertTrue(taskId.isPresent());
        assertEquals(task1.getId(), taskId.get().getId());

    }

    @Test
    void updateTask() {
        Long t1 = 1L;
        Task task = new Task(t1, "Old task", false);
        Task newTask = new Task(t1, "New task Updated", true);

        when(taskRepository.save(task)).thenReturn(task);
        when(taskRepository.findById(t1)).thenReturn(Optional.of(task));

        Task updatedTask = taskServices.updateTask(t1, newTask);

        assertNotNull(updatedTask);
        assertEquals(t1, updatedTask.getId());
        assertEquals("New task Updated", updatedTask.getTask());
    }

    @Test
    void deleteTask() {
        Long taskId = 1L;
        Task task = new Task(taskId, "task to be deleted", true);

        when(taskRepository.save(task)).thenReturn(task);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        taskServices.deleteTask(taskId);

        verify(taskRepository, times(1)).deleteById(taskId);


    }





}
