package com.roily.designpatterns.dpmain.chainofresponsibility;

import lombok.AllArgsConstructor;
import org.springframework.util.ObjectUtils;

/**
 * @className：Handler1
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/18 00:08
 */
@AllArgsConstructor
public class HandlerImpl extends AbstractHandler implements Handler {

    private String name;

    @Override
    public void operate() {
        System.out.println(this.name);
        final Handler handler = super.getHandler();
        if (!ObjectUtils.isEmpty(handler)) {
            handler.operate();
        }
    }
}
