package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.repository.EnrollmentRepo;
import miu.edu.studentenrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepo.save(enrollment);
    }

    @Override
    public List<Enrollment> viewEnrollment() {
        return enrollmentRepo.findAll();
    }

    @Override
    public List<Enrollment> getEnrollmentByStudent(Student student) {
        return enrollmentRepo.findByStudent(student);
    }

    @Override
    public List<Enrollment> getEnrollmentBySection(Section section) {
        return enrollmentRepo.findBySection(section);
    }
}
