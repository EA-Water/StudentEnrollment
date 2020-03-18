package miu.edu.studentenrollment.serviceimptest;

import miu.edu.studentenrollment.controller.BlockController;
import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.repository.BlockRepo;
import miu.edu.studentenrollment.service.BlockService;
import miu.edu.studentenrollment.service.impl.BlockServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

@DisplayName("Block Services Test Cases")
class BlockServiceImplTest {

    @InjectMocks
    BlockController blockController;

    MockMvc mockMvc;
    BlockService service = mock(BlockService.class);

    @Mock
    BlockServiceImpl blockService;

    Block block1 = new Block();
    Block block2 = new Block();
    List<Block> blockList = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(blockController).build();
        block1.setId((long) 1);
        block1.setBlockCode("2020-03");
        block1.setBlockSemester("Fall");
        block1.setBlockSequenceNumber("23");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date startDate = simpleDateFormat.parse("2020-03-18");
        Date endDate = simpleDateFormat.parse("2020-03-28");
        block1.setStartDate(startDate);
        block1.setEndDate(endDate);

        block2.setId((long) 2);
        block2.setBlockCode("2020-02");
        block2.setBlockSemester("Fall");
        block2.setBlockSequenceNumber("2");
        String pattern2 = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);

        Date startDate2 = simpleDateFormat.parse("2020-04-18");
        Date endDate2 = simpleDateFormat.parse("2020-04-28");
        block2.setStartDate(startDate2);
        block2.setEndDate(endDate2);
        blockList.add(block1);
        blockList.add(block2);
    }

    @Test
    void testCreateBlock() {
        try {
            when(blockService.save(block1)).thenReturn(block1);
            assertEquals(block1, blockService.save(block1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void testBlockListSize() throws Exception {
        when(blockService.findAll()).thenReturn(blockList);
        assertEquals(2, blockService.findAll().size());
    }

    @Test
    void testViewAllBlocks() throws Exception {
        when(blockService.findAll()).thenReturn(blockList);
        assertEquals(blockList, blockService.findAll());
    }

    @Test
    void testUpdateblock() {
        try {
            when(blockService.updateBlock(block1)).thenReturn(block1);
            assertEquals(block1, blockService.updateBlock(block1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFindById() {
        try {
            when(blockService.findById((long) 1)).thenReturn(block1);
            assertEquals(block1, blockService.findById((long) 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}