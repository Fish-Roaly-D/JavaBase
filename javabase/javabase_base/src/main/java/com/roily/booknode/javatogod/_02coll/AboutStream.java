package com.roily.booknode.javatogod._02coll;

import com.google.common.base.Function;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author rolyfish
 * @Date: 2022/08/09/11:20
 * @Description:
 */
public class AboutStream {


    @Test
    public void test1() {
        System.out.println("===============流  转集合===============");
        List<String> list = new ArrayList<>(Arrays.asList("1", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        List<String> collect1 = list.stream().collect(Collectors.toList());
        collect1.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============遍历===============");
        list.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============过滤===============");
        List<String> collect2 = list.stream().filter((ele) -> ele.equals("2")).collect(Collectors.toList());
        collect2.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============映射===============");
        List<Integer> collect3 = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        collect3.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============求和 求平均值===============");
        int sum = list.stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

        System.out.println("===============去重===============");
        List<String> collect4 = list.stream().distinct().collect(Collectors.toList());
        collect4.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("===============判断===============");
        final boolean b1 = list.stream().allMatch(ele -> "2".equals(ele));
        final boolean b2 = list.stream().anyMatch(ele -> "2".equals(ele));
        System.out.println(b1 + " " + b2);
        System.out.println();

        System.out.println("===============获取option===============");
        String s1 = list.stream().findAny().get();
        String s2 = list.stream().findFirst().get();
        System.out.println(s1 + " " + s2);
        System.out.println();

        final List<StringBuilder> sbs = Arrays.asList(new StringBuilder(), new StringBuilder());
        System.out.println("===============对每一个元素进行操作===============");
        List<StringBuilder> collect5 = sbs.stream().peek(ele -> ele.append("123")).collect(Collectors.toList());
        collect5.stream().forEach(System.out::print);
        System.out.println();

    }

    @Test
    public void test2() {
        final Stream<String> stringStream = Stream.of("1", "2", "3");
        stringStream.filter("2"::equals);
        stringStream.forEach(System.out::println);
    }

    @Test
    public void test3() {

        final Stream<String> stringStream = Stream.of("1", "2", "3");
        final Stream<String> stringStreamFilter = stringStream.filter("2"::equals);
        stringStreamFilter.forEach(System.out::println);
    }

    @Test
    public void test4() {

        //通过集合类创建流
        final Collection<String> strings = Arrays.asList("1", "2", "3");
        final Stream<String> stream = strings.stream();

        //Stream创建流
        final Stream<String> stringStream = Stream.of("1", "2", "3");
        final Stream<String> a = Stream.of("a");

        //Arrays.stream(T[] t)
        final Stream<String> stream1 = Arrays.stream(new String[]{"1", "2", "3"});

        stream1.distinct().forEach(System.out::println);

    }


    @Test
    public void test5() {
        final StringBuffer sb1 = new StringBuffer("1");
        final StringBuffer sb2 = new StringBuffer("2");
        final StringBuffer sb3 = new StringBuffer("3");


        final Stream<StringBuffer> stream = Arrays.asList(sb1, sb2, sb3).stream();

        final HashMap<Object, Object> collect;

    }

    @Test
    public void test6() {
        final StringBuffer sb1 = new StringBuffer("1");
        final StringBuffer sb2 = new StringBuffer("2");
        final StringBuffer sb3 = new StringBuffer("3");


        final Stream<StringBuffer> stream = Arrays.asList(sb1, sb2, sb3).stream();

        final IntStream intStream = stream.mapToInt(StringBuffer::length);
        final DoubleStream doubleStream = stream.mapToDouble(StringBuffer::length);
        final LongStream longStream = stream.mapToLong(StringBuffer::length);

    }

    @Test
    public void testTwoList() {

        ArrayList<Person> people = new ArrayList<>();

        ArrayList<Name> names = new ArrayList<>();

        Person person1 = new Person();
        person1.setId(1);
        person1.setAge("12");
        Person person2 = new Person();
        person2.setId(2);
        person2.setAge("12");

        Name name1 = new Name();
        name1.setId(1);
        name1.setName("name1");

        Name name2 = new Name();
        name2.setId(2);
        name2.setName("name2");

        people.add(person1);
        people.add(person2);
        names.add(name1);
        names.add(name2);
        List<Object> collect = people.stream().map(person ->
                names.stream()
                        .filter(name -> {
                            return person.id == name.id;
                        })
                        .map(name -> {
                            person.setName(name.name);
                            return person;
                        }).collect(Collectors.toList())).flatMap(Collection::stream
        ).collect(Collectors.toList());

        System.out.println(collect);

    }

    /**
     * 想要在一个集合内匹配另一个集合信息
     */
    @Test
    public void testxx() {

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Name> names = new ArrayList<>();
        Person person1 = new Person();
        person1.setId(1);
        person1.setAge("12");
        Person person2 = new Person();
        person2.setId(2);
        person2.setAge("12");

        Name name1 = new Name();
        name1.setId(1);
        name1.setName("name1");
        Name name2 = new Name();
        name2.setId(2);
        name2.setName("name2");

        people.add(person1);
        people.add(person2);
        names.add(name1);
        names.add(name2);

        final HashMap<Object, Object> collect = names.stream().collect(HashMap::new, (map, name) -> {
            map.put(name.getId(), name);
        }, (r1, r2) -> {
            System.out.println(r1);
        });


        System.out.println(collect);


    }


    @Test
    public void eeee() {

        String str = "123" + "abc";
        String str2 = "123x";
        String str3 = "abcx";

    }

    void append(String str1, String str2) {
        String str3 = str1 + str2;
    }


    /**
     * 将多个Stream合并成一个Stream
     */
    @Test
    public void testFlatMap() {

        final List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 2));

        final List<Integer> collect = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());

