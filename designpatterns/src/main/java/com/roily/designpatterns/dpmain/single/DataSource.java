package com.roily.designpatterns.dpmain.single;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @version 1.0.0
 * @Description 数据源
 * @ClassName DataSource.java
 * @author: RoilyFish
 * @date: 2022/6/2 13:11
 */
public class DataSource {

    private Properties properties;

    private DataSource(Properties properties) {
        this.properties = properties;
    }

    /**
     * 获取数据源一般需要读取配置文件
     */

    //定义一个静态内部枚举类
    static enum DataSourceEnum{
        MYSQL;
        private DataSource dataSource;
        //默认私有
        DataSourceEnum() {
            System.out.println("读取配置");
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            try {
                prop.load(in);
                dataSource = new DataSource(prop);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DataSource getInstance(){
            return dataSource;
        }
    }

    public static DataSource getInstance(){
        return DataSourceEnum.MYSQL.getInstance();
    }
}
