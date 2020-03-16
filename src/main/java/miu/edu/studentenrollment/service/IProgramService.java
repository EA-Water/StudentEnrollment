package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.StudentProgram;

import java.util.List;

public interface IProgramService {

    StudentProgram createStudentProgram(StudentProgram studentProgram);

    List<StudentProgram> viewAllStudentProgram();

}
