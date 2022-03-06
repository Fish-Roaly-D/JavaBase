package com.roily.test02;

import com.roily.util.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class ConnectionTest {

    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcConnectionUtil.getConn();
        System.out.println(conn);
        conn.close();
        JdbcConnectionUtil.CloseSource(conn,null,null);
    }
}
