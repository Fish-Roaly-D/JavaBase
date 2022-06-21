package com.roily.designpatterns.dpmain.state;

/**
 * @className：StateTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/21 21:39
 */
public class StateTest {

    public static void main(String[] args) {

        final Context context = new Context();

        final State startState = new StartState();

        final State stopState = new StopState();

        startState.doAction(context);
        stopState.doAction(context);

    }
}
