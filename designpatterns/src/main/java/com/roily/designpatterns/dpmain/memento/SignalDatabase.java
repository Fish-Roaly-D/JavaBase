package com.roily.designpatterns.dpmain.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * @className：SignalDatabase
 * @author: rolyfish
 * @description: 使用单例模拟数据库
 * @dte: 2022/6/20 12:46
 */
public class SignalDatabase {

    private Map<String, Object> map = new HashMap<>();

    private static class SingletonHolder {
        private static final SignalDatabase signalDatabase = new SignalDatabase();
    }

    private SignalDatabase() {
    }

    public static SignalDatabase getInstance() {
        return SingletonHolder.signalDatabase;
    }

    /**
     * 保存状态
     *
     * @param state
     * @param value
     */
    void add(String state, Object value) {
        map.put(state, value);
    }

    Object getValue(String state) {
        return map.get(state);
    }
}
