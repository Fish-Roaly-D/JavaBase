package com.roily.map.linkedhashmap;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0.0
 * @Description 有序性：插入、当前最晚未被使用
 * @ClassName Simple01.java
 * @author: RoilyFish
 * @date: 2022/4/25 21:33
 */
public class Simple01 {

    /**
     * 在开始前呢，我们理解一下，LinkedHashMap为什么出现？
     * 因为hashMap作为'散列表'，他的读取顺序与我们存放顺序是不同的
     * 实际应用中，我们往往需要一个有序的map。
     */

    //hashMap存储元素，根据key的哈希值散列，是无序的
    @Test
    public void test1() {
        Map<Object, Object> map = new HashMap<>();
        map.put("b", "b");
        map.put("a", "a");
        map.put(2, 2);
        map.put(1, 1);
        map.put(null, null);
        map.forEach((key, value) -> {

            System.out.println("key:" + key + "  " + "value:" + value);
        });
    }


    /**
     * LinkedHashMap是有序的
     */
    @Test
    public void test01() {

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.forEach((key, value) -> {
            System.out.println("{key:"+key+","+"value:"+value+"}");
        });
    }


    /**
     * Map的replaceAll方法
     */
    @Test
    public void testReplaceAll() {

        Map<Object, Object> map = new HashMap<>();
        map.put("b", "b");
        map.put("a", "a");
        map.put(2, null);
        map.put(1, null);
        map.put(null, null);
        //替换所有value值为null的节点，为字符串"defult"

        map.replaceAll((key, value) -> {
            Object obj = (value == null) ? "default" : value;
            return obj;
        });

        map.forEach((key, value) -> {
            System.out.println("key:" + key + "  " + "value:" + value);
        });
    }

    /**
     * LinkedHashMap的有序性：
     * ①插入顺序
     * ②当前最晚未被访问（当元素被访问时，会将元素移到链表尾部）
     */
    @Test
    public void testAfterAccess() {

        Map<String, Object> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.put("e", "e");

        //直接遍历是按插入顺序遍历的
        //map.forEach((key,value)->{
        //    System.out.println("key=>"+key+"    "+"value=>"+value);
        //});

        //执行访问操作，被访问节点会移动到，双向链表尾部。
        map.get("b");
        map.get("a");

        map.forEach((key, value) -> {
            System.out.println("key=>" + key + "    " + "value=>" + value);
        });

    }


    @Test
    public void foreachWay() {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.put("e", "e");

        //直接遍历是按插入顺序遍历的
        map.forEach((key, value) -> {
            System.out.println("key=>" + key + "    " + "value=>" + value);
        });

        //实现 collection接口
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        System.out.println("==========collection提供的Stream  api==========");
        entries.stream().forEach((entry) -> {
            System.out.println("key=>" + entry.getKey() + "    " + "value=>" + entry.getValue());
        });

        System.out.println("==========iterable 提供的 foreach方法==========");
        entries.forEach((entry) -> {
            System.out.println("key=>" + entry.getKey() + "    " + "value=>" + entry.getValue());
        });

        System.out.println("==========for循环==========");
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println("key=>" + entry.getKey() + "    " + "value=>" + entry.getValue());
        }

        System.out.println("==========迭代器==========");
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("==========以上都是通过双向链表遍历的，我们知道hashMap还有一个分离器也是可以遍历的==========");

        Spliterator<Map.Entry<String, Object>> spliterator = map.entrySet().spliterator();

        System.out.println("//方式一");
        //while (spliterator.tryAdvance((entry)->{
        //    System.out.println(entry);
        //}));

        System.out.println("//方式二");
        spliterator.forEachRemaining((entry)->{
            System.out.println(entry);
        });

    }

}
