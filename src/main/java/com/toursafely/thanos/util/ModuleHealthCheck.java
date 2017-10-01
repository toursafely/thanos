package com.toursafely.thanos.util;

import com.codahale.metrics.health.HealthCheck;

public class ModuleHealthCheck extends HealthCheck {

    private String module;

    public ModuleHealthCheck(String module) {
        this.module = module;
    }

    @Override
    protected Result check() throws Exception {

        return Result.healthy();
    }
}
