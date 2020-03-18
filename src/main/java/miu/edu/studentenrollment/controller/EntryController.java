package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.service.EntryService;
import miu.edu.studentenrollment.util.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/create/entry")
    public ResponseEntity<?> createEntry(@RequestBody @Valid Entry entry, UriComponentsBuilder ucBuilder) throws Exception {

        if (entryService.exist(entry.getEntryName())) {
            return new ResponseEntity(new CustomError("Unable to create an entry, already exists"), HttpStatus.CONFLICT);
        }
        Entry savedEntry = entryService.createEntry(entry);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/view/entries").build().toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/view/entries")
    public List<Entry> getAllEntry(){
        return entryService.viewEntries();
    }

    @PutMapping("/update/entry/{entryId}")
    public List<Entry> updateEntry(@RequestBody Entry entry, @PathVariable Long entryId){
            List<Entry> entries = new ArrayList<>();
        try {
            Entry entry1  = entryService.findEntry(entryId);
            entry.setId(entryId);
            entryService.updateEntry(entry);
            entries = entryService.viewEntries();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entries;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello there";
    }
}
