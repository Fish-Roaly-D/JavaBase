package com.roily.StringSummary.testDemo;

import lombok.Data;
import lombok.ToString;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
@ToString
public class SonEntity extends FatherEntity {


    public SonEntity(StringBuffer sb) {
        super(sb);
        sb.append("子类append");
    }
}
