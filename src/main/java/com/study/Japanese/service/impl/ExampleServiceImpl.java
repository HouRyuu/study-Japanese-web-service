package com.study.Japanese.service.impl;

import com.study.Japanese.constants.CommonErrResult;
import com.study.Japanese.entity.dto.ExampleDTO;
import com.study.Japanese.entity.dto.PublicResult;
import com.study.Japanese.entity.po.ExamplePO;
import com.study.Japanese.mapper.ExampleMapper;
import com.study.Japanese.service.ExampleService;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExampleServiceImpl implements ExampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleServiceImpl.class);
    @Autowired
    private ExampleMapper exampleMapper;

    @Override
    public PublicResult<Integer> saveExample(ExampleDTO exampleDTO) {
        ExamplePO examplePO = new ExamplePO();
        BeanUtils.copyProperties(exampleDTO, examplePO);
        try {
            if ((examplePO.getId() == null && exampleMapper.insertSelective(examplePO) == 1)
                    || (examplePO.getId() != null && exampleMapper.updateByPrimaryKeySelective(examplePO) == 1)) {
                return PublicResult.success(examplePO.getId());
            }
        } catch (Exception e) {
            LOGGER.error("Save Example Failed.", e);
        }
        return PublicResult.error(CommonErrResult.OPERATE_FAIL);
    }

    @Override
    public PublicResult<?> deleteExample(int exampleId) {
        ExamplePO examplePO = new ExamplePO();
        examplePO.setId(exampleId);
        examplePO.setStatus(NumberUtils.SHORT_ZERO);
        try {
            if (exampleMapper.updateByPrimaryKeySelective(examplePO) == 1) {
                return PublicResult.success();
            }
        } catch (Exception e) {
            LOGGER.error("Delete Example Failed => {}", exampleId, e);
        }
        return PublicResult.error(CommonErrResult.OPERATE_FAIL);
    }

    @Override
    public List<ExampleDTO> findExamples(int grammarId) {
        ExamplePO examplePO = new ExamplePO();
        examplePO.setGrammarId(grammarId);
        examplePO.setStatus(NumberUtils.SHORT_ONE);
        Example example = new Example(ExamplePO.class);
        example.orderBy("id").desc();
        example.createCriteria().andEqualTo("grammarId", grammarId)
                .andEqualTo("status", NumberUtils.SHORT_ONE);
        return exampleMapper.selectByExample(example).stream().map(examplePO1 -> {
            ExampleDTO exampleDTO = new ExampleDTO();
            BeanUtils.copyProperties(Objects.requireNonNull(examplePO1), exampleDTO);
            return exampleDTO;
        }).collect(Collectors.toList());
    }
}
