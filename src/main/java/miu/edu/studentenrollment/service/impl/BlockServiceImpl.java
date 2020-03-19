package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.repository.BlockRepo;
import miu.edu.studentenrollment.service.BlockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockRepo repo;

	@PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY')")
	@Override
	public List<Block> getAllBlocks() {
		return (List<Block>) repo.findAll();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public Block getBlockById(Long theId) {
		Optional<Block> result = repo.findById(theId);
		Block block = null;
		if (result.isPresent()) {
			block = result.get();
		} else {
			throw new RuntimeException("Could not find the block with id " + theId);
		}
		return block;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public Block createBlock(Block block) {
			return repo.save(block);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public Block updateBlock(Block block) throws Exception {
		if (repo.findById(block.getId()).get() == null) {
			throw new Exception("Could not find the block");
		}
		return repo.save(block);
	}

}
