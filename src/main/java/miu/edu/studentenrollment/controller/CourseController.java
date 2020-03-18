package miu.edu.studentenrollment.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.studentenrollment.domain.Course;
import miu.edu.studentenrollment.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;

	@PostMapping("/")
	public List<Course> createCourse(@RequestBody Course course) {
		courseService.createCourse(course);
		List<Course> courses = courseService.getAllCourses();
		return courses;
	}

	@GetMapping("/")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Course findCourse = courseService.getCourseById(id);
		try {
			findCourse = course;
			findCourse.setId(id);
			courseService.updateCourse(findCourse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findCourse;
	
	}

	@DeleteMapping("/{id}")
	public String removeCourse(@PathVariable Long id) {
		Course findCourse = courseService.getCourseById(id);
		return courseService.removeCourse(findCourse);
	}
}
