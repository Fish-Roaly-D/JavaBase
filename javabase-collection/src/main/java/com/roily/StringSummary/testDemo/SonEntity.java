package com.roily.StringSummary.testDemo;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
public class SonEntity extends FatherEntity {

    public SonEntity(StringBuffer sb) {
        super(sb);
        sb.append("子类append");
    }

    @Override
    public String toString() {
        return "SonEntity{" +
                "stringBuffer=" + stringBuffer +
                '}';
    }
}
