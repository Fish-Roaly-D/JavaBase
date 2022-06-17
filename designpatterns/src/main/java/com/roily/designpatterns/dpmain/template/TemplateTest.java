package com.roily.designpatterns.dpmain.template;

import org.junit.Test;

/**
 * @className：TemplateTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 12:42
 */
public class TemplateTest {

    @Test
    public void test() {

        AbstractCollection linkedListCollection = new LinkedListCollection();
        //调用抽象夫类的模版方法，实现子类方法的调用
        System.out.println(linkedListCollection.getElement());
        AbstractCollection arrayListCollection = new ArrayListCollection();
        //调用抽象夫类的模版方法，实现子类方法的调用
        System.out.println(arrayListCollection.getElement());
    }


}
