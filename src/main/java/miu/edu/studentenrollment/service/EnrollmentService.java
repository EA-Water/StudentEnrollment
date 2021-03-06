package miu.edu.studentenrollment.service;


import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.domain.Student;

import java.util.List;

public interface EnrollmentService {

    Enrollment createEnrollment(Enrollment enrollment) throws Exception;
    List<Enrollment> getAllEnrollments();
    List<Enrollment> getEnrollmentByStudent(Student student);
    List<Enrollment> getEnrollmentBySection(Section section);
    boolean isEnrollmentExit(Enrollment Enrollment);
    Enrollment getEnrollmentById(long id);
    void deleteEnrollment(long id);

}
