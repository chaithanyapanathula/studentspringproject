package com.example.demo.studentcontroller;

import com.example.demo.dto.Department;
import com.example.demo.dto.Student;
import com.example.demo.service.DeptService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService ds;
    StudentService ser;

//    @GetMapping("/Students")
//    public List<Department> getAllDept(){
//        for(Student s:ser.getAllStudents()){
//            for(Department d:ds.getAllDepartents())
//            if(s.getBranch().equals(d.getDept_name())){
//                return (List<Department>) d;
//            }
//        }
//        return null;
//    }
}
