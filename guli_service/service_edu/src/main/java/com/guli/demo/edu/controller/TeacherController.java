package com.guli.demo.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.commonutils.R;
import com.guli.demo.edu.entity.Teacher;
import com.guli.demo.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-08-15
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public R findAll(){
        List<Teacher> teachers = teacherService.findAll();
        return R.ok().data("items",teachers);
    }
    @DeleteMapping("{id}")
    public R removeTeacher(@PathVariable String id){
        boolean remove = teacherService.removeById(id);
        if (remove){
            return R.ok();
        }
        return  R.error();
    }


    @GetMapping("pageTeaccher/{current}/{limit}")
    public R pageTeacher(@PathVariable Long current,@PathVariable Long limit){

        // 创建page对象
        Page<Teacher> page = new Page<>(current, limit);
        teacherService.page(page, null);
        long total = page.getTotal();// 总数据数
        List<Teacher> records = page.getRecords(); // 数据集合
        return R.ok().data("total",total).data("records",records);
    }
}

