package com.roily.designpatterns.dpmain.memento;

/**
 * @className：Clinet
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/20 13:08
 */
public class Client {

    public static void main(String[] args) {

        CareMaker careMaker = new CareMaker();

        Original original1 = new Original("#01", "状态一");
        System.out.println("original1" + "原始状态：=>" + original1);
        //保存状态
        careMaker.store(original1.createMemento());
        original1.setValue("状态一被修改");
        original1.setState("#011");
        System.out.println("original1" + "状态被修改：=>" + original1);

        original1.resStore(careMaker.getMemento(0));
        System.out.println("original1" + "状态恢复：=>" + original1);

//        Original original2 = new Original("#02", "状态二");
//        Original original3 = new Original("#03", "状态三");


    }

}
