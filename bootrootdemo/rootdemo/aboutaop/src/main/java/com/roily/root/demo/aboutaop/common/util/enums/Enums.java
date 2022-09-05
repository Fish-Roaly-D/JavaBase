package com.roily.root.demo.aboutaop.common.util.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rolyfish
 * @Date: 2022/09/05/17:26
 * @Description: 枚举工具类
 */
public class Enums {

    /**
     * 业务类型
     */
    @AllArgsConstructor
    public enum BusinessType implements EnumAbstractInterface<String, String> {
        /**
         * 业务类型增删改查
         */
        ADD("添加", "1"),
        DELETE("删除", "2"),
        QUERY("查询", "3"),
        UPDATE("更新", "4");

        private String desc;

        private String code;

        @Override
        public String enumDesc(String code) {
            return enumMap().get(code);
        }

        @Override
        public Map<String, String> enumMap() {
            final List<BusinessType> businessTypes = Arrays.asList(BusinessType.values());
            final HashMap<String, String> mapReturn = businessTypes.stream().collect(HashMap::new, (map, item) -> {
                map.put(item.code, item.desc);
            }, HashMap::putAll);
            return mapReturn;
        }
    }


}
