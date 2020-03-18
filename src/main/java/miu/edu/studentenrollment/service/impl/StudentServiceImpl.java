package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.repository.StudentRepo;
import miu.edu.studentenrollment.service.EntryService;
import miu.edu.studentenrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private EntryService entryService;

    public Student addStudent(Student student) {
//        try {
//            Entry entry = entryService.findEntry(student.getIdSaving());
//            student.setEntry(entry);
//        }catch (Exception e){}
        return studentRepo.save(student);
    }

    public void removeStudentByID(Long studentID) {
        studentRepo.deleteById(studentID);
    }

    public Student viewStudent(Long studentID) {
        return studentRepo.getOne(studentID);
    }

    public List<Student> viewAllStudents() {
        return studentRepo.findAll();
    }

    public Long countStudents() {
        return studentRepo.count();
    }
}
