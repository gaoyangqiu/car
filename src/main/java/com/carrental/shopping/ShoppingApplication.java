package com.carrental.shopping;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@MapperScan("com.carrental.dao")
@SpringBootApplication(scanBasePackages = "com.carrental")
public class ShoppingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShoppingApplication.class, args);

    }


}
