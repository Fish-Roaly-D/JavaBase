package com.roily.thread_01;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/13
 */
public class classTest {

    //内部类
    class Student2 implements Person {

        public void say() {
            System.out.println("内部类");
        }
    }

    //静态内部类
    static class Student3 implements Person {

        public void say() {
            System.out.println("静态内部类");
        }
    }

    public static void main(String[] args) {
        //局部内部类
        class Student3 implements Person {
            public void say() {
                System.out.println("局部内部类");
            }
        }

        //匿名内部类
        Person p1 = new Person() {
            public void say() {
                System.out.println("匿名内部类");
            }
        };

        //lambda表达式  适用于函数式接口
        Person p2 = () -> System.out.println("lambda表达式");
    }
}

//外部类
class Student1 implements Person {

    public void say() {
        System.out.println("外部类");
    }


}

@FunctionalInterface
interface Person {

    static int a = 1;

    public void say();

    public static void add() {
        System.out.println(1);
    }

    public default int get() {
        return a;
    }

}

@FunctionalInterface
interface Person2 {

    public void say(String str1,String str2);
}

class tt{


    public static void main(String[] args) {

        Person2 person2 = (str1,str2) -> System.out.println(str1+"/n"+str2);

        person2.say("参数1","参数2");

    }
}
