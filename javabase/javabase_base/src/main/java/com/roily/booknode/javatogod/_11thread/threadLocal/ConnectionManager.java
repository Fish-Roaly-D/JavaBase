package com.roily.booknode.javatogod._11thread.threadLocal;

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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: rolyfish
 */
public class ConnectionManager {
    private static Connection connect = null;

    public static Connection openConnection() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmdp?useSSL=false&serverTimezone=UTC", "root", "123456");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return ConnectionManager.connect;
    }

    public static void closeConnection() {
        if (ConnectionManager.connect != null) {
            try {
                ConnectionManager.connect.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final Connection connection = openConnection();
        // 关闭链接， 下面报异常
        closeConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("select  * from tb_user");
        final ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }


    }

    @Test
    public void test() throws Exception {

        Runnable r1 = () -> {
            final Connection connection = openConnection();
            // 关闭链接， 下面报异常
            closeConnection();
            try {
                for (int i = 0; i < 100; i++) {
                    final PreparedStatement preparedStatement = connection.prepareStatement("select  * from tb_user");
                    final ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(2));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            while (true) {
                closeConnection();
            }
        };
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), (r) -> {
            //线程名前缀
            String namePrefix = "线程：";
            Thread t = new Thread(null, r, namePrefix + Thread.currentThread(), 0);
            //设置为费守护线程
            t.setDaemon(false);
            return t;
        });
        executorService.execute(r1);
        executorService.execute(r2);
        Thread.sleep(6000);
        executorService.shutdown();

    }

}
