package com.example.demo.repository;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class TaskModel {
    private long id;
    @NotBlank
    private String task;
    private boolean status;

    public TaskModel() {
    }

    public TaskModel(long id, String task, boolean status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
