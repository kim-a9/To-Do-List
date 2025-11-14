package com.example.demo.controllers;

import com.example.demo.repository.TaskModel;
import com.example.demo.repository.ToDoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/todo")
public class TaskController {

    @Autowired
    private ToDoRepository toDoRepo;

    @GetMapping
    public List<TaskModel> findAll(){
        return toDoRepo.findAll();
    }

    @PostMapping
    public TaskModel save(@Valid @NotNull @RequestBody TaskModel task) {
        return toDoRepo.save(task);
    }

}
