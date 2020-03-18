package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.repository.EntryRepo;
import miu.edu.studentenrollment.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepo entryRepo;

    @Override
    public Entry createEntry(Entry entry) throws Exception {
        try {

            if(entry.getEnrollmentEndDate().before(entry.getEntryStartDate())){
                throw new Exception("Invalid enrollment start date");
            }

            if(entry.getEnrollmentEndDate().before(entry.getEntryStartDate())){
                throw new Exception("Invalid enrollment end date");
            }

           return entryRepo.save(entry);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Entry getEntry(Long id) throws Exception {
        try {
            return entryRepo.findById(id).get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Entry updateEntry(Entry entry, Long id) throws Exception {
        try {
            Entry foundEntry = entryRepo.findById(id).get();
            foundEntry.setEntryStartDate(entry.getEntryStartDate());
            foundEntry.setEntryName(entry.getEntryName());
            foundEntry.setEnrollmentEndDate(entry.getEnrollmentEndDate());
            foundEntry.setEnrollmentStartDate(entry.getEnrollmentStartDate());
            if(foundEntry==null){
                throw new Exception("Invalid entry");
            }
            return entryRepo.save(foundEntry);
        }catch (Exception ex){
            throw  new Exception(ex.getMessage());
        }
    }

    @Override
    public List<Entry> getAllEntries() {
        return (List<Entry>) entryRepo.findAll();
    }

    @Override
    public Boolean exist(String name) {
        return !entryRepo.findByEntryName(name).isEmpty();
    }



}
