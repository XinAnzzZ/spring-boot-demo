package com.java.myh.configuration.druid;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 心安
 * @date 2018/5/30 14:31
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        List<com.alibaba.druid.filter.Filter> list = new ArrayList<>();
        list.add(new MySlf4jLogFilter().slf4jLogFilter());
        dataSource.setProxyFilters(list);
        return dataSource;
    }

    /**
     * @author 心安
     * @date 2018/5/31 14:33
     */
    private class MySlf4jLogFilter extends Slf4jLogFilter {
        Slf4jLogFilter slf4jLogFilter() {
            Slf4jLogFilter filter = new MySlf4jLogFilter();
            filter.setConnectionLogEnabled(false);
            filter.setResultSetLogEnabled(false);
            filter.setStatementParameterClearLogEnable(true);
            filter.setStatementExecutableSqlLogEnable(true);
            filter.setStatementCreateAfterLogEnabled(false);
            filter.setStatementPrepareAfterLogEnabled(false);
            filter.setStatementPrepareCallAfterLogEnabled(false);
            filter.setStatementExecuteAfterLogEnabled(false);
            filter.setStatementExecuteQueryAfterLogEnabled(false);
            filter.setStatementExecuteUpdateAfterLogEnabled(false);
            filter.setStatementExecuteBatchAfterLogEnabled(false);
            filter.setStatementCloseAfterLogEnabled(false);
            filter.setStatementParameterClearLogEnable(false);
            filter.setStatementParameterSetLogEnabled(false);
            return filter;
        }
    }
}
