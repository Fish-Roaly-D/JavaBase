package com.roily.designpatterns.dp07_LOD;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @version 1.0.0
 * @Description 一个类之和直接相关的类交流
 * @ClassName Demo01.java
 * @author: RoilyFish
 * @date: 2022/5/31 23:33
 */
public class Demo01 {

    @Test
    public void test() {
        Teacher teacher = new Teacher();
        Student student = new Student();
        student.getSumSource(teacher);
    }
}


@Data
@AllArgsConstructor
class Source {
    Integer source;
    String subject;
}

class Student {

    void getSumSource(Teacher teacher) {

        Source language = new Source(60, "语文");
        Source math = new Source(60, "数学");
        Source english = new Source(60, "英语");
        List<Source> sources = new ArrayList<>();
        sources.add(language);
        sources.add(math);
        sources.add(english);
        teacher.calculate(sources);
    }


}

class Teacher {

    void calculate(List<Source> list) {

        int sum = list.stream().mapToInt(Source::getSource).sum();

        System.out.println("总成绩：" + sum);
    }

}