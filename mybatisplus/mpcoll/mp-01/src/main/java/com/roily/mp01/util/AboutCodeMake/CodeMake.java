package com.roily.mp01.util.AboutCodeMake;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.roily.mp01.base.BaseController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

class CodeMake {

    static {
        InputStream in = ClassLoader.getSystemResourceAsStream("public/db.properties");

        Properties prop = new Properties();

        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(prop);
    }

    public static void main(String[] args) {

        DataSourceConfig.Builder dataSourceConfigBuilder =
                new DataSourceConfig.Builder(
                        DbProperties.URL.getValue(),
                        DbProperties.USER.getValue(),
                        DbProperties.PASSWORD.getValue());

        //配置 entity service xml impl 等文件输出路径
        Map<OutputFile, String> outputFileStringMap =
                Collections.singletonMap(OutputFile.xml, "mp-01\\src\\main\\resources\\mapper");


        FastAutoGenerator
                .create(dataSourceConfigBuilder)
                //.create(DbProperties.URL.getValue(),DbProperties.PASSWORD.getValue(),DbProperties.USER.getValue())
                .globalConfig(builder -> {
                    builder.author("roilyFish") // 设置作者
                            .dateType(DateType.TIME_PACK)//实体日期属性类型
                            .commentDate("yyyy-MM-dd")
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()//生成文件后、不要打开目录
                            .outputDir("mp-01\\src\\main\\java"); // 指定输出目录
                })
                //包路径配置
                .packageConfig(builder -> {
                    builder
                            .parent("com.roily.mp01") // 设置父包名 会影响package
                            .moduleName("backstage") // 设置父包模块名
                            .entity("entity")//实体类包名
                            .service("service")//service包名
                            .serviceImpl("service.impl")//impl包名
                            .mapper("mapper")//mapper接口包名
                            .controller("controller")//controller包名
                            .other("other")
                            //.xml("mp-01\\src\\main\\resources\\mapper")//mapper.xml 输出路径
                            //以上配置都基于父包路径
                            .pathInfo(outputFileStringMap); // 设置mapperXml生成路径
                })
                //模板配置
                .templateConfig(builder -> {
                    builder
                            //.disable()//禁用所有模板
                            //.disable(TemplateType.ENTITY)//禁用模板  不生成Entity
                            .entity("/templates/entity.java")
                            //.service("/templates/service.java")
                            //.serviceImpl("/templates/serviceImpl.java")
                            //.mapper("/templates/mapper.java")
                            ////.mapperXml("/templates/mapper.xml")
                            //.controller("/templates/controller.java")
                            .build();
                })
                .injectionConfig(builder -> {
                    builder
                            .beforeOutputFile((tableInfo, objectMap) -> {
                                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                                    System.out.println(objectMap);
                                }

                            )
                            .customMap(Collections.singletonMap("test", "baomidou"))
                            //.customFile(Collections.singletonMap("test.txt", "/templates/entity.vm"))
                            .build();
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user")// 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .addTableSuffix("_info")// 设置过滤表后缀
                            //.addFieldPrefix("") // 设置过滤字段前缀
                            //.addFieldSuffix("") // 设置过滤字段后缀
                            .entityBuilder()
                                //.disableSerialVersionUID()//禁用生成serialVersionUID
                                .enableLombok()//允许启用lombok  没有get set  简洁
                                .enableRemoveIsPrefix()//允许去除bollean类型is前缀
                                .enableTableFieldAnnotation()// 开启生成实体时,生成字段注解 即 @TableField
                                .enableActiveRecord()//ActiveRecord 模式 crud更简洁
                                //.versionColumnName("version")//设置乐观锁字段
                                .versionPropertyName("version")//设置乐观锁属性
                                //.logicDeleteColumnName("deleted")//逻辑删除字段
                                .logicDeletePropertyName("deleted")//逻辑删除属性
                                .naming(NamingStrategy.underline_to_camel)//数据库名  驼峰命名
                                .columnNaming(NamingStrategy.underline_to_camel)//数据库字段 驼峰命名
                                //.addSuperEntityColumns("id")
                                //.addIgnoreColumns("deleted")//忽略字段
                                .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("update_time", FieldFill.INSERT_UPDATE))
                                .idType(IdType.AUTO)//主键生成策略
                                .fileOverride()//覆盖已有文件
                                //.formatFileName("%s")
                            .build()
                                .controllerBuilder()
                                //.superClass(BaseController.class)//设置父类
                                .enableRestStyle()//@RestController
                                //.formatFileName("%sAction")//格式化文件名称
                            .build()

                            .serviceBuilder()
                                //.superServiceClass()//父类
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImpl")
                            .build()

                            .mapperBuilder()
                                //.superClass()//父类
                                //.enableMapperAnnotation()//开启@Mapper 一般都会的配置扫描包
                                .enableBaseResultMap()
                                //.formatMapperFileName("%sMapper")
                                //.formatXmlFileName("%sMapper")
                            .build();


                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}