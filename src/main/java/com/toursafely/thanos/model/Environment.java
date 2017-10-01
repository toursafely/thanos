package com.toursafely.thanos.model;

public enum Environment {

    PRODUCTION("production"),
    STAGING("staging"),
    DEVELOPMENT("development");

    private final String envKeyName;

    Environment(String envKeyName) {
        this.envKeyName = envKeyName;
    }

    public String getEnvKeyName() {
        return envKeyName;
    }

    public boolean isProd() {
        return this.equals(PRODUCTION);
    }

    public boolean isNotProd() {
        return !this.isProd();
    }

}
