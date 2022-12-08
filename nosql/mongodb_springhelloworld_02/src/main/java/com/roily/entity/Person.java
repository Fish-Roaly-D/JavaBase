package com.roily.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Person {

    private ObjectId id;

    private String name;

    private int age;

    private Address address;

    public Person setId(ObjectId id) {
        this.id = id;
        return this;
    }
}
