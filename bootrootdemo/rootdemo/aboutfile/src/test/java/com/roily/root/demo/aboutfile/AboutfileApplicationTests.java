package com.roily.root.demo.aboutfile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootTest
class AboutfileApplicationTests {

    @Test
    void contextLoads() throws IOException {

        String fileName = "1.txt";
        File file = new File(System.getProperty("user.dir") + File.separator + "image");

        if (!file.exists()){
            file.mkdirs();
        }

        new File(file.getPath(),fileName);

    }

}
