package com.study.Japanese.entity.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_example")
public class ExamplePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer grammarId;
    private String creator;
    private String content;
    private String meanChinese;
    private Short status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrammarId() {
        return grammarId;
    }

    public void setGrammarId(Integer grammarId) {
        this.grammarId = grammarId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMeanChinese() {
        return meanChinese;
    }

    public void setMeanChinese(String meanChinese) {
        this.meanChinese = meanChinese;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getStatus() {
        return status;
    }
}
