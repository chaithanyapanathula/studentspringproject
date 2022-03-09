package com.example.demo.service;

import com.example.demo.dto.Department;
import com.example.demo.dto.Student;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartents();

    Department getDepartment(Integer dept_id);
    void addDepartment(Department department);
    Department updatingDepartment(Department department);
    void DeleteDepartment(Integer dept_id);
}
