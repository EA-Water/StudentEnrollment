package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.repository.BlockRepo;
import miu.edu.studentenrollment.service.BlockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockRepo repo;

	@Override
	public List<Block> findAll() {
		return (List<Block>) repo.findAll();
	}

	@Override
	public Block findById(Long theId) {
		Optional<Block> result = repo.findById(theId);
		Block block = null;
		if (result.isPresent()) {
			block = result.get();
		} else {
			throw new RuntimeException("Could not find the block with id " + theId);
		}
		return block;
	}

	@Override
	public Block save(Block block) {
			return repo.save(block);
	}

	@Override
	public Block updateBlock(Block block) throws Exception {
		if (repo.findById(block.getId()).get() == null) {
			throw new Exception("Could not find the block");
		}
		return repo.save(block);
	}

}
