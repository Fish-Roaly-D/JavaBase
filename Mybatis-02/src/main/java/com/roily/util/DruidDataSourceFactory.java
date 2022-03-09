package com.roily.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/9
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {


    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init(); //初始化Druid数据源
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return this.dataSource;
    }
}
