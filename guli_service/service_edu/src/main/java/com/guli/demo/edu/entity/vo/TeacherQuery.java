package com.guli.demo.edu.entity.vo;

import io.swagger.annotations.ApiModelProperty;

public class TeacherQuery {
    @ApiModelProperty(value = "讲师名字")
    private String name;
    @ApiModelProperty(value = "讲师级别")
    private Integer level;
    @ApiModelProperty(value = "创建时间")
    private String begin;
    @ApiModelProperty(value = "结束时间")
    private String end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
