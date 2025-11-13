package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface ToDoRepository extends JpaRepository<Task, Long> {

}
