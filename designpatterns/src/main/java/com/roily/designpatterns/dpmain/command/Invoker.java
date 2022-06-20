package com.roily.designpatterns.dpmain.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：Invoker
 * @author: rolyfish
 * @description: 命令发出者，老板
 * @dte: 2022/6/20 12:08
 */
public class Invoker {
    /**
     * 老板将一个项目拆分为许多模块，每个模块就是一个命令
     */
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command){
        System.out.println("添加任务");
        commandList.add(command);
    }
    public void delCommand(Command command){
        System.out.println("移除任务");
        commandList.remove(command);
    }

    public void doCommand(){
        //完成任务
        commandList.forEach(Command::execute);
    }
}
