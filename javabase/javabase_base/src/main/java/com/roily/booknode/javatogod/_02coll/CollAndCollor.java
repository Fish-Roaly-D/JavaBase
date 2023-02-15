package com.roily.booknode.javatogod._02coll;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @classname：CollAndCollor
 * @author: rolyfish
 * @description: Collection  和     Collectors
 * @date: 2022/8/8 23:34
 */
public class CollAndCollor {

    /**
     * Collectors是一个包装类，包装了对集合的操作，构造函数私有且没有getInstance方法，不可以被实例化
     */
    @Test
    public void test() {

        final List<String> list1 = Arrays.asList("a", "ab", "abc", "abcd", "abcd");
        final List<String> list2 = Arrays.asList("1", "12", "123", "1234", "1234");

        //过滤出符合结果，转化为list  默认ArrayList
        List<String> collect1 = list1.stream().filter("a"::equals).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        //转化set默认hashSet
        final Set<String> collect2 = list1.stream().collect(Collectors.toSet());
        collect2.forEach(System.out::println);

        //转化 自定义集合
        final LinkedList<String> collect3 = list1.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));
        //lambda表达式写法
        final LinkedList<String> collect4 = list1.stream().collect(Collectors.toCollection(LinkedList::new));
        //
        //final Map<String, Integer> map1 = list1.stream().collect(Collectors.toMap(String::toString, String::length));
        //System.out.println(map1);

        //转化为map，需要指定keyMapper  valueMapper 两者都是Function接口实现类,如果key值存在重复元素，需要手动合并
        final Map<String, Integer> map2 = list1.stream().collect(Collectors.toMap(String::toString, String::length, Integer::sum));
        System.out.println(map2);
        //可以转话指定map
        final Map<String, Integer> map3 = list1.stream().collect(Collectors.toMap(String::toString, String::length, Integer::sum, LinkedHashMap::new));
        System.out.println(map3);

        //转化集合后，可以再操作一次
        final Set<String> collect5 = list1.stream().collect(Collectors.collectingAndThen(Collectors.toList(),
                (list -> list.stream().filter("abc"::contains).collect(Collectors.collectingAndThen(Collectors.toSet(),(HashSet::new))))));
        collect5.forEach(System.out::println);

        //将元素以字符串形式拼接
        final String joinResult = list1.stream().collect(Collectors.joining(",", "<", ">"));
        System.out.println(joinResult);

        //结合元素个数
        final Long size = list1.stream().collect(Collectors.counting());
        System.out.println(size);

        //统计  最大值  最小值  平局
        final IntSummaryStatistics intSummaryStatistics = list1.stream().collect(Collectors.summarizingInt(String::length));
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());

        //分组
        final Map<Integer, List<String>> map = list1.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println(map);

        //特殊分组，以boolean作为map的key
        final Map<Boolean, List<String>> map1 = list1.stream().collect(Collectors.partitioningBy(ele -> ele.length() > 2
        ));
        System.out.println(map1);


    }


}
