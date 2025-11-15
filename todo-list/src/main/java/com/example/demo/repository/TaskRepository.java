package com.example.demo.repository;


import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;
//import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> {


//    Optional<Task> findById(Long id, Task task);
//    Optional<Task> updateTask(Long id, Task task);

}
    // Go to: http://localhost:8080/h2-console
    //JDBC URL: jdbc:h2:mem:testdb
    //Username: kim
    //Password: password

