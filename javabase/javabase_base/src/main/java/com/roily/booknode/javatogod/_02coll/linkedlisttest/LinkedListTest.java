package com.roily.booknode.javatogod._02coll.linkedlisttest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date: 2023/03/13/11:09
 * @Description:
 */
@Slf4j
public class LinkedListTest {

    /**
     * LinkedList也是一个浅拷贝,虽然内部的node节点不同，但是node节点里保存的数据指向同一个对象
     */
    @Test
    public void ShallowCopy() {

        StringBuilder sb1 = new StringBuilder("123");
        StringBuilder sb2 = new StringBuilder("abc");
        LinkedList<StringBuilder> list = new LinkedList<>(Arrays.asList(sb1, sb2));
        List<StringBuilder> clone = (LinkedList<StringBuilder>) list.clone();
        log.info("原集合：=>{}", list);

        for (StringBuilder sb : clone) {
            sb.append("clone");
        }
        log.info("修改副本对象,会影响原型对象,这是个浅拷贝：=>{}", clone);

    }


    static boolean method1(){
        System.out.println(1);
        return false;
    }
    static boolean method2(){
        System.out.println(2);
        return false;
    }


    public static void main(String[] args) {


        System.out.println(-2>>>1);
        System.out.println(2>>>1);

    }





}
