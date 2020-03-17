package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {
}
