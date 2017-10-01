package com.toursafely.thanos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toursafely.thanos.model.Environment;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class AppConfiguration extends Configuration {

    @NotNull
    @Valid
    private DataSourceFactory database = new DataSourceFactory();

    @NotNull
    private Environment environment;


    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }


    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}