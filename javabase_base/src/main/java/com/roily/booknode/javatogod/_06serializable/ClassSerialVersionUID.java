package com.roily.booknode.javatogod._06serializable;

import lombok.Data;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @classname：ClassSerialVersionUID
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/30 01:48
 */
@Data
public class ClassSerialVersionUID implements Serializable {

    private static final long serialVersionUID = 123123151L;

    String value;

    @Test
    public void testWrite() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        final ClassSerialVersionUID classSerialVersionUID = new ClassSerialVersionUID();
        classSerialVersionUID.setValue("classSerialVersionUID");
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, ClassSerialVersionUID.class.getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classSerialVersionUID);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testRead() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(new File(filePath, ClassSerialVersionUID.class.getSimpleName() + ".txt")))) {
            final ClassSerialVersionUID classSerialVersionUID = (ClassSerialVersionUID) objectInputStream.readObject();
            System.out.println(classSerialVersionUID);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
