package com.roily.StringSummary.testDemo;

import com.roily.StringSummary.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
//此类未被final修饰，也就是可以被继承
@Data
@ToString
@Getter
public class FatherEntity {

    //被final修饰的属性
    final  StringBuffer stringBuffer;

    public FatherEntity(StringBuffer sb) {
        this.stringBuffer = sb;
    }

    //提供修改方法
    public void modifySb(String append){

        stringBuffer.append(append);
    }
}
