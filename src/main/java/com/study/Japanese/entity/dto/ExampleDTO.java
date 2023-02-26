package com.study.Japanese.entity.dto;


public class ExampleDTO {
    private Integer id;
    private Integer grammarId;
    private String creator;
    private String content;
    private String meanChinese;

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
}
