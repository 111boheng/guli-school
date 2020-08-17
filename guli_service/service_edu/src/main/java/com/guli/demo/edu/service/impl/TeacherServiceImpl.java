package com.guli.demo.edu.service.impl;

import com.guli.demo.edu.entity.Teacher;
import com.guli.demo.edu.mapper.TeacherMapper;
import com.guli.demo.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-08-15
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    public List<Teacher> findAll(){
        List<Teacher> teachers = teacherMapper.selectList(null);
        return teachers;
    }
}
