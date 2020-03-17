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
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.service.FaculityService;

@RestController
@CrossOrigin
public class FacultyController {

	@Autowired
	private FaculityService facultyService;

	@PostMapping("/create/faculty")
	public void createFaculity(@RequestBody Faculty faculity) {
		facultyService.addFaculity(faculity);
	}

	@DeleteMapping("/remove/faculty/{id}")
	public void removeFaculity(@PathVariable Long id) {

		Faculty findFaculty = facultyService.getOneFaculty(id);
		facultyService.removeFaculity(findFaculty);
	}

	@PutMapping("/update/faculty/{id}")
	public void updateFaculity(@PathVariable Long id, @RequestBody Faculty faculty) {

		Faculty findFaculty = facultyService.getOneFaculty(id);
		try {
			faculty.setId(id);
			facultyService.updateFaculity(faculty);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@GetMapping("/view/faculty")
	public List<Faculty> getAllFaculity(Faculty faculity) {
		return facultyService.getAllFaculity();
	}

}
