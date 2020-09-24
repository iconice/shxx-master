package com.sjht.school.common.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 分页返回实体
 * @version V1.0
 * @date 2018年7月11日
 * @author maojianyun
 */
public class PageResult<T> implements Serializable {
	
    private List<T> rows;

    private Long total;

    public List getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public  PageResult resultPage(List rows , Long total) {
        this.total = total;
        this.rows = rows;
        return this;
    }
}
