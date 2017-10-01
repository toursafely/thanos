package com.toursafely.thanos;

import com.toursafely.thanos.resource.UserRes;
import com.toursafely.thanos.util.ModuleHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App extends Application<AppConfiguration> {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "thanos";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        // nothing to do yet
    }

    public void run(AppConfiguration config, Environment environment) throws Exception {
        LOG.info("Starting Communication Server with ENV   ::    " + config.getEnvironment());

        final UserRes userRes = new UserRes();
        final ModuleHealthCheck moduleHealthCheck = new ModuleHealthCheck("thanos-" + environment.getName());
        environment.healthChecks().register("module", moduleHealthCheck);
        environment.jersey().register(userRes);
    }

    private String getNameForEnv(AppConfiguration appConfiguration) {
        if (appConfiguration.getEnvironment().isProd())
            return "";
        return "-dev";
    }
}
