package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @className：ConnectionPoll
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 21:27
 */
public class ConnectionPoll {

    /**
     * 内部属性
     */
    private static String userName = "RolyFish";

    /**
     * 内部属性
     */
    private static String passWord = "123";

    private Integer pollSiz = 10;

    private ConcurrentLinkedQueue<IConnection> poll = new ConcurrentLinkedQueue<>();

    {
        //初始化连接池
        for (int i = 0; i < 3; i++) {
            poll.add(new MyConnection(10, passWord, userName, this));
        }
    }

    public IConnection getConnection(Integer timeOut) {
        if (poll.size() > 0) {
            return poll.remove();
        } else {
            poll.add(this.createInstance(timeOut));
            return getConnection(timeOut);
        }
    }

    public void add(IConnection connection){
        poll.add(connection);
    }
    public IConnection getConnection() {
        return getConnection(10);
    }

    private IConnection createInstance(Integer timeOut) {
        return new MyConnection(timeOut, ConnectionPoll.userName, ConnectionPoll.passWord, this);
    }

    private IConnection createInstance() {
        return createInstance(10);
    }
}
