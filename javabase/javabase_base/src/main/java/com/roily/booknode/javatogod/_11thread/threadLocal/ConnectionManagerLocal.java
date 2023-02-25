package com.roily.booknode.javatogod._11thread.threadLocal;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: rolyfish
 */
public class ConnectionManagerLocal {
    private Connection connect = null;

    public Connection openConnection() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmdp?useSSL=false&serverTimezone=UTC", "root", "123456");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connect;
    }
    public void closeConnection() {
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        final ConnectionManagerLocal connectionManagerLocal = new ConnectionManagerLocal();
        connectionManagerLocal.openConnection();
        connectionManagerLocal.closeConnection();
    }
}
