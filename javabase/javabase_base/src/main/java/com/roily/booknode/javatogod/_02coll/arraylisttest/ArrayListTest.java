package com.roily.booknode.javatogod._02coll.arraylisttest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date: 2023/03/10/16:00
 * @Description:
 */
@Slf4j
public class ArrayListTest {

    /**
     * - ArrayList利用Arrays.copyOf 利用System.ArrayCopy 进行浅拷贝
     * - modCount清零
     */
    @Test
    public void ShallowCopy() {

        StringBuilder sb1 = new StringBuilder("123");
        StringBuilder sb2 = new StringBuilder("abc");
        ArrayList<StringBuilder> arrayList = new ArrayList<>(Arrays.asList(sb1, sb2));
        final ArrayList<StringBuilder> clone = (ArrayList<StringBuilder>) arrayList.clone();
        log.info("原集合：=>{}", arrayList);

        for (StringBuilder sb : clone) {
            sb.append("clone");
        }
        log.info("修改副本对象,会影响原型对象,这是个浅拷贝：=>{}", arrayList);

    }

    /**
     * - ArrayList序列化
     */
    @Test
    public void serializeTest() {
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:1.txt"))) {
            objectOutputStream.writeObject(new ArrayList(Arrays.asList("a", "b", "c")));
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:1.txt"))) {
            final ArrayList<String> list = (ArrayList<String>) objectInputStream.readObject();
            log.info("{}",list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
