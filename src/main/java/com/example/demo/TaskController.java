package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @PutMapping("/tasks/{id}")
    Task updateTask(@RequestBody Task updateTask, @PathVariable Long id) {

        return repository.findById(id)
                .map(task -> {
                    task.setDescription(updateTask.getDescription());
                    task.setPriority(updateTask.getPriority());
                    return repository.save(task);
                })
                .orElseGet(() -> {
                    updateTask.setId(id);
                    return repository.save(updateTask);
                });
    }

}
