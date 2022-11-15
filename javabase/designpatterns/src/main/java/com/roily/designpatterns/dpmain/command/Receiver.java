package com.roily.designpatterns.dpmain.command;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @className：Receiver
 * @author: rolyfish
 * @description: 命令接收者，具体员工
 * @dte: 2022/6/20 12:06
 */
@Data
@Accessors(chain = true)
public class Receiver {

    String name;

    public void doWork() {
        System.out.println(this.name + "完成任务");
    }

}
