package com.guli.demo.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.guli.demo.edu.mapper")
public class EduConfig {

    /**
     * 逻辑删除
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        System.out.println("---------------------------------");
        return new PaginationInterceptor();
    }
}
