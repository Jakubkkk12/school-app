package com.jakub.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakub.entity.SchoolClass;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Integer>
{
    ArrayList<SchoolClass> findByName(String name);
}
