package miu.edu.studentenrollment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.repository.FacultyRepo;
import miu.edu.studentenrollment.service.FaculityService;

@Service
@Transactional
public class FaculityServiceImpl implements FaculityService {

	@Autowired
	private FacultyRepo faculityRepo;

	@Override
	public Faculty addFaculity(Faculty faculty) {
		// TODO Auto-generated method stub
		return faculityRepo.save(faculty);
	}

	@Override
	public void removeFaculity(Faculty faculity) {
		// TODO Auto-generated method stub
		faculityRepo.delete(faculity);
	}

	@Override
	public Faculty updateFaculity(Faculty faculity) throws Exception {
		// TODO Auto-generated method stub

		if (faculityRepo.findById(faculity.getId()).get() == null) {
			throw new Exception("Something is wrong");
		}
		return faculityRepo.save(faculity);

	}

	@Override
	public List<Faculty> getAllFaculity() {
		// TODO Auto-generated method stub
		return faculityRepo.findAll();
	}

	@Override
	public Faculty getOneFaculty(Long id) {
		// TODO Auto-generated method stub
		return faculityRepo.getOne(id);
	}

}
