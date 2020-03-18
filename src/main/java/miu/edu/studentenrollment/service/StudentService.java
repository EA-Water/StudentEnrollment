package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.domain.Student;

import java.util.List;

public interface StudentService {

	public Student createStudent(Student student);

	public void removeStudent(Long studentID);

	public Student getStudent(Long studentID);

	public List<Student> getAllStudents();

	public Long countStudents();
}
