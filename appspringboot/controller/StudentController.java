package com.start.appspringboot.controller;

import com.start.appspringboot.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

List<Student> studentList = new ArrayList<>(Arrays.asList(
        new Student(1,"Avazbek","+998 932 03 24","Murataliyev"),
        new Student(2,"Hello","+998 932 00 00","Hi"),
        new Student(3,"Nice","+998 xxx xx xx","Good"),
        new Student(4,"Great","+xxx 111 22 33","Wonderful"),
        new Student(5,"Not bad","+222 xxx 22 11","Really Good")

));
    //READ this list
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudentList(){

        return studentList;
    }

    // Get one student
    @RequestMapping(value = "/student/{id}" , method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id){
        for (Student student : studentList) {
            if (student.getId()==id)
                return student;
        }
        return new Student();
    }

}
