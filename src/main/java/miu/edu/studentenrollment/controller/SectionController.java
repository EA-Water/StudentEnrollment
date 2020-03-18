package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Section;

import miu.edu.studentenrollment.service.EnrollmentService;
import miu.edu.studentenrollment.service.SectionService;
import miu.edu.studentenrollment.util.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/")
    public ResponseEntity<?> createSection(@RequestBody @Valid Section section, UriComponentsBuilder uriComponentsBuilder) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Section Savedsection = sectionService.createSection(section);
            headers.setLocation(uriComponentsBuilder.path("/sections/").build().toUri());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSection(@RequestBody Section section, @PathVariable Long id) {

        try {
            Section section1 = sectionService.getSectionById(id);
            if (section1 == null) {
                return new ResponseEntity(new CustomError("Section not found"), HttpStatus.NOT_FOUND);
            }
            Section updatedSection = sectionService.updateSection(section, id);
            return new ResponseEntity<Section>(updatedSection, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllSections() {

        try {
            List<Section> sectionList = sectionService.getAllSections();
            if (sectionList.isEmpty()) {
                return new ResponseEntity<String>("List is Empty", HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Section>>(sectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{sectionId}/enrollments")
    public ResponseEntity<?> viewSectionEnrollment(@PathVariable Long sectionId){
        try {
            Section section = sectionService.getSectionById(sectionId);
            if(section == null){
                return new ResponseEntity(new CustomError("Invalid section Id"), HttpStatus.NOT_FOUND);
            }
            List<Enrollment> sectionEnrollments = enrollmentService.getEnrollmentBySection(section);
            return new ResponseEntity<List<Enrollment>>(sectionEnrollments,HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
