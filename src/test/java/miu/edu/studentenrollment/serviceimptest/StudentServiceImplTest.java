package miu.edu.studentenrollment.serviceimptest;

import com.fasterxml.jackson.databind.ObjectMapper;
import miu.edu.studentenrollment.controller.EntryController;
import miu.edu.studentenrollment.domain.Address;
import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.domain.Student;
import miu.edu.studentenrollment.service.StudentService;
import miu.edu.studentenrollment.service.impl.EntryServiceImpl;
import miu.edu.studentenrollment.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    @InjectMocks
    EntryController entryController;

    MockMvc mockMvc;

    @Mock
    EntryServiceImpl entryService;

    @Mock
    StudentServiceImpl studentService;

    Entry entry = new Entry();
    Address address = new Address();
    Student student = new Student();

    @BeforeEach
    void setUp() throws Exception {
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
    }

    @Test
    void testAddStudent() {
        try {
            when(studentService.addStudent(student)).thenReturn(student);
            assertEquals(student, studentService.addStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testViewStudent(){
        try {
            when(studentService.viewStudent(3L)).thenReturn(student);
            assertEquals(student, studentService.viewStudent(3L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
