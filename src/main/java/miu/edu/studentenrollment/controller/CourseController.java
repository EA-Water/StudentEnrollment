package miu.edu.studentenrollment.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.studentenrollment.domain.Course;
import miu.edu.studentenrollment.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;

	@PostMapping("/create/course")
	public Course createCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@GetMapping("/view/courses")
	public List<Course> getAllCourses() {
		return courseService.courses();
	}

	@PutMapping("/update/course/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Course findCourse = courseService.getOneCourse(id);
		try {
			findCourse = course;
			findCourse.setId(id);
			courseService.updateCourse(findCourse);
		} catch (Exception e) {

		}
		return findCourse;
	
	}

	@DeleteMapping("/remove/course/{id}")
	public void removeCourse(@PathVariable Long id) {
		Course findCourse = courseService.getOneCourse(id);
		courseService.deleteCourse(findCourse);
	}
}
