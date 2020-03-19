package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {

    @Query("select s from Section s where s.offering.block.id =:id")
    List<Section> getSectionsByBlockId(Long id);
}
