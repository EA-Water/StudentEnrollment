package miu.edu.studentenrollment.serviceimptest;

import miu.edu.studentenrollment.controller.BlockController;
import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.repository.BlockRepo;
import miu.edu.studentenrollment.service.BlockService;
import miu.edu.studentenrollment.service.impl.BlockServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    BlockServiceImpl blockService;

    MockMvc mockMvc;
    BlockService service = mock(BlockService.class);

    @Mock
    BlockRepo blockRepo;

    Block block1 = new Block();
    Block block2 = new Block();
    List<Block> blockList = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
        block1.setId(1L);
        block1.setBlockCode("2020-03");
        block1.setBlockSemester("Fall");
        block1.setBlockSequenceNumber("23");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date startDate = simpleDateFormat.parse("2020-03-18");
        Date endDate = simpleDateFormat.parse("2020-03-28");
        block1.setStartDate(startDate);
        block1.setEndDate(endDate);

        block2.setId(2L);
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
			blockService.createBlock(block1);
			verify(blockRepo, times(1)).save(block1);
			
		}catch (Exception e) {
            e.printStackTrace();
		}

    }

    @Test
    void testBlockListSize() throws Exception {
    	when(blockRepo.findAll()).thenReturn(blockList);
		assertEquals(2, blockService.getAllBlocks().size());
    }

    @Test
    void testViewAllBlocks() throws Exception {
        when(blockRepo.findAll()).thenReturn(blockList);
        assertEquals(blockList, blockService.getAllBlocks());
    }

    @Test
    void testUpdateblock() {
    	try {
			blockService.updateBlock(block2);
			verify(blockRepo, times(1)).save(block2);
		}catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Test
    void testFindById() {
    	try {
			when(blockRepo.findById(2L).get()).thenReturn(block2);
			assertEquals(block1, blockService.getBlockById(2L));
		}catch (Exception e) {
			e.printStackTrace();
		}
    }


}