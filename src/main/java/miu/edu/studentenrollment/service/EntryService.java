package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Entry;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface EntryService {

   Entry createEntry(Entry entry) throws Exception;
   Entry findEntry(Long id) throws Exception;
   Entry updateEntry(Entry entry) throws Exception;
   List<Entry> viewEntries();

}
