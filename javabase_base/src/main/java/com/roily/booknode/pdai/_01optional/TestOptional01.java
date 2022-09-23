package com.roily.booknode.pdai._01optional;

import lombok.Data;
import org.junit.Test;

import javax.lang.model.element.Element;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Date: 2022/09/23/17:31
 * @Description:
 */
public class TestOptional01 {

    /**
     * of为非null值创建Optional
     */
    @Test
    public void testOf() {

        final Optional<String> optional = Optional.of("str");

        final Optional<String> optionalOfNullable = Optional.ofNullable(null);

        final boolean present = optionalOfNullable.isPresent();

        final String s = optional.get();


        optional.ifPresent(System.out::println);


        optionalOfNullable.orElse("other");

        optionalOfNullable.orElseGet(String::new);

        optionalOfNullable.orElseThrow(NullPointerException::new);

        final Optional<String> optionalS = optional.map(ele -> "map");
        final Optional<String> optionalFlatMap = optional.flatMap(ele -> Optional.of("map"));

        //过滤，符合条件返回this，不符合返回empty
        final Optional<String> optionalS1 = optional.filter(ele -> ele.equals(""));
    }


    @Test
    public void use() {
        final Element1 element1 = new Element1();
        if (null != element1 && null != element1.getElement2() && null != element1.getElement2().getElement3()) {
            System.out.println(element1.getElement2().getElement3().getStr());
        }
    }

    @Test
    public void useOptional() {
        final Element1 element1 = new Element1();

        Optional.ofNullable(element1).map(Element1::getElement2).map(Element1.Element2::getElement3).ifPresent(System.out::println);

    }

    @Test
    public void testxxx() {
        final Element1 element1 = new Element1();

        OptionalUtil.resolve(() -> element1.getElement2().getElement3()).ifPresent(ele -> {
            System.out.println(ele.getStr());
        });
    }

}

@Data
class Element1 {
    Element2 element2;

    @Data
    static class Element2 {
        Element3 element3;

        @Data
        static class Element3 {
            String str;
        }
    }
}

class OptionalUtil {
    public static <T> Optional<T> resolve(Supplier<T> supplier) {
        try {
            T t = supplier.get();
            return Optional.ofNullable(t);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}