package miu.edu.studentenrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.studentenrollment.domain.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long>{

}
