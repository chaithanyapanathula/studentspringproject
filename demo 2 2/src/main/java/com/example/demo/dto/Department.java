package com.example.demo.dto;

public class Department {
    private int dept_id;
    private String dept_name,dept_hod;
    public Department(){

    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_hod() {
        return dept_hod;
    }

    public void setDept_hod(String dept_hod) {
        this.dept_hod = dept_hod;
    }

    public Department(int dept_id,String dept_name,String dept_hod){
        this.dept_id=dept_id;
        this.dept_name=dept_name;
        this.dept_hod=dept_hod;
    }
}

