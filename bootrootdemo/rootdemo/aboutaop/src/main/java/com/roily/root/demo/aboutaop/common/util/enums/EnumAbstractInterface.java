package com.roily.root.demo.aboutaop.common.util.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2022/09/05/17:30
 * @Description: 枚举抽象接口
 */
public interface EnumAbstractInterface<K, V> {

    /**
     * 透过code 得到desc
     *
     * @param code
     * @return
     */
    String enumDesc(String code);

    /**
     * 枚举转化map
     *
     * @return
     */
    Map<K, V> enumMap();

    Enum[] values();

}
