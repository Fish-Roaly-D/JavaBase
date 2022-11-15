package com.roily.booknode.javatogod._06serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @classname：ClassExternalizable
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/30 01:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassExternalizable implements Externalizable {


    String value;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = (String) in.readObject();
    }


    @Test
    public void test2() {
        String filePath = "/Users/rolyfish/Desktop/MyFoot/foot/testfile";
        final ClassExternalizable classExternalizable = new ClassExternalizable();
        classExternalizable.setValue("ClassExternalizable");
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File(filePath, ClassExternalizable.class.getSimpleName() + ".txt")))) {
            objectOutputStream.writeObject(classExternalizable);
            objectOutputStream.flush();
        } catch (IOException e) {
        }

        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(new File(filePath, ClassExternalizable.class.getSimpleName() + ".txt")))) {
            final Object o = objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
