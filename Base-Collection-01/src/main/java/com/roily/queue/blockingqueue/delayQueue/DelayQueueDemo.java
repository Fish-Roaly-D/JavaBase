package com.roily.queue.blockingqueue.delayQueue;

import lombok.Data;

import java.util.Objects;
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
    static DelayQueue<Order> orderQueue = new DelayQueue<>();


    public static void main(String[] args) throws InterruptedException {


        Thread addT = new Thread(() -> {
            //不停生成订单
            String orderNo = "YYC" + System.currentTimeMillis();
            long delayTime = 0L;
            while (true) {
                //随机生成延时时间
                delayTime = (long) (Math.random() * 10) * 1000;
                //生成订单
                Order order = new Order(orderNo, delayTime);
                if (orderQueue.add(order)) {
                    try {
                        System.out.println(order.getOrderNo()+"号订单添加到队列，等待时长为=>"+order.getDelay());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                orderNo = "YYC" + System.currentTimeMillis();
            }


        }, "线程T1：");

        Thread takeT = new Thread(() -> {
            //不停取

            while (true) {
                try {
                    Order order = orderQueue.take();
                    System.out.println(order.getOrderNo() + "号订单被取消");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "线程T2：");

        takeT.start();

        addT.start();
        //主线程一直运行
        while (true);

    }

    //模拟支付完成 退出等待队列
    public static void removeOrder() {
        String hadPay = "线程T2：1";
        //线程T2：9
        orderQueue.remove(new Order(hadPay,0l));

        System.err.println(hadPay + "号订单已经完成支付、退出等待队列");
    }
}

@Data
class Order implements Delayed {

    //订单创建时间
    private final Long createTime = System.currentTimeMillis();

    //默认订单，默认时间单位
    private static TimeUnit overTimeUnit = TimeUnit.MILLISECONDS;

    //超时时间
    private Long delayedTime;

    //订单编号
    private String orderNo;

    public Order(String orderNo, Long delayedTime) {
        this.orderNo = orderNo;
        this.delayedTime = delayedTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        long delayTime = unit.convert(delayedTime - (System.currentTimeMillis() - createTime), overTimeUnit);

        return delayTime;
    }

    public long getDelay() {
        return getDelay(overTimeUnit);
    }

    @Override
    public int compareTo(Delayed o) {

        return this.getDelay(overTimeUnit) >= o.getDelay(overTimeUnit) ? 1 : -1;

    }

}