package com.study.Japanese.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.Japanese.constants.CommonErrResult;
import com.study.Japanese.entity.dto.GrammarDTO;
import com.study.Japanese.entity.dto.GrammarQueryDTO;
import com.study.Japanese.entity.dto.PublicResult;
import com.study.Japanese.entity.po.GrammarPO;
import com.study.Japanese.mapper.GrammarMapper;
import com.study.Japanese.service.GrammarService;
import org.apache.commons.lang3.StringUtils;
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
public class GrammarServiceImpl implements GrammarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GrammarServiceImpl.class);

    @Autowired
    private GrammarMapper grammarMapper;

    @Override
    public PublicResult<?> saveGrammar(GrammarDTO grammarDTO) {
        GrammarPO grammarPO = new GrammarPO();
        BeanUtils.copyProperties(grammarDTO, grammarPO);
        try {
            if ((grammarPO.getId() == null && grammarMapper.insertSelective(grammarPO) == 1)
                    || (grammarPO.getId() != null && grammarMapper.updateByPrimaryKeySelective(grammarPO) == 1)) {
                return PublicResult.success();
            }
        } catch (Exception e) {
            LOGGER.error("Save Grammar Failed.", e);
        }
        return PublicResult.error(CommonErrResult.OPERATE_FAIL);
    }

    @Override
    public PublicResult<?> deleteGrammar(int grammarId) {
        GrammarPO grammarPO = new GrammarPO();
        grammarPO.setId(grammarId);
        grammarPO.setStatus(NumberUtils.SHORT_ZERO);
        try {
            if (grammarMapper.updateByPrimaryKeySelective(grammarPO) == 1) {
                return PublicResult.success();
            }
        } catch (Exception e) {
            LOGGER.error("Delete Grammar Failed.", e);
        }
        return PublicResult.error(CommonErrResult.OPERATE_FAIL);
    }

    @Override
    public PageInfo<GrammarDTO> grammarPage(GrammarQueryDTO query) {
        return PageHelper.startPage(query.getCurrent(), query.getPageSize()).doSelectPageInfo(() -> findGrammarPage(query));
    }

    private List<GrammarDTO> findGrammarPage(GrammarQueryDTO query) {
        Example example = new Example(GrammarPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", NumberUtils.SHORT_ONE);
        example.and(criteria);
        if (StringUtils.isNotBlank(query.getLevel())) {
            criteria = example.createCriteria();
            criteria.andEqualTo("level", query.getLevel());
            example.and(criteria);
        }
        if (StringUtils.isNotBlank(query.getGrammar())) {
            criteria = example.createCriteria();
            criteria.orLike("grammar", "%" + query.getGrammar() + "%")
                    .orLike("grounding", "%" + query.getGrammar() + "%")
                    .orLike("occasion", "%" + query.getGrammar() + "%")
                    .orLike("meanChinese", "%" + query.getGrammar() + "%");
            example.and(criteria);
        }
        return grammarMapper.selectByExample(example).stream().map(grammarPO1 -> {
            GrammarDTO grammarDTO = new GrammarDTO();
            BeanUtils.copyProperties(Objects.requireNonNull(grammarPO1), grammarDTO);
            return grammarDTO;
        }).collect(Collectors.toList());
    }

}
