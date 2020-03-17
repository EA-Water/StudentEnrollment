package miu.edu.studentenrollment.service;


import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.domain.Student;

import java.util.List;

public interface EnrollmentService {

    Enrollment createEnrollment(Enrollment enrollment);
    List<Enrollment> viewEnrollment();
    List<Enrollment> getEnrollmentByStudent(Student student);
    List<Enrollment> getEnrollmentBySection(Section section);

}
