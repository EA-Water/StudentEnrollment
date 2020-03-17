package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public void removeStudentByID(Long studentID) {
        studentRepo.deleteById(studentID);
    }

    public Student updateStudentByID(Student student) {
        return studentRepo.save(student);
    }

    public Student viewStudent(Long studentID) {
        return studentRepo.getOne(studentID);
    }

    public List<Student> viewAllStudents() {
        return studentRepo.findAll();
    }

    public Long countStudents() {
        return studentRepo.count();
    }
}
