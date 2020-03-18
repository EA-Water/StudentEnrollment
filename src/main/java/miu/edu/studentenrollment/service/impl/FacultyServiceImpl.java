package miu.edu.studentenrollment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Faculty createFaculity(Faculty faculty) {

		return faculityRepo.save(faculty);
	}

	@Override
	public String removeFaculity(Faculty faculity) {

		try {
			faculityRepo.delete(faculity);
		} catch (Exception e) {

		}

		return "Remove Sucessfull!!";
	}

	@Override
	public Faculty updateFaculity(Faculty faculity) throws Exception {

//		if (faculityRepo.findById(faculity.getId()).get() == null) {
//			throw new Exception("Something is wrong");
//		}
		return faculityRepo.save(faculity);

	}

	@Override
	public List<Faculty> getAllFaculity() {

		return faculityRepo.findAll();
	}

	@Override
	public Faculty getFacultyById(Long id) {

		return faculityRepo.getOne(id);
	}

}
