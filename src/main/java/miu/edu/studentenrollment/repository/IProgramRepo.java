package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.StudentProgram;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramRepo extends CrudRepository<StudentProgram, Long> {
}
