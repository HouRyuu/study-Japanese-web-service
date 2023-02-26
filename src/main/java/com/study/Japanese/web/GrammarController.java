package com.study.Japanese.web;

import com.study.Japanese.entity.dto.GrammarDTO;
import com.study.Japanese.entity.dto.GrammarQueryDTO;
import com.study.Japanese.entity.dto.PublicResult;
import com.study.Japanese.service.GrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grammar")
public class GrammarController {

    @Autowired
    private GrammarService grammarService;

    @PostMapping("/save")
    public PublicResult<?> saveGrammar(@RequestBody GrammarDTO grammarDTO) {
        return grammarService.saveGrammar(grammarDTO);
    }

    @DeleteMapping("/{grammarId}/delete")
    public PublicResult<?> deleteGrammar(@PathVariable int grammarId) {
        return grammarService.deleteGrammar(grammarId);
    }

    @PostMapping("/page")
    public PublicResult<?> grammarPage(@RequestBody GrammarQueryDTO queryDTO) {
        return PublicResult.success(grammarService.grammarPage(queryDTO));
    }
}
