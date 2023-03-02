package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TaskRepository extends JpaRepository <Task, Long>{
}
