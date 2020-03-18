package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.service.EnrollmentService;
import miu.edu.studentenrollment.util.CustomError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/")
    public ResponseEntity<?>createEnrollment(@RequestBody Enrollment enrollment){
        try{
           Enrollment savedEnrollment = enrollmentService.createEnrollment(enrollment);
           return new ResponseEntity<Enrollment>(savedEnrollment,HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> viewEnrollment(){

        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        if (enrollments.isEmpty()){
            return new ResponseEntity<List<Enrollment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Enrollment>>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public List<Enrollment> viewStudentEnrollment(@PathVariable Long studentId){
        return null;
    }

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/{id}")
    public ResponseEntity<?> updateEnrollment(@PathVariable("id") long id, @RequestBody Enrollment enrollment) {
    	Enrollment currentEnrollment = enrollmentService.getEnrollmentById(id);
        if (currentEnrollment == null) {
            return new ResponseEntity(new CustomError("Unable to upate. Enrollment with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentEnrollment.setSection(enrollment.getSection());
        currentEnrollment.setStudent(enrollment.getStudent());
        enrollmentService.createEnrollment(currentEnrollment);
        return new ResponseEntity<Enrollment>(currentEnrollment, HttpStatus.OK);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable("id") long id) {
 
    	Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment == null) {
            return new ResponseEntity(new CustomError("Unable to delete. Enrollment with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        enrollmentService.deleteEnrollment(id);
        return new ResponseEntity<Enrollment>(HttpStatus.NO_CONTENT);
    }

}
