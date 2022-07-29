package com.roily.booknode.javatogod._01faceobj.extendsiscompile;

/**
 * @Date: 2022/07/29/16:32
 * @Description:
 * - 没有构造函数，创建默认无参构造
 * - 有构造函数，就不会创建无参构造
 */
public class ConstructorTest {
    int i;
    String str;
}

class ConstructorTest2 {
    int i;
    String str;
    public ConstructorTest2(int i) {
        this.i = i;
    }
}