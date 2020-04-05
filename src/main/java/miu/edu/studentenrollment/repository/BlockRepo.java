package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepo extends JpaRepository<Block, Long> {

}
