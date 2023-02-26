package com.study.Japanese.service;

import com.github.pagehelper.PageInfo;
import com.study.Japanese.entity.dto.GrammarDTO;
import com.study.Japanese.entity.dto.GrammarQueryDTO;
import com.study.Japanese.entity.dto.PublicResult;

public interface GrammarService {

    PublicResult<?> saveGrammar(GrammarDTO grammarDTO);

    PublicResult<?> deleteGrammar(int grammarId);

    PageInfo<GrammarDTO> grammarPage(GrammarQueryDTO query);

}
