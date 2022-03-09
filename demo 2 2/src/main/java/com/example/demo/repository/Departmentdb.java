package com.example.demo.repository;

import com.example.demo.dto.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Departmentdb {
    private List<Department> dept=new ArrayList<>();
    public List<Department> getDeptList(){
        if(dept.size()==0){
            Department d1=new Department(1,"CSE","Goopi");
            Department d2=new Department(2,"MEE","Varun");
            Department d3=new Department(3,"Sai","ISE");
            dept.add(d1);
            dept.add(d2);
            dept.add(d3);
        }
        return dept;
    }
}
