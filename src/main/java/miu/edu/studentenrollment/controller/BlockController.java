package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.Block;
import miu.edu.studentenrollment.repository.BlockRepo;
import miu.edu.studentenrollment.service.impl.BlockService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value="/block")
public class BlockController {

    @Resource
    private BlockService blockService;

    @RequestMapping(value="/allBlocks")
    public List<Block> findAll(){
        return blockService.findAll();
    }

    @RequestMapping(value="/{Id}")
    public Block findById(@PathVariable Long Id){
        return blockService.findById(Id);
    }

    @RequestMapping(value = "/add")
    public List<Block> addBlock(Block block){
        blockService.save(block);
        return blockService.findAll();
    }

    @RequestMapping(value="/delete/{Id}")
    public List<Block> deleteBlock(@PathVariable Long Id){
        blockService.deleteById(Id);
        return blockService.findAll();
    }
}
