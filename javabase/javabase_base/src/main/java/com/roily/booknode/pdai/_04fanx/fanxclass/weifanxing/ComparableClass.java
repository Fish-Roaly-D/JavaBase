package com.roily.booknode.pdai._04fanx.fanxclass.weifanxing;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @Date: 2022/10/26/15:56
 * @Description:
 */
@Data
public class ComparableClass<T> implements Comparable<ComparableClass>{

    T t;

    @Override
    public int compareTo(@NotNull ComparableClass o) {
        return 0;
    }
}
