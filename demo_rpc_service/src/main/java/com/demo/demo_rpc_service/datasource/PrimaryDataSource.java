package com.demo.demo_rpc_service.datasource;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @program: springboot_demo
 * @description: 主数据源
 * @author: zhaoshouyun
 * @create: 2020-01-14 14:08
 **/
@Primary
@Configuration
@MapperScan(basePackages = {"com.demo.dao","com.demo.demo_rpc_service.mapper.one"} , sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataSource {

    @Bean(name = "DataSource_primary")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("DataSource_primary") DataSource dataSource)
            throws Exception{
      /*  SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);*/
        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
        mybatisPlus.setDataSource(dataSource);
        mybatisPlus.setVfs(SpringBootVFS.class);
        MybatisConfiguration mc = new MybatisConfiguration();
        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
      //数据库字段设计为驼峰命名，默认开启的驼峰转下划线会报错字段找不到
        mc.setMapUnderscoreToCamelCase(false);
        mybatisPlus.setConfiguration(mc);

        return mybatisPlus.getObject();
       // return bean.getObject();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("DataSource_primary") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        MybatisSqlSessionFactoryBuilder mybatisSqlSessionFactoryBuilder = new MybatisSqlSessionFactoryBuilder();
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
