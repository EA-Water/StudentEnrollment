package miu.edu.studentenrollment.serviceimptest;

import miu.edu.studentenrollment.controller.EntryController;
import miu.edu.studentenrollment.domain.Entry;
import miu.edu.studentenrollment.service.impl.EntryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

@DisplayName("Entry Services Test Cases")
class EntryServiceImplTest {

    @InjectMocks
    EntryController entryController;

    MockMvc mockMvc;

    @Mock
    EntryServiceImpl entryService;

    Entry entry1 = new Entry();
    Entry entry2 = new Entry();
    List<Entry> entryList = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(entryController).build();
        entry1.setId(1L);
        entry1.setEntryName("August-2020");
        entry1.setEntryStartDate(new Date());
        entry1.setEnrollmentStartDate(new Date());
        entry1.setEnrollmentEndDate(new Date());
        entryList.add(entry1);
    }

    @Test
    void testCreateEntry() {
        try {
            when(entryService.createEntry(entry1)).thenReturn(entry1);
            assertEquals(entry1, entryService.createEntry(entry1));

            // Testing Create Employee Controller

//            mockMvc.perform(post("/create/entry")
//                    .content(makeItJson(entry1))
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String makeItJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testViewAllEntries() throws Exception {
        when(entryService.viewEntries()).thenReturn(entryList);
        assertEquals(1, entryService.viewEntries().size());

        // Testing view All Employees Controller
//			mockMvc.perform(get("/view/entries")
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk());
    }

    @Test
    void testUpdateEntry() {
        try {
            when(entryService.updateEntry(entry1)).thenReturn(entry1);
            assertEquals(entry1, entryService.updateEntry(entry1));
        } catch (Exception e) {

        }
    }

    @Test
    void testHello() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello there"));
    }
    
    @Test
    void testFindEntry() {
        try {
            when(entryService.findEntry(1L)).thenReturn(entry1);
            assertEquals(entry1, entryService.findEntry(1L));
        } catch (Exception e) {

        }
    }

}