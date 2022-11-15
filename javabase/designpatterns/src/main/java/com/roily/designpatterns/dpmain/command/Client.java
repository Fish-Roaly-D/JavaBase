package com.roily.designpatterns.dpmain.command;

/**
 * @className：Client
 * @author: rolyfish
 * @description: 测试
 * @dte: 2022/6/20 12:14
 */
public class Client {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();

        Receiver receiver1 = new Receiver().setName("employee01");
        Receiver receiver2 = new Receiver().setName("employee02");
        Receiver receiver3 = new Receiver().setName("employee03");
        Receiver receiver4 = new Receiver().setName("employee04");

        Command command1 = new ConcreteCommand(receiver1);
        Command command2 = new ConcreteCommand(receiver2);
        Command command3 = new ConcreteCommand(receiver3);
        Command command4 = new ConcreteCommand(receiver4);

        invoker.addCommand(command1);
        invoker.addCommand(command2);
        invoker.addCommand(command3);
        invoker.addCommand(command4);

        invoker.doCommand();
    }
}
