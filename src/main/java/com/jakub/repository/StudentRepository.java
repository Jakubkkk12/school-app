package com.jakub.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakub.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>
{
    ArrayList<Student> findByName(String name);
}