package com.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//do(接口 + 自动代理)数据访问对象层，domain数据表对象层
public class MybatisConfig {
    //配置mybatis环境
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {//此dataSource并不是JdbcConfig里面的dataSource，而是druid数据源里的。完全两个东西
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.domain");
        return sqlSessionFactoryBean;
    }
    //进行mapper映射
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapper = new MapperScannerConfigurer();
        mapper.setBasePackage("com.dao");
        return mapper;
    }
    @Bean //配置事务管理器的bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
