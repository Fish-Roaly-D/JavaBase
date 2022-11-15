package com.roily.designpatterns.dpmain.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className：ConcreteCommand
 * @author: rolyfish
 * @description: 具体任务
 * @dte: 2022/6/20 12:12
 */
@Data
@AllArgsConstructor
public class ConcreteCommand implements Command {

    /**
     * 每个任务都有负责人
     */
    private Receiver receiver;

    @Override
    public void execute() {
        //具体负责人去完成任务
        receiver.doWork();
    }

}
