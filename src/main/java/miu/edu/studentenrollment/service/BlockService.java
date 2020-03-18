package miu.edu.studentenrollment.service;

import miu.edu.studentenrollment.domain.Block;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BlockService {

    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY')")
    public List<Block> getAllBlock();

    @PreAuthorize("hasRole('ADMIN')")
    public Block getBlockById(Long theId);

    @PreAuthorize("hasRole('ADMIN')")
    public Block createBlock(Block block);

    @PreAuthorize("hasRole('ADMIN')")
    public Block updateBlock(Block block) throws Exception;

}
