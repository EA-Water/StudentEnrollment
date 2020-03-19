package miu.edu.studentenrollment.service;

import java.util.List;

import miu.edu.studentenrollment.domain.Offering;

public interface OfferingService {

    Offering getOfferingById(long id);

    List<Offering> getAllOffering();
    
    List<Offering> getOfferingsByBlockId(long id);
    
    List<Offering> getOfferingsByBlockCodeOrCourseCode(String blockCode);

    List<Offering> getOfferingsByCourseId(long id);

    void createOffering(Offering offering);
    
    boolean isOfferingExit(Offering offering);
    
    void updateOffering(Offering offering);
    
    void removeOffering(long id);
    
    void removeAllOfferings();

}
