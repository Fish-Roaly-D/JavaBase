package com.roily.booknode.javatogod._11thread.threadLocal;

/**
 * @author rolyfish
 */
public class SerialNum {
    // The next serial number to be assigned
    private static int nextSerialNum = 0;
    private static ThreadLocal<Integer> serialNum = ThreadLocal.withInitial(() ->
            {
                synchronized (SerialNum.class) {
                    return nextSerialNum++;
                }
            }
    );

    public static int get() {
        return serialNum.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("当前线程：" + Thread.currentThread().getName()+"   序列号：" + SerialNum.get());
            }).start();
        }
    }
}
class SerialNum2 {
    // The next serial number to be assigned
    private static int nextSerialNum = 0;

    public static int get() {
        return nextSerialNum++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println("当前线程：" + Thread.currentThread().getName()+"   序列号：" + SerialNum2.get());
            }).start();
        }
    }
}