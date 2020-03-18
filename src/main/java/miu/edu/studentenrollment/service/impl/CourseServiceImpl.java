package miu.edu.studentenrollment.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import miu.edu.studentenrollment.domain.Course;
import miu.edu.studentenrollment.repository.CourseRepository;
import miu.edu.studentenrollment.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Course createCourse(@RequestBody Course course) {
		return courseRepo.save(course);	
	}

	@Override
	public List<Course> courses() {
		return courseRepo.findAll();
	}

	@Override
	public Course updateCourse(Course course) throws Exception {
		if(courseRepo.findById(course.getId()).get()==null) {
			throw new Exception("Something is wrong");
		}
		return courseRepo.save(course);
	}

	@Override
	public String removeCourse(Course course) {
		try {
			courseRepo.delete(course);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Course deleted successfully";
	}

	@Override
	public Course getCourseById(Long id) {
		return courseRepo.getOne(id);
	}

}
