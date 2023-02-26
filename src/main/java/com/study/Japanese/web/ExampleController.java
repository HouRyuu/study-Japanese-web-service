package com.study.Japanese.web;

import com.study.Japanese.entity.dto.ExampleDTO;
import com.study.Japanese.entity.dto.PublicResult;
import com.study.Japanese.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @PostMapping("/save")
    public PublicResult<Integer> saveExample(@RequestBody ExampleDTO exampleDTO) {
        return exampleService.saveExample(exampleDTO);
    }

    @DeleteMapping("/{exampleId}/delete")
    public PublicResult<?> deleteGrammar(@PathVariable int exampleId) {
        return exampleService.deleteExample(exampleId);
    }

    @GetMapping("/{grammarId}/list")
    public PublicResult<?> list(@PathVariable int grammarId) {
        return PublicResult.success(exampleService.findExamples(grammarId));
    }
}
