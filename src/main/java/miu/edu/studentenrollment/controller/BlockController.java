package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.service.BlockService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class BlockController {

	@Resource
	private BlockService blockService;

	@GetMapping(value = "/block/allBlocks")
	public List<Block> findAll() {
		return blockService.findAll();
	}

	@GetMapping(value = "/block/{Id}")
	public Block findById(@PathVariable Long Id) {
		return blockService.findById(Id);
	}

	@PostMapping(value = "/block/addBlock")
	public List<Block> addBlock(@RequestBody Block block) {
		blockService.save(block);
		return blockService.findAll();
	}

	@PutMapping("/block/update/{id}")
	public void updateBlock(@PathVariable Long id, @RequestBody Block block) {

		try {
			block.setId(id);
			blockService.updateBlock(block);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
