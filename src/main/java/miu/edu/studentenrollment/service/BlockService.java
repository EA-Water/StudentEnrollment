package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Block;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BlockService {

    public List<Block> getAllBlocks();

    public Block getBlockById(Long theId);

    public Block createBlock(Block block);

    public Block updateBlock(Block block) throws Exception;

}
