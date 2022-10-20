package com.roily.abstractandinterface.abs;

/**
 * @classname：AbstratPerson
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/20 20:50
 */
public abstract  class AbstractPerson {

    /**
     * 一个人有哪些功能？
     * 吃喝拉撒睡,所有人都会有的功能，那么我们就可以定义为一个具体的方法，所有子类都可以使用（实现代码的复用）
     */
    public void base(){
        System.out.println("吃喝 啦撒");
    }

    /**
     * 除了吃喝啦撒，每个人都有自己的任务或者工作吧
     *
     * 那么每个人的工作是不同的，所以就需要定义抽象方法给具体子类去实现
     */
    abstract void work();

}
