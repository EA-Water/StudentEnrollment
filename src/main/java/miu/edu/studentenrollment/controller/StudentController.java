package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.service.EntryService;
import miu.edu.studentenrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private EntryService entryService;

    @PostMapping("/create/student/{entryID}")
    public Student addStudent(@RequestBody Student student, @PathVariable long entryID) throws Exception {
        student.setEntry(entryService.findEntry(entryID));
//        System.out.println(student.getEntry());
        return studentService.addStudent(student);
    }

    @DeleteMapping("/remove/student/{studentID}")
    public String removeStudentByID(@PathVariable Long studentID){
        studentService.removeStudentByID(studentID);
        return "Delete Successful";
    }

    @PutMapping("/update/student/{studentID}")
    public Student updateStudent(@PathVariable Long studentID, @RequestBody Student student){
        Student stu = viewStudent(studentID);
        stu = student;
        stu.setId(studentID);
        return studentService.addStudent(stu);
    }

    @GetMapping("/count/students")
    public Long countStudents(){
        return studentService.countStudents();
    }

    @GetMapping("/view/student/{studentID}")
    public Student viewStudent(@PathVariable Long studentID){
        return studentService.viewStudent(studentID);
    }

    @GetMapping("/view/allStudents")
    public List<Student> viewAllStudents(){
        return studentService.viewAllStudents();
    }

}