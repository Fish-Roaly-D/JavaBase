package com.roly.api;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessage implements FallbackFactory<ProviderApi> {
    @Override
    public ProviderApi create(Throwable cause) {

        return new ProviderApi() {
            @Override
            public String test1(String data) {
                return "null";
            }

            @Override
            public String test2(String data) {
                return "null";
            }
        };

    }
}
