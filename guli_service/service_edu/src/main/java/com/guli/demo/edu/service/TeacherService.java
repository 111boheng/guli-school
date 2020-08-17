package com.guli.demo.edu.service;

import com.guli.demo.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-08-15
 */
public interface TeacherService extends IService<Teacher> {
    public List<Teacher> findAll();
}
