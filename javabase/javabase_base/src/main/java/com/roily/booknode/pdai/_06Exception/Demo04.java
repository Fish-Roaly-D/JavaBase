package com.roily.booknode.pdai._06Exception;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2022/11/02/13:27
 * @Description: 自定义异常
 */
public class Demo04 {

    static class MyException extends RuntimeException {

        String code;
        String desc;

        public MyException() {
        }

        public MyException(String code, String desc) {
            super(desc);
            this.code = code;
            this.desc = desc;
        }
    }

    public static void main(String[] args) {
        final MyException myException = new MyException();
        myException.initCause(null);
    }

    // void m2() {
    //     try {
    //     } catch (RuntimeException e) {
    //     } catch (IndexOutOfBoundsException e) {
    //     }
    // }
    //
    // void m3() {
    //     try {
    //     } catch (IndexOutOfBoundsException e) {
    //     } catch (IndexOutOfBoundsException e) {
    //     }
    // }


    Writer m2() {
        try {
            return new FileWriter("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void m3() {
        Writer writer = null;
        try {
            writer = m2();
        } finally {
            try {
                IOUtils.close(writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void m32() {
        final ReentrantLock reentrantLock = new ReentrantLock();
        try {
        } finally {
            reentrantLock.unlock();
        }
    }

    void m4() {
        try (final FileWriter fileWriter = new FileWriter("")) {

        } catch (IOException e) {

        }
    }

}
