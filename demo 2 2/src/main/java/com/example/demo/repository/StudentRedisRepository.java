package com.example.demo.repository;

import com.example.demo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRedisRepository {
    public String STUDENT_COLLECTION="Student";
    public RedisTemplate<String, Student>redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public StudentRedisRepository(RedisTemplate<String, Student>redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    @PostConstruct
    public void init(){
        this.hashOps=this.redisTemplate.opsForHash();
    }

    public List<Student> findAll(){
        Map<String,Student> allElements=hashOps.entries(STUDENT_COLLECTION);
        return allElements.values().stream().collect(Collectors.toList());
    }

    public Student findOne(Integer StudentId){
        return (Student) hashOps.get(STUDENT_COLLECTION,StudentId);
    }

    public void addOne(Student student){
        hashOps.put(STUDENT_COLLECTION, student.getId(), student);
    }

    public void deleteOne(Integer id){
        hashOps.delete(STUDENT_COLLECTION,id);

    }
    public Student updatingStudent(Student student){
        hashOps.put(STUDENT_COLLECTION,student.getId(),student);
        return student;
    }
}
