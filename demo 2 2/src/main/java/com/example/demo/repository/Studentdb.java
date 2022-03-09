package com.example.demo.repository;

import com.example.demo.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Studentdb {
  private List<Student> l=new ArrayList<>();

    public List<Student> getstudentList() {
        if(l.size() ==0) {
            Student st1=new Student(1,"Venkata","Guntupalli","CSE");
            Student st2=new Student(2,"Sai","Guntupalli","EEE");
            Student st3=new Student(3,"Kumar","Guntupalli","MEE");

            l.add(st1);
            l.add(st2);
            l.add(st3);
        }
        return l;
    }
}
