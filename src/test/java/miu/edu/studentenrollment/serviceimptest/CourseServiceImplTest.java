package miu.edu.studentenrollment.serviceimptest;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import miu.edu.studentenrollment.controller.CourseController;
import miu.edu.studentenrollment.domain.Course;
import miu.edu.studentenrollment.repository.CourseRepository;
import miu.edu.studentenrollment.service.CourseService;
import miu.edu.studentenrollment.service.impl.CourseServiceImpl;

@DisplayName("Course Service Test Cases")
public class CourseServiceImplTest {
//	@InjectMocks
//	CourseController courseController;
	
	//MockMvc mockMvc;
	
	@InjectMocks
	CourseServiceImpl courseService;
	
	@Mock
	CourseRepository courseRepository;
	
	Course course1 = new Course();
	Course course2 = new Course();
	List<Course> courses = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		course1.setId(1L);
		course1.setCourseName("WAA");
		course1.setCourseCode("CS522");
		course1.setDescription("programming");
		courses.add(course1);
		courses.add(course2);
	}
	@Test
	void testCreateCourse() {
		try {
			courseService.createCourse(course1);
			verify(courseRepository, times(1)).save(course1);
			
		}catch (Exception e) {
            e.printStackTrace();
	}
	}
	@Test
	void testgetAllCourses() throws Exception  {
		when(courseRepository.findAll()).thenReturn(courses);
		assertEquals(2, courseService.getAllCourses().size());
		
	}
	@Test
	void UpdateCourse() throws Exception  {
		try {
			courseService.updateCourse(course1);
			verify(courseRepository, times(1)).save(course1);
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void testDeleteCourse() throws Exception{
		try {
			courseService.removeCourse(course2);
			verify(courseRepository, times(1)).delete(course2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	void testGetCourseById() throws Exception{
		try {
			when(courseRepository.getOne(1L)).thenReturn(course1);
			assertEquals(course1, courseService.getCourseById(1L));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
