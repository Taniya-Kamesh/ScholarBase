package com.college.studentmanagement.app;
import com.college.studentmanagement.service.StudentService;
import com.college.studentmanagement.model.Student;
import com.college.studentmanagement.dao.StudentDao;

import java.sql.Date;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static final Scanner scan=new Scanner(System.in);
    public static final StudentService studentservice=new StudentService(new StudentDao());
    public static void main(String[] args) {
        while (true) {
            System.out.println("------------STUDENT MANAGEMENT SOFTWARE-----------");
            System.out.println("---------LOGIN-----------");
            boolean log = login();
            if (!log) break;
            else {
                printMenu();
                try {
                    int choice = Integer.parseInt(scan.nextLine());
                    switch (choice) {
                        case 1 -> addStudent();
                        case 2 -> getAllStudents();
                        case 3 -> getStudentById();
                        case 4 -> updateStudent();
                        case 5 -> deleteStudent();
                        case 6 -> {
                            System.out.println("GoodBye!");
                            return;
                        }
                        default -> System.out.println("Invalid option");

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                } catch (SQLException | IllegalArgumentException e) {
                    System.out.println("Error" + e.getMessage());
                }
            }
        }
    }
    public static void printMenu(){
        System.out.println("---------WELCOME---------");
        System.out.println("To add student,enter 1");
        System.out.println("To get all student details,enter 2");
        System.out.println("To get a student details,enter 3");
        System.out.println("To update a student's details, enter 4");
        System.out.println("To delete a students's details,enter 5");
        System.out.println("To close the software, enter 6");
    }

    public static void addStudent() throws SQLException {
        String name=readText("Name: ");
        String email=readText("Email: ");
        String ph_no=readText("Phone no: ");
        int age=readInt("Age: ");
        String course=readText("Course: ");
        Student student=new Student(name,email,ph_no,age,course, Date.valueOf(LocalDate.now()));
        studentservice.addStudent(student);
        System.out.println("Student added successfully");

    }
    public static void getAllStudents() throws SQLException{
        List<Student> students=studentservice.getAllStudents();
        if(students.isEmpty()){
            System.out.println("Students details not found");
            return;
        }
           for(Student s:students){
                System.out.println(s);
            }


    }
    public static void getStudentById() throws SQLException{
      int id=readInt("id: ");
      Student student=studentservice.getStudentById(id);
      if(student==null){
          System.out.println("Student not found");
      }
      else{
          System.out.println(student);
      }

    }
    public static void updateStudent() throws SQLException {
        int id=readInt("id: ");
        Student existing= studentservice.getStudentById(id);
        if(existing==null) {
            System.out.println("Student not found");
            return;
        }
        else{
            String name=readText("Name: ");
            String email=readText("Email: ");
            String ph_no=readText("Phone no: ");
            int age=readInt("Age: ");
            String course=readText("Course: ");
            Student student=new Student(id,name,email,ph_no,age,course,existing.getEnrollDate());
            boolean updated=studentservice.updateById(student);
            if(updated) System.out.println("Details updated successfully!");
            else System.out.println("try again!");
        }

    }
    public static void deleteStudent() throws SQLException {
        int id=readInt("id: ");
        System.out.println("Are you sure?, enter Y or y for yes");
        String confirm=scan.nextLine();
        if("y".equalsIgnoreCase(confirm)){
            boolean delete= studentservice.deleteStudent(id);
            if(delete){
               System.out.println("Deleted successfully");
            }else{
                System.out.println("Not deleted");
            }
        }else{
            System.out.println("Deletion halted");
            return;
        }

    }
    public static String readText(String message){
        System.out.println(message);
        return scan.nextLine().trim();
    }
    public static int readInt(String message){
        while(true) {
           try{
               return Integer.parseInt(readText(message));
           }
           catch(Exception e){
               System.out.println("Enter valid number");
           }
        }
    }
    public static boolean login(){
        String log_user=readText("Username: ");
        String log_pass=readText("Password: ");
        if(studentservice.user.equals(log_user)&&studentservice.password.equals(log_pass)){
            return true;
        }else{
            return false;
        }
    }

}
