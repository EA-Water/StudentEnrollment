package miu.edu.studentenrollment.serviceimptest;

import miu.edu.studentenrollment.controller.EntryController;
import miu.edu.studentenrollment.domain.Address;
import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.repository.AddressRepo;
import miu.edu.studentenrollment.repository.OfferingRepository;
import miu.edu.studentenrollment.repository.StudentRepo;
import miu.edu.studentenrollment.service.impl.EntryServiceImpl;
import miu.edu.studentenrollment.service.impl.OfferingServiceImpl;
import miu.edu.studentenrollment.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {
    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentRepo studentRepository;

    @Mock
    AddressRepo addressRepository;

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
        student.setStudentEmail("reza5630@gmail.com");
        student.setHomeAddress(address);
        student.setMailingAddress(address);
        stuList.add(student);
    }

    @Test
    void testCreateStudent() {
        try {
            when(studentRepository.save(student)).thenReturn(student);
            when(addressRepository.findAll()).thenReturn(Collections.emptyList());
            assertEquals(student, studentService.createStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetStudent(){
        try {
            when(studentRepository.getOne(1L)).thenReturn(student);
            assertEquals(student, studentService.getStudent(1L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetAllStudents(){
        try {
            when(studentRepository.findAll()).thenReturn(stuList);
            assertEquals(stuList, studentService.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteOfferingTest()
    {
        try {
            studentService.removeStudent(1L);
            verify(studentRepository, times(1)).deleteById(1L);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
