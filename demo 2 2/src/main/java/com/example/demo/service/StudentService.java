package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    List<Student> getpgstudents();
    List<Student> getMgstudents();
    List<Student> getredisstudents();
    Student getStudent(Integer id);

    void addpgStudent(Student student);
    void addMgstudent(Student student);
    void addredisStudent(Student student);
    void addStudent(Student student);


    Student updatingStudent(Student student);
    Student updatepgStudent(Student student);

    List<Student> getlsStudent();

    void addlSStudent(Student student);

    Student updatelStudent(Student student);
    void DeleteStudent(Integer id);
}
