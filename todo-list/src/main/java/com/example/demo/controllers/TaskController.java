package com.example.demo.controllers;

import com.example.demo.model.Task;
import com.example.demo.services.TaskServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/todo")
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    @PostMapping
    public Task createTask(@Valid @NotNull @RequestBody Task task) {
       return taskServices.createTask(task);
    }

    @GetMapping
    public List<Task> findAllTasks() {
        return taskServices.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> findTaskId(@PathVariable Long id) {
        return taskServices.getTaskId(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
        return taskServices.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id);
    }


}
