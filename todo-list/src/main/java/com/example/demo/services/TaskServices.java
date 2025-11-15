package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository taskRepo;


    public Task createTask(Task task) {
       return taskRepo.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> getTaskId(Long id) {
        return taskRepo.findById(id);
    }

    public Task updateTask(Long id, Task task) {
        Optional<Task> t = taskRepo.findById(id);

        if(t.isPresent()){
            Task newTask = t.get();
            newTask.setTask(task.getTask());
            newTask.setDone(task.isDone());

            return taskRepo.save(newTask);
        }
        else {
            return null;
        }

    }
}
