package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentMongoRepository extends MongoRepository<StudentEntity, Integer> {

}
