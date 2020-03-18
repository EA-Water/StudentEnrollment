package miu.edu.studentenrollment.service;

import java.util.List;

import miu.edu.studentenrollment.domain.Faculty;

public interface FacultyService {

	public Faculty addFaculity(Faculty faculity);

	public String removeFaculity(Faculty faculity);

	public Faculty updateFaculity(Faculty faculity) throws Exception;

	public List<Faculty> getAllFaculity();

	public Faculty getOneFaculty(Long id);
}
