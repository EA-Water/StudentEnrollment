package miu.edu.studentenrollment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.repository.FacultyRepo;
import miu.edu.studentenrollment.service.FacultyService;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepo faculityRepo;

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public Faculty createFaculity(Faculty faculty) {

		return faculityRepo.save(faculty);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public String removeFaculity(Faculty faculity) {

		try {
			faculityRepo.delete(faculity);
		} catch (Exception e) {

		}

		return "Remove Sucessfull!!";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public Faculty updateFaculity(Faculty faculity) throws Exception {

		return faculityRepo.save(faculity);

	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY')")
	@Override
	public List<Faculty> getAllFaculity() {

		return faculityRepo.findAll();
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY')")
	@Override
	public Faculty getFacultyById(Long id) {

		return faculityRepo.getOne(id);
	}
}
