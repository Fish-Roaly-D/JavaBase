package com.roily.booknode.javatogod._11thread.threadLocal;

import cn.hutool.db.ThreadLocalConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: rolyfish
 */
public class ConnectionManagerThreadLocal {

    private static final ThreadLocal<Connection> CONNECTION_LOCAL = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmdp?useSSL=false&serverTimezone=UTC", "root", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });

    public static Connection openConnection() {
        return CONNECTION_LOCAL.get();
    }


    public static void main(String[] args) {
        AtomicInteger no = new AtomicInteger();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), (r) -> {
            //线程名前缀
            String namePrefix = "线程：";
            Thread t = new Thread(null, r, namePrefix + no.getAndIncrement(), 0);
            //设置为费守护线程
            t.setDaemon(false);
            //设置线程优先级为5
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        });
        executorService.execute(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName() + Thread.currentThread().hashCode());
            final Connection connection = ConnectionManagerThreadLocal.openConnection();
            System.out.println("得到的连接：" + connection + "哈希值：" + connection.hashCode());
        });
        executorService.execute(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName() + Thread.currentThread().hashCode());
            final Connection connection = ConnectionManagerThreadLocal.openConnection();
            System.out.println("得到的连接：" + connection + "哈希值：" + connection.hashCode());
        });
        executorService.shutdown();
    }
}
