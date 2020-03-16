package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.repository.IStudentRepo;
import miu.edu.studentenrollment.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
     private IStudentRepo studentRepo;

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> viewAllStudent() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student findStudent(Long id) {
        return null;
    }
}
