package com.roily.booknode.javatogod._01faceobj;

/**
 * @classname：ImplementInterface
 * @author: rolyfish
 * @description: 实现
 * @date: 2022/7/28 22:57
 */
public class ImplementInterface {



}

/**
 * 可以实现一个接口
 */
interface IPerson{
    /**
     * 抽象方法
     */
    void method();
}
class Teacher implements IPerson{

    @Override
    public void method() {

    }
}

/**
 * 可以是类实现抽象类的抽象方法
 */
abstract class AbstractPerson{

    abstract void method();

}
class StudentImpl extends AbstractPerson{

    @Override
    void method() {

    }
}

/**
 * 可以是抽象类实现接口
 */
abstract class AbstractPersonX implements IPerson{
    @Override
    public void method() {

    }
}