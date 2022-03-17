package com.roily.synchronizedDemo;


public class SynchronizedBlockObj {

    private static Integer a = 0;

    public static void main(String[] args) throws InterruptedException {

        Money money = new Money();
        System.out.println(Money.money);
        for (int i = 0; i < 10; i++) {
            //Money money = new Money();
            new Thread(new MyRunAble(money)).start();
        }

        Thread.sleep(2000);
        System.out.println(Money.money);
    }

}

class Money {

    static Integer money = 0;

    //实例同步方法
    synchronized void add() {
        for (int i = 0; i < 10000; i++) {
            money++;
        }
    }

    //锁this
    public void add2() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                money++;
            }
        }
    }

}

class MyRunAble implements Runnable {

    private Money money;

    public MyRunAble(Money money) {
        this.money = money;
    }

    @Override
    public void run() {
        //money.add();
        money.add2();
    }
}