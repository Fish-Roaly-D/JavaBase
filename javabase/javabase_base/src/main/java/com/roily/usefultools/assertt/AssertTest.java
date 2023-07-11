package com.roily.usefultools.assertt;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @className：AssertTest
 * @author: rolyfish
 * @description: AssertTest 断言
 * @dte: 2022/6/22 23:43
 */
public class AssertTest {


    /**
     * 断言为空或不为空
     * - 对象
     * - 集合
     * - map
     */
    @Test
    public void testIsNull() {
        String str = null;
        Assert.notNull(str, "参数不可以为空");
        Assert.isNull(str, "参数必须为空");
        Lists.newArrayList(1, 2, 3, 4);
        Assert.notEmpty((Object[]) null, "不可以为空");
    }

    /**
     * 断言布尔值
     */
    @Test
    public void assertBoolean() {
        final List<Object> list = Lists.newArrayList();
        Assert.isTrue(!list.isEmpty(), "集合不可以为空");
    }

    /**
     * 断言是否符合类型
     */
    @Test
    public void assertInstance() {
        Assert.isInstanceOf(Integer.class, "abc", "类型不匹配");

        Assert.isAssignable(String.class, Object.class);
    }

    /**
     * 断言类型是否可以强转
     * - 存在父子关系
     * - 接口和其实现类
     */
    @Test
    public void assertAssignable() {
        //通过
        Assert.isAssignable(List.class, ArrayList.class, "不可强转");
        //通过
        Assert.isAssignable(Object.class, ArrayList.class,()->"不可强转");
        //可以
        Assert.isAssignable(Collection.class, List.class);
        //可以
        Assert.isAssignable(Collection.class, ArrayList.class);
        //不通过
        Assert.isAssignable(List.class, Object.class);
    }

}
