package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Student;

import java.util.List;

public interface IStudentService {

    public Student createStudent(Student student);

    public List<Student> viewAllStudent();

    public Student findStudent(Long id);
}
