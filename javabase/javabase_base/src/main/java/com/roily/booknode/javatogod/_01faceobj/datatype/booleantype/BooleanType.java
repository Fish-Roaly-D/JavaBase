package com.roily.booknode.javatogod._01faceobj.datatype.booleantype;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.IOException;

/**
 * @Date: 2022/08/01/14:13
 * @Description:
 */
public class BooleanType {


    @Test
    public void test() throws JsonProcessingException {


        Gson gson = new Gson();
        ObjectMapper om = new ObjectMapper();

        BooleanType1 booleanType1 = new BooleanType1(true);
        System.out.println("booleanType1");
        System.out.println("FastJson:boolean success: => " + JSON.toJSON(booleanType1));
        System.out.println("Gson:boolean success: => " + gson.toJson(booleanType1));
        System.out.println("JackSon:boolean success: => " + om.writeValueAsString(booleanType1));

        BooleanType2 booleanType2 = new BooleanType2(true);
        System.out.println("booleanType2");
        System.out.println("FastJson:boolean isSuccess: => " + JSON.toJSON(booleanType2));
        System.out.println("Gson:boolean isSuccess: => " + gson.toJson(booleanType2));
        System.out.println("JackSon:boolean isSuccess: => " + om.writeValueAsString(booleanType2));

        BooleanType3 booleanType3 = new BooleanType3(true);
        System.out.println("booleanType3");
        System.out.println("FastJson:Boolean success: => " + JSON.toJSON(booleanType3));
        System.out.println("Gson:Boolean success: => " + gson.toJson(booleanType3));
        System.out.println("JackSon:Boolean success: => " + om.writeValueAsString(booleanType3));

        BooleanType4 booleanType4 = new BooleanType4(true);
        System.out.println("booleanType4");
        System.out.println("FastJson:Boolean isSuccess: => " + JSON.toJSON(booleanType4));
        System.out.println("Gson:Boolean isSuccess: => " + gson.toJson(booleanType4));
        System.out.println("JackSon:Boolean isSuccess: => " + om.writeValueAsString(booleanType4));
    }

    @Test
    public void testSer() throws IOException {

        BooleanType2 booleanType2 = new BooleanType2(true);
        //使用fastjson序列话
        String jsonStr = JSON.toJSONString(booleanType2);
        System.out.println("json字符串：=》" + jsonStr);
        //分别使用 fastJson 、 GSON  、 JackSon反序列化
        BooleanType2 t1 = JSON.toJavaObject(JSON.parseObject(jsonStr), BooleanType2.class);
        System.out.println("FastJson反序列化后=》" + t1);

        ObjectMapper om = new ObjectMapper();
        BooleanType2 t2 = om.readValue(jsonStr, BooleanType2.class);
        System.out.println("Jackson反序列化后=》" + t2);

        Gson gson = new Gson();
        BooleanType2 t3 = gson.fromJson(jsonStr, BooleanType2.class);
        System.out.println("Gson反序列化后=》" + t3);
    }
}

@Data
@AllArgsConstructor
class BooleanType1 {
    boolean success;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class BooleanType2 {
    boolean isSuccess;
}

@Data
@AllArgsConstructor
class BooleanType3 {
    Boolean success;
}

@Data
@AllArgsConstructor
class BooleanType4 {
    Boolean isSuccess;
}