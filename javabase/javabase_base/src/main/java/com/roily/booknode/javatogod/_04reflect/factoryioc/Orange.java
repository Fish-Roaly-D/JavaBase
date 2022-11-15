package com.roily.booknode.javatogod._04reflect.factoryioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @classname：Apple
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/26 00:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orange implements Fruit{

    String name;

    @Override
    public void describe() {
        System.out.println(this.name);
    }
}
