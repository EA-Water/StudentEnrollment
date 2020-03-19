package miu.edu.studentenrollment.service.impl;

import java.util.List;
import java.util.Optional;

import miu.edu.studentenrollment.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.studentenrollment.domain.Offering;
import miu.edu.studentenrollment.repository.OfferingRepository;
import miu.edu.studentenrollment.service.OfferingService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OfferingServiceImpl implements OfferingService{

	@Autowired
	OfferingRepository offeringRepository;
	
	@Override
	public List<Offering> searchOfferings(String searchString) {
		// TODO Auto-generated method stub
		return offeringRepository.findOfferings(searchString);
	}

	@Override
	public Offering getOfferingById(long id) {
		// TODO Auto-generated method stub
		return offeringRepository.findById(id);
	}

	@Override
	public List<Offering> getAllOffering() {
		// TODO Auto-generated method stub
		return offeringRepository.findAll();
	}

	@Override
	public void createOffering(Offering offering) {
		// TODO Auto-generated method stub
		offeringRepository.save(offering);
	}

	@Override
	public boolean isOfferingExit(Offering offering) {
		// TODO Auto-generated method stub
		return offeringRepository.existsByOfferingCode(offering.getOfferingCode());
	}

	@Override
	public void updateOffering(Offering offering) {
		// TODO Auto-generated method stub
		offeringRepository.save(offering);
	}

	@Override
	public void removeOffering(long id) {
		// TODO Auto-generated method stub
		offeringRepository.deleteById(id);
	}

	@Override
	public void removeAllOfferings() {
		// TODO Auto-generated method stub
		offeringRepository.deleteAll();
	}

	@Override
	public List<Offering> getOfferingsByBlockIdOrCourseId(long id) {
		// TODO Auto-generated method stub
		return offeringRepository.findByBlock_id_OrCourse_id(id, id);
	}

	@Override
	public List<Offering> getOfferingsByBlockCodeOrCourseCode(String blockCode) {
		// TODO Auto-generated method stub
		return offeringRepository.findByBlock_BlockCode_OrCourse_CourseCode(blockCode, blockCode);
	}

	@Override
	public List<Offering> getOfferingsByBlockId(long id) {
		// TODO Auto-generated method stub
		return offeringRepository.findByBlock_id(id);
	}

	@Override
	public List<Offering> getOfferingsByCourseId(long id) {
		// TODO Auto-generated method stub
		return offeringRepository.findByCourse_id(id);
	}
}
