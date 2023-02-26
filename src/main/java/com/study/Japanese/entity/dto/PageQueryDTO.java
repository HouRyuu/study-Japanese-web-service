package com.study.Japanese.entity.dto;

import org.apache.commons.lang3.math.NumberUtils;

public class PageQueryDTO {

    private Integer current = NumberUtils.INTEGER_ONE;
    private Integer pageSize = 10;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
