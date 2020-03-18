package miu.edu.studentenrollment.repository;

import miu.edu.studentenrollment.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Long> {
    List<Entry> findByEntryName(String name);
}
