package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Block;

import java.util.List;

public interface BlockService {

    public List<Block> getAllBlock();

    public Block getBlockById(Long theId);

    public Block createBlock(Block block);

    public Block updateBlock(Block block) throws Exception;

}
