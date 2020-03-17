package miu.edu.studentenrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import miu.edu.studentenrollment.service.impl.OfferingService;
import miu.edu.studentenrollment.util.CustomError;

@RestController
@RequestMapping("/offerings")
public class OfferingController {
	
	@Autowired
	OfferingService offeringService;
	
	@GetMapping("/")
    public ResponseEntity<List<Offering>> listAllOffering() {
        List<Offering> offerings = offeringService.getAllOffering();
        if (offerings.isEmpty()) {
            return new ResponseEntity<List<Offering>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Offering>>(offerings, HttpStatus.OK);
    }
 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/search/{searchString}")
    public ResponseEntity<?> getOffering(@PathVariable("searchString") String searchString) {
    	 List<Offering> offerings = offeringService.searchOfferings(searchString);
        if (offerings.isEmpty()) {
            return new ResponseEntity(new CustomError("No offering with " + searchString 
                    + " found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Offering>>(offerings, HttpStatus.OK);
    }
	
	@GetMapping("/addNewOffering")
	public String addNewOffering(Offering offering)
	{
		return "add Form";
	}
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/addNewOffering")
    public ResponseEntity<?> createOffering(@RequestBody Offering offering, UriComponentsBuilder ucBuilder) {
 
        if (offeringService.isOfferingExit(offering)) {
            return new ResponseEntity(new CustomError("Unable to create. An Offerng with Offering Code " + 
            offering.getOfferingCode() + " already exist."),HttpStatus.CONFLICT);
        }
        offeringService.createOffering(offering);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/offerings/").build().toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/offering/{id}")
    public ResponseEntity<?> updateOffering(@PathVariable("id") long id, @RequestBody Offering offering) {
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/offering/{id}")
    public ResponseEntity<?> deleteOffering(@PathVariable("id") long id) {
 
    	Offering offering = offeringService.getOfferingById(id);
        if (offering == null) {
            return new ResponseEntity(new CustomError("Unable to delete. Offering with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        offeringService.deleteOffering(id);
        return new ResponseEntity<Offering>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<Offering> deleteAllOfferings() { 
    	offeringService.deleteAllOfferings();
        return new ResponseEntity<Offering>(HttpStatus.NO_CONTENT);
    }

}
