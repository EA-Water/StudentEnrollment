package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.service.BlockService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/blocks")
public class BlockController {

	@Resource
	private BlockService blockService;

	@GetMapping(value = "/")
	public List<Block> getAllBlock() {
		return blockService.getAllBlock();
	}

	@GetMapping(value = "/{Id}")
	public Block getBlockById(@PathVariable Long Id) {
		return blockService.getBlockById(Id);
	}

	@PostMapping(value = "/")
	public List<Block> createBlock(@RequestBody Block block) {
		blockService.createBlock(block);
		return blockService.getAllBlock();
	}

	@PutMapping("/{id}")
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
