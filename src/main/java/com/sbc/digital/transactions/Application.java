package com.sbc.digital.transactions;

import io.micronaut.runtime.Micronaut;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class Application {
    public static void main(String[] args) {
        Micronaut.build(args)
                .eagerInitSingletons(true)
                .mainClass(Application.class)
                .start();
    }
}
