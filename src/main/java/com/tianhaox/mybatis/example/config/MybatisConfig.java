package com.tianhaox.mybatis.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2016/12/15.
 */
@Configuration
@MapperScan(basePackages = {"com.tianhaox.mybatis.example.mapper"})
public class MybatisConfig {

}
