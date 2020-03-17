package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.domain.Student;

import java.util.List;

public interface StudentService {

	public Student addStudent(Student student);

	public void removeStudentByID(Long studentID);

	public Student viewStudent(Long studentID);

	public List<Student> viewAllStudents();

	public Long countStudents();
}
