package com.roily.StringSummary.ideaplugin.lomboksummary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.junit.Test;

/**
 * @className：LombokObj
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/16 00:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class LombokObj {



    String name;

    Integer age;


    @Test
    public void test() {

        //只要加了@Data注解,自动支持getter和setter
        LombokObj lombokObj = new LombokObj();
        lombokObj.getAge();
        lombokObj.getName();
        lombokObj.setName("");
        lombokObj.setAge(1);


        /**
         * @AllArgsConstructor
         * @NoArgsConstructor
         * 构造器，支持无参、全参
         */
        new LombokObj("", 21);

        /**
         * @Accessors(chain = true)
         * 支持链式编程
         */
        lombokObj
                .setName("")
                .setAge(21);

        /**
         * @Builder
         * 支持建造者模式
         */
        new LombokObjBuilder()
                .age(21)
                .name("")
                .build();

    }

}

