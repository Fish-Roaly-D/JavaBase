package com.roily.designpatterns.dpmain.state;

/**
 * @className：StopState
 * @author: rolyfish
 * @description: todo
 * @dte: 2022/6/21 21:35
 */
public class StopState implements State{

    @Override
    public void doAction(Context context) {
        context.setState(this);
        System.out.println(this.getClass().getName());
    }

}
