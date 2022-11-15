package com.roily.designpatterns.dpmain.memento;

/**
 * @className：Memento
 * @author: rolyfish
 * @description: 备忘录，保存状态
 * @dte: 2022/6/20 12:44
 */
public class Memento {

    String state;

    public Memento(String state, String value) {
        this.state = state;
        SignalDatabase.getInstance().add(state, value);
    }

    public String getState() {
        return state;
    }

    /**
     * 更改某个状态的值
     *
     * @param value
     */
    public void setState(String value) {
        SignalDatabase.getInstance().add(state, value);
    }

    public Original reStore() {
        Object value = SignalDatabase.getInstance().getValue(state);
        return new Original(state, (String) value);
    }
}
