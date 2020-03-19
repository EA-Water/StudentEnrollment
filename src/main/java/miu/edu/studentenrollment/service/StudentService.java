package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.*;

import java.util.List;

public interface StudentService {

	Student createStudent(Student student);

	void removeStudent(Long studentID);

	Student getStudent(Long studentID);

	List<Student> getAllStudents();

	Long countStudents();

    Address getMailingAddress(Long studentID);

	Address getHomeAddress(Long studentID);

	Entry getEntry(Long studentID);

	List<Enrollment> getAllEnrollments(Long studentID);
}
