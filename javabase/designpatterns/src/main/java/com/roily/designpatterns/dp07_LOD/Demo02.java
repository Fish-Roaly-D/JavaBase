package com.roily.designpatterns.dp07_LOD;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description 修改
 * @ClassName Demo02.java
 * @author: RoilyFish
 * @date: 2022/5/31 23:53
 */
public class Demo02 {

    @Test
    public void test(){

        Source language = new Source(60, "语文");
        Source math = new Source(60, "数学");
        Source english = new Source(60, "英语");
        List<Source> sources = new ArrayList<>();
        sources.add(language);
        sources.add(math);
        sources.add(english);

        Teacher2 teacher2 = new Teacher2(sources);

        Student2 student2 = new Student2();
        student2.getSumSource(teacher2);

    }

}



@Data
@AllArgsConstructor
class Source2 {
    Integer source;
    String subject;
}

class Student2 {

    void getSumSource(Teacher2 teacher) {

        teacher.calculate();
    }


}

@Data
@AllArgsConstructor
class Teacher2 {
    List<Source> list;
    void calculate() {
        int sum = list.stream().mapToInt(Source::getSource).sum();
        System.out.println("总成绩：" + sum);
    }

}