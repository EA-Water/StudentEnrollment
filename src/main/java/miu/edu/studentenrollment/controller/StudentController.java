package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/student/view")
    public List<Student> viewAllStudent() {
        try {
            return studentService.viewAllStudent();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/welcome")
    public String testSecurity(){
        return "Hey There I am working";
    }
}
