package com.roily.DelayQueueTest;

import lombok.Data;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description 订单超时自动取消连接
 * @ClassName DelayQueueDemo.java
 * @author: RoilyFish
 * @date: 2022/5/6 23:16
 */
public class DelayQueueDemo {


    //待取消订单队列
    static DelayQueue orderQueue = new DelayQueue<Order>();


    static Order makeOrder(String s) {


        return new Order(s);
    }

    public static void main(String[] args) throws InterruptedException {


        Thread addT1 = new Thread(() -> {
            //生成10个订单
            for (int i = 0; i < 10; i++) {

                while (!orderQueue.add(makeOrder(Thread.currentThread().getName() + i))) ;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程T1：");
        Thread addT2 = new Thread(() -> {
            //生成10个订单
            for (int i = 0; i < 10; i++) {

                while (!orderQueue.add(makeOrder(Thread.currentThread().getName() + i))) ;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程T2：");

        Thread getT = new Thread(() -> {
            while (true) {
                try {
                    if (orderQueue.size() > 0) {
                        Order first = null;
                        first = (Order) orderQueue.take();
                        System.out.println(first.getOrderNo() + "号订单被取消");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        addT1.start();
        addT2.start();
        getT.start();

    }

    public static void getOrder() {

    }

}

@Data
class Order implements Delayed {

    //订单创建时间
    private final Long createTime = System.currentTimeMillis();

    //默认订单，默认时间单位
    private static TimeUnit overTimeUnit = TimeUnit.MILLISECONDS;

    //默认超时时间
    private static Long delayedTime = 10000L;

    //订单编号
    private String orderNo;

    public Order(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        long delayTime = unit.convert(delayedTime - (System.currentTimeMillis() - createTime), overTimeUnit);

        return delayTime;
    }

    @Override
    public int compareTo(Delayed o) {

        return this.getDelay(overTimeUnit) >= o.getDelay(overTimeUnit) ? 1 : -1;

    }

}