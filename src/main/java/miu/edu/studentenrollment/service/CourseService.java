package miu.edu.studentenrollment.service;

import java.util.List;
import java.util.Optional;

import miu.edu.studentenrollment.domain.Course;

public interface CourseService {
	public Course createCourse(Course course);
	public List<Course> getAllCourses();
	public Course updateCourse(Course course) throws Exception;
	public String removeCourse(Course course);
	public Course getCourseById(Long id);
}
