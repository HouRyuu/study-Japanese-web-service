package com.study.Japanese.service;

import com.study.Japanese.entity.dto.ExampleDTO;
import com.study.Japanese.entity.dto.PublicResult;

import java.util.List;

public interface ExampleService {

    PublicResult<Integer> saveExample(ExampleDTO exampleDTO);

    PublicResult<?> deleteExample(int exampleId);

    List<ExampleDTO> findExamples(int grammarId);

}
