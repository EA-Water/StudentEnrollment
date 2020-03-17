package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepo extends CrudRepository<Entry, Long> {

}
