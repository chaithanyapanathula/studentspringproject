package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentMongoRepository;
import com.example.demo.repository.StudentRedisRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.Studentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    Studentdb studentdb;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        for (StudentEntity student : studentRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        for (Student student : studentRedisRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        return s;
    }

    @Override
    public Student getStudent(Integer id) {
        Student o = new Student();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            if (student.getId() == id) {
                o.setId(student.getId());
                o.setPname(student.getPname());
                o.setLname(student.getLname());
                o.setBranch(student.getBranch());
                break;
            }
        }
        return o;
    }

    @Override
    public void addStudent(Student student) {
        StudentEntity se = new StudentEntity();
        se.setId(student.getId());
        se.setBranch(student.getBranch());
        se.setPname(student.getPname());
        se.setLname(student.getLname());
        studentMongoRepository.save(new StudentEntity(se.getId(), se.getPname(), se.getLname(), se.getBranch()));

    }

    @Override
    public Student updatingStudent(Student student) {
        for (StudentEntity studentEntity : studentMongoRepository.findAll()) {
            if (studentEntity.getId() == student.getId()) {
                studentEntity.setPname(student.getPname());
                studentEntity.setBranch(student.getBranch());
                studentEntity.setLname(student.getLname());
                studentMongoRepository.save(studentEntity);

            }
        }
        return student;
    }

    @Override
    public void DeleteStudent(Integer id) {
        for (StudentEntity stu : studentMongoRepository.findAll()) {
            if (stu.getId() == id) {
                studentMongoRepository.deleteById(id);
                break;
            }
        }

    }

    @Override
    public void addpgStudent(Student student) {
        StudentEntity se = new StudentEntity();
        se.setId(student.getId());
        se.setBranch(student.getBranch());
        se.setPname(student.getPname());
        se.setLname(student.getLname());
        studentRepository.save(new StudentEntity(se.getId(), se.getPname(), se.getLname(), se.getBranch()));
    }

    @Override
    public void addMgstudent(Student student) {
        StudentEntity se = new StudentEntity();
        se.setId(student.getId());
        se.setBranch(student.getBranch());
        se.setPname(student.getPname());
        se.setLname(student.getLname());
        studentMongoRepository.save(new StudentEntity(se.getId(), se.getPname(), se.getLname(), se.getBranch()));
    }

    @Override
    public void addredisStudent(Student student) {
        studentRedisRepository.addOne(student);

    }

    @Override
    public List<Student> getpgstudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        return s;
    }

    @Override
    public List<Student> getMgstudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        return s;
    }

    @Override
    public List<Student> getredisstudents() {
        return studentRedisRepository.findAll();
    }

    @Override
    public List<Student> getlsStudent() {
        return studentdb.getstudentList();
    }

    @Override
    public void addlSStudent(Student student) {
        studentdb.getstudentList().add(new Student(student.getId(), student.getPname(), student.getLname(), student.getBranch()));

    }

    @Override
    public Student updatelStudent(Student student) {
        for (Student stu : studentdb.getstudentList()) {
            if (stu.getId() == student.getId()) {
                stu.setLname(student.getLname());
            }
        }
        return student;
    }

    @Override
    public Student updatepgStudent(Student student) {
        Student so = new Student();
        for (StudentEntity se : studentRepository.findAll()) {
            if (se.getId() == student.getId()) {
                se.setPname(student.getPname());
                studentRepository.save(new StudentEntity(se.getId(), se.getPname(), se.getLname(), se.getBranch()));
                so.setId(se.getId());
                so.setBranch(se.getBranch());
                so.setPname(se.getPname());
                so.setLname(se.getLname());
            }
        }
        return so;
    }
}



    /*@Override
    public List<Student> getAllStudents(){
        return studentRedisRepository.findAll();
    }

    @Override
    public void addStudent(Student student){
        studentRedisRepository.addOne(student);
    }

    @Override
    public Student getStudent(Integer id){
        return studentRedisRepository.findOne(id);
    }


    @Override
    public void DeleteStudent(Integer id){
        studentRedisRepository.deleteOne(id);
    }

    @Override
    public Student updatingStudent(Student student){
        return studentRedisRepository.updatingStudent(student);
    }*/

    /* Postgres
    @Override
    public List<Student> getAllStudents(){
        List<Student> s=new ArrayList<>();
        for(StudentEntity student:studentRepository.findAll()){
            Student s1=new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        return s;
    }

    @Override
    public void addStudent(Student student){
        StudentEntity se=new StudentEntity();
        se.setId(student.getId());
        se.setBranch(student.getBranch());
        se.setPname(student.getPname());
        se.setLname(student.getLname());
        studentRepository.save(new StudentEntity(se.getId(),se.getPname(),se.getLname(),se.getBranch()));
    }

    @Override
    public Student getStudent(Integer id){
        Student o=new Student();
        for(StudentEntity student:studentRepository.findAll()){
            if(student.getId()==id){
                o.setId(student.getId());
                o.setPname(student.getPname());
                o.setLname(student.getLname());
                o.setBranch(student.getBranch());
            }
        }
        return o;
    }
    @Override
    public void DeleteStudent(Integer id){
        for(StudentEntity stu:studentRepository.findAll()){
            if(stu.getId()==id){
                studentRepository.deleteById(id);
                break;
            }
        }
    }
*/
   /* @Override
    public Student updatingStudent(Student student){
        Student so=new Student();
        for(StudentEntity se:studentRepository.findAll()){
            if(se.getId()==student.getId()){
                se.setPname(student.getPname());
                studentRepository.save(new StudentEntity(se.getId(),se.getPname(),se.getLname(),se.getBranch()));
                so.setId(se.getId());
                so.setBranch(se.getBranch());
                so.setPname(se.getPname());
                so.setLname(se.getLname());
            }
        }
        return so;
    }*/


    /* linked list
    @Override
    public List<Student> getAllStudents(){
        return studentdb.getstudentList();
    }

    @Override
    public Student getStudent(Integer id,String name){
        for(Student student:studentdb.getstudentList()){
            if(student.getId()==id && student.getPname().equals(name)){
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student){
        studentdb.getstudentList().add(new Student(student.getId(),student.getPname(),student.getLname(),student.getBranch()));

    }

    @Override
    public Student updatingStudent(Student student){
        for(Student stu:studentdb.getstudentList()){
            if(stu.getId()==student.getId()) {
                stu.setLname(student.getLname());
            }
        }
        return student;
    }

    @Override
    public void DeleteStudent(Integer id){
        for(Student stu:studentdb.getstudentList()){
            if(stu.getId()==id){
                studentdb.getstudentList().remove(stu);
                break;
            }
        }

    }*/

