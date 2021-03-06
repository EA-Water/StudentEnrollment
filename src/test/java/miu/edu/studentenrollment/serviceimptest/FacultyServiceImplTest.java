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
import miu.edu.studentenrollment.domain.Faculty;
import miu.edu.studentenrollment.repository.FacultyRepo;
import miu.edu.studentenrollment.repository.OfferingRepository;
import miu.edu.studentenrollment.service.impl.FacultyServiceImpl;

@DisplayName("Faculty Services Test Cases")
public class FacultyServiceImplTest {

	@InjectMocks
	FacultyServiceImpl facultyService;

	@Mock
	FacultyRepo faculityRepo;

	Faculty faculty1 = new Faculty();
	Faculty faculty2 = new Faculty();
	List<Faculty> facultyList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		faculty1.setId(1L);
		faculty1.setFacultyName("Payman Salek");
		faculty1.setFacultyTitle("professor");

		facultyList.add(faculty1);
		facultyList.add(faculty2);
	}

	@Test
	void testCreateFaculity() {
		try {
			when(faculityRepo.save(faculty1)).thenReturn(faculty1);
			assertEquals(faculty1, facultyService.createFaculity(faculty1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRemoveFaculity() {
		try {
			facultyService.removeFaculity(faculty1);
			verify(faculityRepo, times(1)).delete(faculty1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateFaculity() {
		try {
			facultyService.updateFaculity(faculty1);
			verify(faculityRepo, times(1)).save(faculty1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllFaculity() {
		try {
			when(faculityRepo.findAll()).thenReturn(facultyList);
			assertEquals(2, facultyService.getAllFaculity().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	@Test
	void testGetFacultyById() {
		try {
			when(faculityRepo.getOne(1L)).thenReturn(faculty1);
			assertEquals(faculty1, facultyService.getFacultyById(1L));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
