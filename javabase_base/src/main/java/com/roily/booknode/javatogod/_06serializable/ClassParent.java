package com.roily.booknode.javatogod._06serializable;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @classname：ClassPerent
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/30 00:26
 */
@Data
public class ClassParent implements Serializable {
    public String value1;
}
@Data
@ToString(callSuper = true)
class ClassSon extends ClassParent {
    public String value2;
}
@Data
class ClassSonSon extends ClassSon {

    public String value;

}

