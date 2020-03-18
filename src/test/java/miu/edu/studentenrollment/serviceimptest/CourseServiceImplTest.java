package miu.edu.studentenrollment.serviceimptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import miu.edu.studentenrollment.service.CourseService;

@DisplayName("Course Service Test Cases")
public class CourseServiceImplTest {
//	@InjectMocks
//	CourseController courseController;
	
	//MockMvc mockMvc;
	
	@Mock
	CourseService courseService;
	
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
	}
	@Test
	void testSaveCourse() {
		try {
			when(courseService.saveCourse(course1)).thenReturn(course1);
			assertEquals(course1, courseService.saveCourse(course1));
			
		}catch (Exception e) {
            e.printStackTrace();
	}
	}
	@Test
	void testCourses() throws Exception  {
		when(courseService.courses()).thenReturn(courses);
		assertEquals(1, courseService.courses().size());
		
	}
	@Test
	void UpdateCourse() throws Exception  {
		when(courseService.updateCourse(course1)).thenReturn(course1);
		assertEquals(course1, courseService.updateCourse(course1));
	}
	
	void testDeleteCourse() throws Exception{
		when(courseService.removeCourse(course1)).thenReturn("Course deleted successfully");
		assertEquals("Course deleted successfully", courseService.removeCourse(course1));
		
	}
	@Test
	void testGetOneCourse() throws Exception{
		when(courseService.getCourseById(1L)).thenReturn(course1);
		assertEquals(course1, courseService.getCourseById(1L));
	}
}
