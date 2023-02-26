package com.study.Japanese.entity.dto;

public class GrammarQueryDTO extends PageQueryDTO {
    private Integer id;
    private String grammar;
    private String level;
    private String grounding;
    private String occasion;
    private String meanChinese;
    private String point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrammar() {
        return grammar;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGrounding() {
        return grounding;
    }

    public void setGrounding(String grounding) {
        this.grounding = grounding;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getMeanChinese() {
        return meanChinese;
    }

    public void setMeanChinese(String meanChinese) {
        this.meanChinese = meanChinese;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
