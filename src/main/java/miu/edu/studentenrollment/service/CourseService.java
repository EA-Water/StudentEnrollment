package miu.edu.studentenrollment.service;

import java.util.List;
import java.util.Optional;

import miu.edu.studentenrollment.domain.Course;

public interface CourseService {
	public Course saveCourse(Course course);
	public List<Course> courses();
	public Course updateCourse(Course course) throws Exception;
	public void deleteCourse(Course course);
	public Course getOneCourse(Long id);
}
