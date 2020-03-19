package miu.edu.studentenrollment.serviceimptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import miu.edu.studentenrollment.domain.Offering;
import miu.edu.studentenrollment.repository.OfferingRepository;
import miu.edu.studentenrollment.service.impl.OfferingServiceImpl;

@DisplayName("Offering Service Test cases")
public class OfferingServiceImplTest {
	
	@InjectMocks
	OfferingServiceImpl offeringService;
	
	@Mock
	OfferingRepository offeringRepository;
	
	Offering offering = new Offering();
	Offering offering2 = new Offering();
	List<Offering> offerings = new ArrayList<Offering>();
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		offering.setId(1L);
		offering.setOfferingCode("cs544-2020-03");
		offering2.setId(2L);
		offering2.setOfferingCode("cs451-2020-01");
		offerings.add(offering);
		offerings.add(offering2);
	}
	
	
	@Test
	void getOfferingByIdTest()
	{
		try {
			when(offeringRepository.findById(2L)).thenReturn(offering2);
			Offering result = offeringService.getOfferingById(2L);
			assertEquals(offering2, result);
			assertNotEquals("cs544", result.getOfferingCode());
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void getAllOfferingTest()
	{
		try {
			when(offeringRepository.findAll()).thenReturn(offerings);
			assertEquals(2, offeringService.getAllOffering().size());
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void createOfferingTest()
	{
		try {
			offeringService.createOffering(offering);
	        verify(offeringRepository, times(1)).save(offering);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void isOfferingExit()
	{
		try {
			when(!offeringRepository.existsByOfferingCode(offering.getOfferingCode()))
					.thenReturn(offerings.contains(offering));
			assertEquals(true, offeringService.isOfferingExit(offering));
			
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void updateOfferingTest()
	{
		try {
			offeringService.updateOffering(offering);
	        verify(offeringRepository, times(1)).save(offering);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void deleteOfferingTest()
	{
		try {
			offeringService.removeOffering(1L);
	        verify(offeringRepository, times(1)).deleteById(1L);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	void deleteAllOfferingsTest()
	{
		try {
			offeringService.removeAllOfferings();
	        verify(offeringRepository, times(1)).deleteAll();
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	

}
