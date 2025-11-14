package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;


public interface ToDoRepository extends JpaRepository<TaskModel, Long> {





    // Go to: http://localhost:8080/h2-console
    //JDBC URL: jdbc:h2:mem:testdb
    //Username: kim
    //Password: password
}
