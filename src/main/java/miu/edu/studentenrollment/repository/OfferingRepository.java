package miu.edu.studentenrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import miu.edu.studentenrollment.domain.Offering;

@Repository
public interface OfferingRepository extends JpaRepository<Offering, Long>{
	
	List<Offering> findByOfferingCode(String offeringCode);
	Offering findById(long id);
	
	@Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Offering o WHERE o.offeringCode = :offeringword")
    boolean existsByOfferingCode(@Param("offeringword") String offeringword);

    List<Offering> findByBlock_BlockCode_OrCourse_CourseCode(String searchvalue, String searchvalue2);
    List<Offering> findByBlock_id(Long id);
    List<Offering> findByCourse_id(Long id);
    
}
