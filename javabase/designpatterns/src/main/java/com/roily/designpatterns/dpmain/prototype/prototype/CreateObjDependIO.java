package com.roily.designpatterns.dpmain.prototype.prototype;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0.0
 * @Description
 * @ClassName CreateObjDependIO.java
 * @author: RoilyFish
 * @date: 2022/6/6 12:30
 */
public class CreateObjDependIO {

    ArrayList<Prototype> prototypes = new ArrayList<>();

    @Test
    public void init() throws IOException {


        //获取项目路径
        String property = System.getProperty("user.dir");

        String path = property + "/file";

        String fileName = "prototype.txt";

        File file = new File(path);

        //创建文件夹
        file.mkdirs();

        file = new File(file, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bw = new BufferedWriter(fileWriter);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sb.append("prototype01")
                    .append("01")
                    .append("21")
                    .append("yyc")
                    .append("sb")
                    .append("11111111111111");
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
            sb.delete(0, sb.length());
        }

        bw.close();
        fileWriter.close();
    }

    @Test
    public void createObjWithIo() throws IOException, CloneNotSupportedException {
        long start = Calendar.getInstance().getTime().getTime();
        FileReader fileReader = new FileReader(new File(System.getProperty("user.dir") + "/file" + "/prototype.txt"));
        BufferedReader br = new BufferedReader(fileReader);
        String str;
        while ((str = br.readLine()) != null) {
            if (str.isEmpty())
                continue;
                //空行不处理
            else {
                Prototype prototype = new Prototype();
                prototype = prototype.setId(Integer.parseInt(str.substring(11, 13)))
                        .setAge(Integer.parseInt(str.substring(13, 15)))
                        .setName(str.substring(15, 18))
                        .setSb(new StringBuffer(str.substring(18, 20)))
                        .setCreateTime(new Date(Long.parseLong(str.substring(20))));

                prototypes.add(prototype);
            }

        }
        fileReader.close();
        br.close();

        long end = Calendar.getInstance().getTime().getTime();
        System.out.println(prototypes.size());
        System.out.println("io创建对象消耗时长：" + (end - start));


        ArrayList<Prototype> arrayList = new ArrayList<>();

        long startCopy = Calendar.getInstance().getTime().getTime();


        for (Prototype prototype : prototypes) {

            arrayList.add(prototype.clone());

        }

        long endCopy = Calendar.getInstance().getTime().getTime();
        System.out.println(arrayList.size());
        System.out.println("拷贝消耗时长：" + (endCopy - startCopy));
    }

}
