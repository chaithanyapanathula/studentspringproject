package com.example.demo.studentcontroller;

import com.example.demo.dto.Student;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.DeptService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService ss;
    DeptService ds;

    @GetMapping("/Students")
    public List<Student> getAllStudent(@RequestParam String db){
        switch(db){
            case "p":
                return ss.getpgstudents();
            case "r":
                return ss.getredisstudents();
            case "m":
                return ss.getMgstudents();
            default:
                return ss.getAllStudents();
        }
    }

    /*@GetMapping("/Student/{id}")
    public Student getStudent(@PathVariable Integer id){
        return ss.getStudent(id);
    }*/

    @GetMapping("/Student")
    public Student getStudent(@RequestParam(required = true) Integer id){
        return ss.getStudent(id);
    }



    @PutMapping("/St")
    public void putStudent(@RequestBody @Valid Student student,@RequestParam String db){
        switch(db) {
            case "p":
                ss.updatingStudent(student);
                break;
            case "r":
                ss.updatingStudent(student);
                break;
            case "m":
                ss.updatingStudent(student);
                break;
            default:
                ss.updatingStudent(student);
        }
    }
    @PostMapping("/Stud")
    public void addStudent(@RequestBody @Valid Student student,@RequestParam String db){
        switch(db){
            case "p":
                ss.addpgStudent(student);
                break;
            case "r":
                ss.addredisStudent(student);
                break;
            case "m":
                ss.addMgstudent(student);
                break;
            default:
                ss.addStudent(student);

        }
    }

    @DeleteMapping("/S")
    public void deleteStudent(@RequestParam(value ="id") Integer id){

            ss.DeleteStudent(id);

    }
}
