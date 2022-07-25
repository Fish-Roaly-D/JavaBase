package com.roily.list.arraylist;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @Description ArrayList总结
 * @ClassName ArrayListZJ.java
 * @author: RoilyFish
 * @date: 2022/5/10 20:17
 */
public class ArrayListZJ {

    /**
     *
     * 是一个可边长数组（Array)，当我们不知道元素个数的话，使用ArrayList
     *
     * 其扩容、remove元素、add指定下表元素都会调用Arrays.copyof方法，底层调用System.arrayCopy方法
     */
    //ArrayList有个非私有、且在ArrayList内部没有使用的方法
    @Test
    public void testEnsure(){
        ArrayList<Object> list = new ArrayList<>();
        //此刻我知道元素个数，大概为150个，那么我就可以使用ensureCapacity来一次性将数组容量扩够
        list.ensureCapacity(150);
    }


    /**
     * 如果我们知道所使用的ArrayList所需要的大概容量是多少的时候，
     * 我们可以在new出来的时候就确定其集合大小，这样就避免了数组的不必要扩容
     * 同时也可以调用ensureCapacity方法一次性将容量扩足
     */
}
