package com.example.demo.service;

import com.example.demo.dto.Department;
import com.example.demo.dto.Student;
import com.example.demo.repository.Departmentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {

    @Autowired
    Departmentdb departmentdb;

    @Override
    public List<Department> getAllDepartents(){

      return departmentdb.getDeptList();
    };

    @Override
    public Department getDepartment(Integer dept_id){
        for(Department department:departmentdb.getDeptList()){
            if(department.getDept_id()==dept_id){
                return department;
            }
        }
        return null;
    };

    @Override
    public void addDepartment(Department department){
        departmentdb.getDeptList().add(new Department(department.getDept_id(),department.getDept_name(),department.getDept_hod()));
    };

    @Override
    public Department updatingDepartment(Department department){
        for(Department dep:departmentdb.getDeptList()){
            if(dep.getDept_id()==department.getDept_id()){
                dep.setDept_hod(department.getDept_hod());
            }
        }
        return department;
    };

    @Override
    public void DeleteDepartment(Integer dept_id){
        for(Department dep:departmentdb.getDeptList()){
            if(dep.getDept_id()==dept_id){
                departmentdb.getDeptList().remove(dep);
                break;
            }
        }
    };
}
