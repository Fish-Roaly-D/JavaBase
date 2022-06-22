package com.roily.usefultools.assertt;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.Assert;

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
        String str= null;
        Assert.notNull(str,"参数不可以为空");
        Assert.isNull(str,"参数必须为空");

        Lists.newArrayList(1,2,3,4);
        Assert.notEmpty((Object[]) null,"不可以为空");
    }


}
