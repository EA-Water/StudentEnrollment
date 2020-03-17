package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Block;

import java.util.List;

public interface BlockService {

    public List<Block> findAll();

    public Block findById(Long theId);

    public void save(Block block);

    public Block updateBlock(Block block) throws Exception;
}
