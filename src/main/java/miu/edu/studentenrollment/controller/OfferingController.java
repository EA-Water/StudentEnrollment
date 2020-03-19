package miu.edu.studentenrollment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import miu.edu.studentenrollment.domain.Offering;
import miu.edu.studentenrollment.service.OfferingService;
import miu.edu.studentenrollment.util.CustomError;

@RestController
@RequestMapping("/offerings")
public class OfferingController {
	
	@Autowired
	OfferingService offeringService;
	
	@GetMapping("/")
    public ResponseEntity<List<Offering>> getAllOffering() {
        List<Offering> offerings = offeringService.getAllOffering();
        if (offerings.isEmpty()) {
            return new ResponseEntity<List<Offering>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Offering>>(offerings, HttpStatus.OK);
    }
 
	@GetMapping("/{searchString}")
    public ResponseEntity<?> getOfferingByCode(@PathVariable("searchString") String searchString) {
        return getOffering(searchString, "code");
    }
	
	@GetMapping("/block/{searchString}")
    public ResponseEntity<?> getOfferingByBlock(@PathVariable("searchString") String searchString) {
        return getOffering(searchString, "block");
    }
	
	@GetMapping("/course/{searchString}")
    public ResponseEntity<?> getOfferingByCourse(@PathVariable("searchString") String searchString) {
        return getOffering(searchString, "course");
    }
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/")
    public ResponseEntity<?> createOffering(@RequestBody @Valid Offering offering, BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
    	if(!bindingResult.hasErrors())
		{
        if (offeringService.isOfferingExit(offering)) {
        	System.out.println(offeringService.isOfferingExit(offering));
            return new ResponseEntity(new CustomError("Unable to create. An Offerng with Offering Code " + 
            offering.getOfferingCode() + " already exist."),HttpStatus.CONFLICT);
        }
        offeringService.createOffering(offering);
        return new ResponseEntity<Offering>(offering, HttpStatus.CREATED);
		}
    	return new ResponseEntity(new CustomError("Unable to create. Error in your data"),HttpStatus.NOT_ACCEPTABLE);
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/{id}")
    public ResponseEntity<?> updateOffering(@PathVariable("id") long id, @RequestBody @Valid Offering offering, BindingResult bindingResult) {
    	if(!bindingResult.hasErrors())
		{
    	Offering currentOffering = offeringService.getOfferingById(id);
 
        if (currentOffering == null) {
            return new ResponseEntity(new CustomError("Unable to upate. Offering with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentOffering.setBlock(offering.getBlock());
        currentOffering.setCourse(offering.getCourse());
        currentOffering.setOfferingCode(offering.getOfferingCode());
 
        offeringService.updateOffering(currentOffering);
        return new ResponseEntity<Offering>(currentOffering, HttpStatus.OK);
		}
    	return new ResponseEntity(new CustomError("Unable to create. Error in your data"),HttpStatus.NOT_ACCEPTABLE);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/{id}")
    public ResponseEntity<?> removeOffering(@PathVariable("id") long id) {
 
    	Offering offering = offeringService.getOfferingById(id);
        if (offering == null) {
            return new ResponseEntity(new CustomError("Unable to delete. Offering with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        offeringService.removeOffering(id);
        return new ResponseEntity<Offering>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<Offering> removeAllOfferings() { 
    	offeringService.removeAllOfferings();
        return new ResponseEntity<Offering>(HttpStatus.NO_CONTENT);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> getOffering(String searchString, String type) {
		List<Offering> offerings = new ArrayList<Offering>();
		if(StringUtils.isNumeric(searchString))
    	 {
			if(type.equals("block"))
			offerings = offeringService.getOfferingsByBlockId(Long.parseLong(searchString));
			else if(type.equals("course"))
			offerings = offeringService.getOfferingsByCourseId(Long.parseLong(searchString));
    	 }
		else {offerings = offeringService.getOfferingsByBlockCodeOrCourseCode(searchString);}
    	 
        if (offerings.isEmpty()) {
            return new ResponseEntity(new CustomError("No offering with " + searchString 
                    + " found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Offering>>(offerings, HttpStatus.OK);
    }

}
