package miu.edu.studentenrollment.service;

import java.util.List;

import miu.edu.studentenrollment.domain.Offering;

public interface OfferingService {
	
	List<Offering> searchOfferings(String searchString);

    Offering getOfferingById(long id);

    List<Offering> getAllOffering();

    void createOffering(Offering offering);
    
    boolean isOfferingExit(Offering offering);
    
    void updateOffering(Offering offering);
    
    void deleteOffering(long id);
    
    void deleteAllOfferings();

}
