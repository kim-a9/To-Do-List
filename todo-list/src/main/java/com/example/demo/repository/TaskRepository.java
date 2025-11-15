package com.example.demo.repository;


import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {



//   void delete(Long id);

}
    // Go to: http://localhost:8080/h2-console
    //JDBC URL: jdbc:h2:mem:testdb
    //Username: kim
    //Password: password

