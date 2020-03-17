package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/create/enrollment")
    public List<Enrollment> createEnrollment(@RequestBody Enrollment enrollment){
        List<Enrollment> enrollments= new ArrayList<>();
        try{
           Enrollment en = enrollmentService.createEnrollment(enrollment);
           enrollments = enrollmentService.viewEnrollment();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return enrollments;
    }

    @GetMapping("/view/enrollments")
    public List<Enrollment> viewEnrollment(){
        return enrollmentService.viewEnrollment();
    }

    @GetMapping("/view/studentenrollments/{studentId}")
    public List<Enrollment> viewStudentEnrollment(@PathVariable Long studentId){
        return null;
    }

    @GetMapping("/view/sectionenrollments/{sectionId}")
    public List<Enrollment> viewSectionEnrollment(@PathVariable Long sectionId){
        return null;
    }


}
