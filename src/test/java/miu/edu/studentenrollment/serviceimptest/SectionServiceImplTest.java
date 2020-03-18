package miu.edu.studentenrollment.serviceimptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.domain.Offering;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.service.SectionService;

@DisplayName("Section Services Test Cases")
public class SectionServiceImplTest {
	
	@Mock
	SectionService sectionService;
	
	Section section1 = new Section();
	Faculty faculty1 = new Faculty();
	Offering offering1 = new Offering();
	List<Enrollment> enrollmentList= new ArrayList<>();
	
	//Section section2 = new Section();
	List<Section> sections = new ArrayList<Section>();
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		section1.setId(1L);
		section1.setFaculty(faculty1);
		section1.setOffering(offering1);
		section1.setEnrollmentList(enrollmentList);
		sections.add(section1);
	}
	
	@Test
	void testCreateSection() {
		try {
			when(sectionService.createSection(section1)).thenReturn(section1);
			assertEquals(section1, sectionService.createSection(section1));
		}catch (Exception e) {
            e.printStackTrace();
	}
	}
	@Test
	void testViewAllSection() throws Exception{
		when(sectionService.getAllSections()).thenReturn(sections);
		assertEquals(1, sectionService.getAllSections().size());
	}
	@Test
	void testEditSection() throws Exception{
		when(sectionService.updateSection(section1,section1.getId())).thenReturn(section1);
		assertEquals(section1, sectionService.updateSection(section1, section1.getId()));
	}
	@Test
	void testFindOneSection() throws Exception{
		when(sectionService.getSectionById(1L)).thenReturn(section1);
		assertEquals(section1, sectionService.getSectionById(1L));
	}
}
