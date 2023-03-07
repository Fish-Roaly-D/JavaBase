package com.hmdp.utils;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Date: 2023/03/06/11:09
 * @Description:
 */
public class OptionalUtil {


    public static <T> Optional<T> resolve(Supplier<T> supplier) {
        try {
            final T t = supplier.get();
            return Optional.ofNullable(t);
        } catch (Exception e) {

            return Optional.empty();
        }
    }


}
