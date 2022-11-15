package com.roily.booknode.javatogod._09sugar;

import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Date: 2022/09/05/14:08
 * @Description:
 */
public class TestTWR {


    public static void main(String[] args)  {
        String filePath = "E://1.txt";
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
        }catch (IOException e){
        }finally {
            try {
                IOUtils.close(fr);
            } catch (IOException e) {
            }
        }
    }

    public void method1(){
        String filePath = "E://1.txt";
        try(FileReader fr = new FileReader(filePath)) {
        }catch (IOException e){
        }

    }

}
