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

import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.service.FacultyService;

@RestController
@CrossOrigin
@RequestMapping("/faculties")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@PostMapping("/")
	public void createFaculity(@RequestBody Faculty faculity) {
		facultyService.createFaculity(faculity);
	}

	@DeleteMapping("/{id}")
	public void removeFaculity(@PathVariable Long id) {

		Faculty findFaculty = facultyService.getFacultyById(id);
		facultyService.removeFaculity(findFaculty);
	}

	@PutMapping("/{id}")
	public void updateFaculity(@PathVariable Long id, @RequestBody Faculty faculty) {

		try {
			faculty.setId(id);
			facultyService.updateFaculity(faculty);
		} catch (Exception e) {

		}
	}

	@GetMapping("/")
	public List<Faculty> getAllFaculity(Faculty faculity) {
		return facultyService.getAllFaculity();
	}

}
