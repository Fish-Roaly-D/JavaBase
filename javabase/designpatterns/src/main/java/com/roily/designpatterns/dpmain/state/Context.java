package com.roily.designpatterns.dpmain.state;

import lombok.Data;

/**
 * @className：Context
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/21 21:34
 */
@Data
public class Context {

    /**
     * 上下文包含了state对象
     */
    private State state;

}
