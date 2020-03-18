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
   
    @Query("SELECT o FROM Offering o WHERE (o.offeringCode LIKE %:searchvalue%)")
    List<Offering> findOfferings(@Param("searchvalue") String searchvalue);

}
