package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.repository.BlockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepo repo;

    @Override
    @Transactional
    public List<Block> findAll() {
        return (List<Block>) repo.findAll();
    }

    @Transactional
    public Block findById(Long theId) {
        Optional<Block> result = repo.findById(theId);
        Block block = null;
        if(result.isPresent()){
            block = result.get();
        }else{
            throw new RuntimeException("Could not find the block with id "+ theId);
        }
        return block;
    }

    @Override
    @Transactional
    public void save(Block block) {
        repo.save(block);
    }

    @Override
    @Transactional
    public void deleteById(Long theId) {
        repo.deleteById(theId);
    }
}
