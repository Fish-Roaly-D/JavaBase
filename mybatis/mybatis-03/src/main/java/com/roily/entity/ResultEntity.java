package com.roily.entity;

import lombok.*;

import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/12
 */
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity {

    private long intProperty;
    private String stringProperty;
    private Date dateProperty;

}
