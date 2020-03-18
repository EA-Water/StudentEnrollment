package miu.edu.studentenrollment.service.impl;

import java.util.List;

import miu.edu.studentenrollment.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miu.edu.studentenrollment.domain.Offering;
import miu.edu.studentenrollment.repository.OfferingRepository;

@Service
public class OfferingServiceImpl implements OfferingService {

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
		return offeringRepository.getById(id);
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
		List<Offering> offerings = offeringRepository.findByOfferingCode(offering.getOfferingCode());
		return offerings.isEmpty();
	}

	@Override
	public void updateOffering(Offering offering) {
		// TODO Auto-generated method stub
		offeringRepository.save(offering);
	}

	@Override
	public void deleteOffering(long id) {
		// TODO Auto-generated method stub
		offeringRepository.deleteById(id);
	}

	@Override
	public void deleteAllOfferings() {
		// TODO Auto-generated method stub
		offeringRepository.deleteAll();
	}
	 

}
