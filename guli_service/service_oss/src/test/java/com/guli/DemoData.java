package com.guli;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty(value = "学生编号")
    private  Integer sno;
    @ExcelProperty(value = "学生姓名")
    private  String name;


}
