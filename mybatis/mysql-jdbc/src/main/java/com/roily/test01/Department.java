package com.roily.test01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    private Integer deptId;
    private String deptName;
    private Integer delete;
    private Date create_time;
    private Date modify_time;

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", delete=" + delete +
                ", create_time=" + format.format(create_time) +
                ", modify_time=" + format.format(modify_time) +
                '}';
    }
}
