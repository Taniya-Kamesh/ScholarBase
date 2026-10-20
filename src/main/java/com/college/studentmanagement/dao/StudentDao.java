package com.college.studentmanagement.dao;

import com.college.studentmanagement.model.Student;
import com.college.studentmanagement.util.DataBaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public void addStudent(Student student) throws SQLException {
        String sql = """
                INSERT INTO students(name,email,ph_no,age,course,enroll_date)
                values(?,?,?,?,?,?)
                """;
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPh_no());
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getCourse());
            statement.setDate(6, student.getEnrollDate());

            statement.executeUpdate();
        }
    }

    public  List<Student> getAllStudents() throws SQLException{
        List<Student> students=new ArrayList<>();
        String sql="SELECT * FROM students";
        try(Connection connection=DataBaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery()
        ){
            while(resultSet.next()) {
                students.add(mapRowToStudent(resultSet));
            }
        }
        return students;
    }
     public Student getStudentById(int id) throws SQLException{
        String sql="SELECT * FROM students where id=? ";
        try(Connection connection=DataBaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
        ){
            statement.setInt(1,id);
            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    return mapRowToStudent(resultSet);
                }
            }
        }return null;
     }

     public boolean updateById(Student student) throws SQLException{
        String sql= """
                UPDATE students
                SET name=?,email=?,ph_no=?,age=?,course=?,enroll_date=?
                WHERE id=?
                """;
        try(Connection connection=DataBaseConnection.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)
        ){
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setString(3,student.getPh_no());
            statement.setInt(4,student.getAge());
            statement.setString(5,student.getCourse());
            statement.setDate(6,student.getEnrollDate());
            statement.setInt(7,student.getId());

            return statement.executeUpdate()>0;
        }
     }
     public boolean deleteStudent(int id) throws SQLException{
        String sql="DELETE FROM students WHERE id=?";
        try(Connection connection= DataBaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)
        ){
            statement.setInt(1,id);

            return statement.executeUpdate()>0;
        }

     }

     public Student mapRowToStudent(ResultSet resultSet)  throws SQLException{
        return new Student(
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("ph_no"),
                resultSet.getInt("id"),
                resultSet.getString("course"),
                resultSet.getDate("enroll_date")
                );
     }

}
