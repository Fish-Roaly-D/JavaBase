package com.roily.root.demo.aboutaop.common.util.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2022/09/05/17:42
 * @Description: 抽象枚举类
 */
public abstract class AbstractEnums implements EnumAbstractInterface{


    // abstract Enum[] values();
    //
    // @Override
    // public String enumDesc(String code) {
    //     return enumMap().get(code);
    // }
    //
    // @Override
    // public Map<String, String> enumMap() {
    //     final List<BusinessType> businessTypes = Arrays.asList(this.values());
    //     final HashMap<String, String> mapReturn = businessTypes.stream().collect(HashMap::new, (map, item) -> {
    //         map.put(item.code, item.desc);
    //     }, HashMap::putAll);
    //     return mapReturn;
    // }



}
