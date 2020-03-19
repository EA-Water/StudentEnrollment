package miu.edu.studentenrollment.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import miu.edu.studentenrollment.domain.Offering;

public interface OfferingService {

    Offering getOfferingById(long id);
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
    List<Offering> getAllOffering();
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
    List<Offering> getOfferingsByBlockId(long id);
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
    List<Offering> getOfferingsByBlockCodeOrCourseCode(String blockCode);

    @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
    List<Offering> getOfferingsByCourseId(long id);
    
    @PreAuthorize("hasRole('ADMIN')")
    void createOffering(Offering offering);
    
    boolean isOfferingExit(Offering offering);
    
    @PreAuthorize("hasRole('ADMIN')")
    void updateOffering(Offering offering);
    
    @PreAuthorize("hasRole('ADMIN')")
    void removeOffering(long id);
    
    @PreAuthorize("hasRole('ADMIN')")
    void removeAllOfferings();

}
