package com.college.studentmanagement.model;
import java.sql.Date;
public class Student {
    private int id;
    private String name;
    private String email;
    private String ph_no;
    private int age;
    private String course;
    private Date enroll_date;

    public Student(int id,String name,String email,String ph_no,int age,String course,Date enroll_date) {
        this.id = id;
        this.name=name;
        this.email=email;
        this.ph_no=ph_no;
        this.age=age;
        this.course=course;
        this.enroll_date=enroll_date;
    }
    public Student(String name,String email,String ph_no,int age,String course,Date enroll_date) {
        this.name=name;
        this.email=email;
        this.ph_no=ph_no;
        this.age=age;
        this.course=course;
        this.enroll_date=enroll_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getEnrollDate() {
        return enroll_date;
    }

    public void setEnrollDate(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", ph_no='" + ph_no + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", enroll_date=" + enroll_date +
                '}';
    }
}
