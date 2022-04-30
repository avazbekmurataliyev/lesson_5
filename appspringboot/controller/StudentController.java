package com.start.appspringboot.controller;

import com.start.appspringboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

List<Student> studentList = new ArrayList<>(Arrays.asList(
        new Student(1,"Avazbek","+998939320324","Spring"),
        new Student(2,"Hello","+9989320000","Hi see"),
        new Student(3,"Nice","+998931112233","History"),
        new Student(4,"Great","+998934442233","Wonderful chef"),
        new Student(5,"Not bad","+998993332211","Driver course")

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
    //Add student
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String saveStudent(@RequestBody Student student){
        boolean check = false;
        for (Student student1 : studentList) {
            if (student1.getPhoneNumber().equals(student.getPhoneNumber())){
                check = true;
                break;
            }
        }

        if (!check){
            student.setId(studentList.get(studentList.size()-1).getId()+1);
            studentList.add(student);
            return "Student qo'shildi";
        }

        return "Boshqa raqam kiritilsin";
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String updateStudent(@PathVariable Integer id , @RequestBody Student student){
        boolean check = false ;
        for (Student student1 : studentList) {
            if (student1.getId() == id){
                for (Student student2 : studentList) {
                    if (student2.getPhoneNumber().equals(student.getPhoneNumber())) {
                        check = true;break;
                    }
                }
                if (!check){
                    student1.setName(student.getName());
                    student1.setCourseName(student.getCourseName());
                    student1.setPhoneNumber(student.getPhoneNumber());
                    return "Malumotlar o`zgartirildi";
                }
                return "Telefon raqam mavjud";
            }
        }

        return "bunday student mavjud emas";

    }

}
