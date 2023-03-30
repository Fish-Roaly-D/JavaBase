package com.roily.database.mysql;

import cn.hutool.core.date.DateTime;
import com.roily.booknode.javatogod._11thread.threadLocal.ConnectionManager;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @Date: 2023/03/30/16:29
 * @Description:
 */
public class MysqlDataTypeTest {

    @Test
    public void test1() throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_database?useSSL=false&serverTimezone=UTC", "root", "123456");


        final PreparedStatement preparedStatement = connect.prepareStatement("insert into user(id,date1,date2) values(?,?,?)");

        preparedStatement.setInt(1, 3333);
        preparedStatement.setDate(2, new Date(13));
        preparedStatement.setTimestamp(3, new Timestamp(DateTime.now().getTime()));

        preparedStatement.execute();


        final PreparedStatement preparedStatement1 = connect.prepareStatement("insert into user(id,date1,date2) values(?,?,?)");

        preparedStatement1.setInt(1, 4444);
        preparedStatement1.setString(2, "2022-09-11 00:00:00");
        preparedStatement1.setString(3, "2022-09-11 00:00:00");

        preparedStatement1.execute();

    }


}
