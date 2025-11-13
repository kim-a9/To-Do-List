package com.example.demo.controllers;

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
    public List<Task> findAll(){
        return toDoRepo.findAll();
    }

    @PostMapping
    public Task save(@Valid @NotNull @RequestBody Task task) {
        return toDoRepo.save(task);
    }

}
