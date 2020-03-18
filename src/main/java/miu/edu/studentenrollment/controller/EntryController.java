package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.service.EntryService;
import miu.edu.studentenrollment.util.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/")
    public ResponseEntity<?> createEntry(@RequestBody @Valid Entry entry, UriComponentsBuilder ucBuilder) throws Exception {

        if (entryService.exist(entry.getEntryName())) {
            return new ResponseEntity(new CustomError("Unable to create an entry, already exists"), HttpStatus.CONFLICT);
        }
        Entry savedEntry = entryService.createEntry(entry);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/entries/").build().toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllEntry() {
        List<Entry> entries = entryService.getAllEntries();

        if (entries.isEmpty()) {
            return new ResponseEntity<List<Entry>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Entry>>(entries, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntry(@RequestBody @Valid Entry entry, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Entry entry1 = entryService.getEntry(id);
            if (entry1 == null) {
                return new ResponseEntity(new CustomError("Invalid entry id"), HttpStatus.NOT_FOUND);
            }

            Entry updatedEntry = entryService.updateEntry(entry, id);
            headers.setLocation(uriComponentsBuilder.path("/entries/").build().toUri());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello there";
    }
}
