package com.roily.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class  JdbcConnectionUtil {
    private static String url;
    private static String userName;
    private static String pass;
    private static String driver;
    private static Connection conn;

    static {
        InputStream in = JdbcConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();
        try {
            //配置加载进prop
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //初始化配置
        driver = prop.getProperty("driver");
        userName = prop.getProperty("username");
        pass = prop.getProperty("passwd");
        url = prop.getProperty("url");
        //加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
             conn = DriverManager.getConnection(url,userName,pass);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    public static void CloseSource(Connection conn, Statement statement, ResultSet resultSet){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
