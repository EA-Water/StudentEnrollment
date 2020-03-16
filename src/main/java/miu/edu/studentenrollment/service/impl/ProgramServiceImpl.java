package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.StudentProgram;
import miu.edu.studentenrollment.repository.IProgramRepo;
import miu.edu.studentenrollment.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements IProgramService {

    @Autowired
    private IProgramRepo programRepo;

    @Override
    public StudentProgram createStudentProgram(StudentProgram studentProgram) {
        return null;
    }

    @Override
    public List<StudentProgram> viewAllStudentProgram() {
        return null;
    }
}
