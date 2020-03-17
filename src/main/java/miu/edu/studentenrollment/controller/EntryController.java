package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/create/entry")
    public List<Entry> createEntry(@RequestBody @Valid Entry entry) throws Exception {
        List<Entry> entries = new ArrayList<>();
        Entry savedEntry = entryService.createEntry(entry);
        entries = entryService.viewEntries();
        return entries;
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
