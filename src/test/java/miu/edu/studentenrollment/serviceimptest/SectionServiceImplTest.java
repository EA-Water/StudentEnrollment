package miu.edu.studentenrollment.serviceimptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import miu.edu.studentenrollment.domain.Enrollment;
import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.domain.Offering;
import miu.edu.studentenrollment.domain.Section;
import miu.edu.studentenrollment.repository.SectionRepo;
import miu.edu.studentenrollment.service.SectionService;
import miu.edu.studentenrollment.service.impl.FacultyServiceImpl;
import miu.edu.studentenrollment.service.impl.SectionServiceImpl;

@DisplayName("Section Services Test Cases")
public class SectionServiceImplTest {

	@InjectMocks
	SectionServiceImpl sectionService;

	@Mock
	SectionRepo sectionRepo;

	Section section1 = new Section();
	Section section2 = new Section();
	Faculty faculty1 = new Faculty();
	Offering offering1 = new Offering();
	List<Enrollment> enrollmentList = new ArrayList<>();
	Enrollment enrollment1 = new Enrollment();
	Enrollment enrollment2 = new Enrollment();

	List<Section> sections = new ArrayList<Section>();

	@BeforeEach
	void setUp() throws Exception {
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
			when(sectionRepo.save(section1)).thenReturn(section1);
			assertEquals(section1, sectionService.createSection(section1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllSections() throws Exception {
		try {
			when(sectionRepo.findAll()).thenReturn(sections);
			assertEquals(1, sectionService.getAllSections().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateSection() throws Exception {
		try {
			sectionService.updateSection(section1, 1L);
			verify(sectionRepo, times(1)).getOne(1L);
		} catch (

		Exception e) {

		}
	}

	@Test
	void testGetSectionById() throws Exception {
		try {
			sectionService.getSectionById(1L);
			verify(sectionRepo, times(1)).getOne(1L);
		} catch (

		Exception e) {
			
		}
	}
}
