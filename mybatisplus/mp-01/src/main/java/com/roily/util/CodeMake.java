package com.roily.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

class CodeMake{
    public static void main(String[] args) {
        FastAutoGenerator
                .create("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("roilyFish") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\programmeTools\\idea\\git\\JavaBase\\mybatisplus\\mp-01\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.roily.codemake") // 设置父包名
                            .moduleName("codeMakeTest") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\programmeTools\\idea\\git\\JavaBase\\mybatisplus\\mp-01\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("department")

                    ; // 设置需要生成的表名
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}