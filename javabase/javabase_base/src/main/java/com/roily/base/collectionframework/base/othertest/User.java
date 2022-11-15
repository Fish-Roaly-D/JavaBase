package com.roily.base.collectionframework.base.othertest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {

    private int age;
    private String name;

    @Override
    public int compareTo(User o) {
        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        }
        return 0;
    }
}