        collect.forEach(System.out::print);

    }

    /**
     * 将多个Stream合并成一个Stream
     */
    @Test
    public void testFlatMaps() {
        final List<Integer> list1 = Arrays.asList(1, 2, 3);
        final List<String> list2 = Arrays.asList("1", "2", "3");
        final List<? extends List<? extends Serializable>> lists = Arrays.asList(list1, list2);
        final List<String> collect = lists.stream().flatMap(list ->
                list.stream().map(Object::toString)
        ).collect(Collectors.toList());
        collect.stream().forEach(System.out::print);
    }


    @Test
    public void testReduce() {
        final List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        //对集合进行聚合求值，e1首次为集合第一个参数，之后为return结果，e2为 2、3.。。。。
        final Optional<Integer> reduce1 = list1.stream().reduce(Integer::sum);
        System.out.println(reduce1.get());

        //reduce的重载，返回结果为T，e1首个为100
        final Integer reduce2 = list1.stream().reduce(100, Integer::sum);
        System.out.println(reduce2);

        //非并行流，只有一个线程，第三个参数BinaryOperator，可以忽略
        final StringBuilder reduce3 = list1.stream().reduce(new StringBuilder(), StringBuilder::append, (t, u) -> {
            int i = 0;
            return t;
        });
        System.out.println("非并行流" + reduce3);
        // final StringBuilder reduce4 = list1.parallelStream().reduce(new StringBuilder(), StringBuilder::append, (t, u) -> {
        //     u.append(t);
        //     return u;
        // });
        // System.out.println("并行流" + reduce4);


        final HashMap<String, Integer> map1 = list1.stream().collect(HashMap::new, (mapx, ele) -> {
            mapx.put(ele.toString(), ele);
        }, (a1, a2) -> {
        });
        System.out.println("非并行流，未addall" + map1);

        /**
         * 三个参数
         * Supplier 供应商，提供返回对象
         * BiConsumer  消费者  操作返回对象和流中的元素
         * BiConsumer  消费者  对并行流结果进行操作
         */
        final HashMap<String, Integer> map2 = list1.parallelStream().collect(HashMap::new, (mapx, ele) -> {
            mapx.put(ele.toString(), ele);
        }, (mapa, mapb) -> {
        });

        System.out.println("并行流，未addall" + map2);

        final HashMap<String, Integer> map3 = list1.parallelStream().collect(HashMap::new, (mapx, ele) -> {
            mapx.put(ele.toString(), ele);
        }, HashMap::putAll);
        System.out.println("并行流，addall" + map3);



    }


}
