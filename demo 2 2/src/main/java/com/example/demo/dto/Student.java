package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Student implements Serializable {
    @NotNull
    public Integer id;

    @NotBlank(message="Student name should not be null")
    public String pname,lname,branch;
    public Student(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public Student(Integer id, String pname, String lname, String branch){
        this.id=id;
        this.pname=pname;
        this.lname=lname;
        this.branch=branch;
    }

    /*@Override
    public String toString() {
        return "Student{" + "id=" + id + ", pname='" + pname + '\'' + ", lname='" + lname + '\'' + ", branch='" + branch + '\'' + '}';
    }*/
}
