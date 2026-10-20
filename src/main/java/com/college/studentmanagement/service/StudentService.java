package com.college.studentmanagement.service;

import com.college.studentmanagement.dao.StudentDao;
import com.college.studentmanagement.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final  StudentDao studentdao;
    public final String user="Office";
    public final String password="collegeAF";
    public StudentService(StudentDao studentdao){
        this.studentdao=studentdao;
    }
    public void addStudent(Student student) throws SQLException {
         validate(student);
         studentdao.addStudent(student);
    }
    public List<Student> getAllStudents() throws SQLException {
        return studentdao.getAllStudents();
    }

    public Student getStudentById(int id) throws SQLException{
        return studentdao.getStudentById(id);

    }
    public boolean updateById(Student student) throws SQLException{
        validate(student);
        return studentdao.updateById(student);
    }
    public boolean deleteStudent(int id) throws SQLException{
        if(id<=0){
            throw new IllegalArgumentException("Id must be positive");
        }
        return studentdao.deleteStudent(id);
    }
    public static void validate(Student student) throws SQLException{
      if(student.getName()==null||student.getName().isBlank()) {
          throw new  IllegalArgumentException("Name is required");
      }
      if(student.getEmail()==null||student.getEmail().isBlank()){
          throw new IllegalArgumentException("Email is required");
      }
      if(student.getPh_no()==null||student.getPh_no().isBlank()){
          throw new IllegalArgumentException("Phone number is required");
      }
      if(student.getAge()<=15&&student.getAge()>=110){
          throw new IllegalArgumentException("Invalid age");
      }
    }
}
