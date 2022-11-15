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
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * @classname：ClassCustomizeSerializable
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/30 02:13
 */
@Data
public class ClassCustomizeSerializable implements Serializable {
    private static final long serialVersionUID = 2936590571416558935L;

    transient Date date;

    String value;

    private void writeObject(ObjectOutputStream out)
            throws java.io.IOException {
        out.writeObject(Optional.ofNullable(date).orElse(Calendar.getInstance().getTime()));
        out.writeObject(value);
    }

    private void readObject(ObjectInputStream in)
            throws java.io.IOException, ClassNotFoundException {
        final Object o1 = in.readObject();
        final Object o2 = in.readObject();
        date = (Date) ((o1 instanceof Date) ? o1 : o2);
        value = (String) ((o1 instanceof String) ? o1 : o2);
    }

    @Test
    public void test() {

        final ClassCustomizeSerializable classCustomizeSerializable = new ClassCustomizeSerializable();
        classCustomizeSerializable.setValue("classCustomizeSerializable");
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";

        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, ClassCustomizeSerializable.class.getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classCustomizeSerializable);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(new File(filePath, ClassCustomizeSerializable.class.getSimpleName() + ".txt")))) {
            ClassCustomizeSerializable o = (ClassCustomizeSerializable) objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
