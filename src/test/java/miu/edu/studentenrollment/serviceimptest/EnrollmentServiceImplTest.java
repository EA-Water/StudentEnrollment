package miu.edu.studentenrollment.serviceimptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.repository.EnrollmentRepo;
import miu.edu.studentenrollment.service.impl.EnrollmentServiceImpl;

public class EnrollmentServiceImplTest {

	@InjectMocks
	EnrollmentServiceImpl enrollmentService;
	
	@Mock
	EnrollmentRepo enrollmentRepository;
	
	Enrollment enrollment = new Enrollment();
	Enrollment enrollment2 = new Enrollment();
	List<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		enrollment.setId(1L);
		enrollment2.setId(2L);
		enrollments.add(enrollment);
		enrollments.add(enrollment2);
	}
	
	@Test
	void getEnrollmentByIdTest()
	{
		try {
			when(enrollmentRepository.getOne(2L)).thenReturn(enrollment2);
			Enrollment result = enrollmentService.getEnrollmentById(2L);
			assertEquals(enrollment2, result);
		
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void viewEnrollmentTest()
	{
		try {
			when(enrollmentRepository.findAll()).thenReturn(enrollments);
			assertEquals(2, enrollmentService.getEnrollments().size());
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void createEnrollmentTest()
	{
		try {
			enrollmentService.createEnrollment(enrollment);
	        verify(enrollmentRepository, times(1)).save(enrollment);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void isEnrollmentExit()
	{
		try {
			
			
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void updateEnrollmentTest()
	{
		try {
			enrollmentService.createEnrollment(enrollment);
	        verify(enrollmentRepository, times(1)).save(enrollment);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void deleteEnrollmentTest()
	{
		try {
			enrollmentService.deleteEnrollment(1L);
	        verify(enrollmentRepository, times(1)).deleteById(1L);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void getEnrollmentByStudentTest()
	{
		try {
			
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void getEnrollmentBySectionTest()
	{
		try {
			
		}catch (Exception e) {
            e.printStackTrace();
        }
	}

}
