package com.guli;

import com.alibaba.excel.EasyExcel;

import java.beans.DesignMode;
import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        // 实现Excel写操作
        // 设置写入文件地址和文件 名称
//        String filename = "C:\\Users\\lenovo\\Desktop\\write.xlsx";
//        EasyExcel.write(filename,DemoData.class).sheet("学生列表 ").doWrite(getList());


        //实现读操作
        String filename = "C:\\Users\\lenovo\\Desktop\\write.xlsx";
        EasyExcel.read(filename,DemoData.class,new MyExcelLisenter()).sheet().doRead();

    }

    private  static List<DemoData> getList(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            DemoData demoData = new DemoData();
//            demoData.setSno(i);
//            demoData.setName("hengheng "+i);
//            list.add(demoData);
        }
        return  list;

    }
}
