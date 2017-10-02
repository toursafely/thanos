package com.toursafely.thanos;

import com.toursafely.thanos.resource.UserRes;
import com.toursafely.thanos.util.ModuleHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ThanosApp extends Application<ThanosConfiguration> {

    private static final Logger LOG = LoggerFactory.getLogger(ThanosApp.class);

    private final HibernateBundle<ThanosConfiguration> hibernateBundle =
            new HibernateBundle<ThanosConfiguration>(Object.class) { //TODO add all models

                public DataSourceFactory getDataSourceFactory(ThanosConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };


    public static void main( String[] args ) throws Exception {
        new ThanosApp().run(args);
    }

    @Override
    public String getName() {
        return "thanos";
    }

    @Override
    public void initialize(Bootstrap<ThanosConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<ThanosConfiguration>() {
            public DataSourceFactory getDataSourceFactory(ThanosConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

        bootstrap.addBundle(hibernateBundle);
    }

    public void run(ThanosConfiguration config, Environment environment) throws Exception {
        LOG.info("Starting Communication Server with ENV   ::    " + config.getEnvironment());

        final UserRes userRes = new UserRes();
        final ModuleHealthCheck moduleHealthCheck = new ModuleHealthCheck("thanos-" + environment.getName());
        environment.healthChecks().register("module", moduleHealthCheck);
        environment.jersey().register(userRes);
    }

    private String getNameForEnv(ThanosConfiguration thanosConfiguration) {
        if (thanosConfiguration.getEnvironment().isProd())
            return "";
        return "-dev";
    }
}
