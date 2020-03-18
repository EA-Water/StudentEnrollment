package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/")
    public Student createStudent(@RequestBody @Valid Student student)  {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{studentID}")
    public String removeStudent(@PathVariable Long studentID){
        studentService.removeStudent(studentID);
        return "Delete Successful";
    }

    @PutMapping("/{studentID}")
    public Student updateStudent(@PathVariable Long studentID, @RequestBody Student student){
        Student stu = getStudentById(studentID);
        stu = student;
        stu.setId(studentID);
        return studentService.createStudent(stu);
    }

    @GetMapping("/count")
    public Long countStudents(){
        return studentService.countStudents();
    }

    @GetMapping("/{studentID}")
    public Student getStudentById(@PathVariable Long studentID){
        return studentService.getStudent(studentID);
    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

}
