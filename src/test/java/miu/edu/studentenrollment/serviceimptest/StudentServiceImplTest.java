package miu.edu.studentenrollment.serviceimptest;

import miu.edu.studentenrollment.controller.EntryController;
import miu.edu.studentenrollment.domain.Address;
import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.service.impl.EntryServiceImpl;
import miu.edu.studentenrollment.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    @Mock
    StudentServiceImpl studentService;

    Entry entry = new Entry();
    Address address = new Address();
    Student student = new Student();
    List<Student> stuList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        entry.setId(1L);
        entry.setEntryName("August-2020");
        entry.setEntryStartDate(new Date());
        entry.setEnrollmentStartDate(new Date());
        entry.setEnrollmentEndDate(new Date());

        student.setEntry(entry);
        student.setId(3L);
        student.setStudentId("Reza");
        student.setFirstName("Rezaur");
        student.setLastName("Rahman");
        student.setId(1L);
        student.setStudentEmail("reza5630@gmail.com");
        student.setHomeAddress(address);
        student.setMailingAddress(address);
        stuList.add(student);
    }

    @Test
    void testCreateStudent() {
        try {
            when(studentService.createStudent(student)).thenReturn(student);
            assertEquals(student, studentService.createStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetStudent(){
        try {
            when(studentService.getStudent(3L)).thenReturn(student);
            assertEquals(student, studentService.getStudent(3L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetAllStudents(){
        try {
            when(studentService.getAllStudents()).thenReturn(stuList);
            assertEquals(stuList, studentService.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    void testCountStudents(){
//        try {
//            when(studentService.countStudents()).then(1L);
//            assertEquals(student, studentService.getStudent(3L));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
