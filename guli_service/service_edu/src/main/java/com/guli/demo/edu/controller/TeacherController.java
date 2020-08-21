package com.guli.demo.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.commonutils.R;
import com.guli.demo.edu.entity.Teacher;
import com.guli.demo.edu.entity.vo.TeacherQuery;
import com.guli.demo.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@CrossOrigin
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
        Page<Teacher> pageTeacher = new Page<>(current, limit);
        teacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();// 总数据数
        List<Teacher> records = pageTeacher.getRecords(); // 数据集合
        return R.ok().data("total",total).data("records",records);
    }


//    @PostMapping("/pageTeacher/{current}/{limit}")
//    public R pageTeacherCondition(@PathVariable Long current,
//                                  @PathVariable Long limit,
//                                  @RequestBody(required = false) TeacherQuery teacherQuery){
//        // 创建 page对象
//        Page<Teacher> page = new Page<>(current, limit);
//        String name = teacherQuery.getName();
//        Integer level = teacherQuery.getLevel();
//        String begin = teacherQuery.getBegin();
//        String end = teacherQuery.getEnd();
//        // 构建条件
//        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
//        if(!StringUtils.isEmpty(name)){
//            // 构建条件
//            wrapper.like("name",name);
//        }
//        if(!StringUtils.isEmpty(level)){
//            wrapper.eq("level",level);
//        }
//        if(!StringUtils.isEmpty(begin)){
//            wrapper.ge("gmt_create",begin);
//        }
//        if(!StringUtils.isEmpty(end)){
//            wrapper.le("gmt_modified",end);
//        }
//        teacherService.page(page,wrapper);
//        long total = page.getTotal();// 总数据数
//        List<Teacher> records = page.getRecords(); // 数据集合
//
//        return R.ok().data("totle",total).data("rows",records);
//    }
//4 条件查询带分页的方法
@PostMapping("pageTeacherCondition/{current}/{limit}")
public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                              @RequestBody(required = false)  TeacherQuery teacherQuery) {
    //创建page对象
    Page<Teacher> pageTeacher = new Page<>(current,limit);

    //构建条件
    QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
    // 多条件组合查询
    // mybatis学过 动态sql
    String name = teacherQuery.getName();
    Integer level = teacherQuery.getLevel();
    String begin = teacherQuery.getBegin();
    String end = teacherQuery.getEnd();
    //判断条件值是否为空，如果不为空拼接条件
    if(!StringUtils.isEmpty(name)) {
        //构建条件
        wrapper.like("name",name);
    }
    if(!StringUtils.isEmpty(level)) {
        wrapper.eq("level",level);
    }
    if(!StringUtils.isEmpty(begin)) {
        wrapper.ge("gmt_create",begin);
    }
    if(!StringUtils.isEmpty(end)) {
        wrapper.le("gmt_create",end);
    }

    // 添加排序
    wrapper.orderByDesc("gmt_create");
    //调用方法实现条件查询分页
    teacherService.page(pageTeacher,wrapper);

    long total = pageTeacher.getTotal();//总记录数
    List<Teacher> records = pageTeacher.getRecords(); //数据list集合
    return R.ok().data("total",total).data("rows",records);
}
    @PostMapping("/addTeacher")
    public R addTeaccher(@RequestBody Teacher teacher){

        boolean save = teacherService.save(teacher);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/getTeacher/{id}")
    public R updateById(@PathVariable String id){
        Teacher teacher1 = teacherService.getById(id);

        return R.ok().data("teacher",teacher1);
    }
    @PostMapping("/update")
    public R update(@RequestBody Teacher teacher){
        boolean b = teacherService.updateById(teacher);
        if (!b){
            return R.error();
        }
        return R.ok();
    }
}

