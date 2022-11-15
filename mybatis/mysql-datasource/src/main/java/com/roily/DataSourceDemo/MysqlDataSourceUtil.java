package com.roily.DataSourceDemo;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/7
 */
public class MysqlDataSourceUtil {

    private static DataSource dataSource;

    static {
        InputStream in = MysqlDataSourceUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();

        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setUrl(prop.getProperty("url"));
        ((MysqlDataSource) dataSource).setUser(prop.getProperty("username"));
        ((MysqlDataSource) dataSource).setPassword(prop.getProperty("password"));

    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, Statement state, ResultSet rs){

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (state!=null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
