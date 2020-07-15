package com.cleartax.app;

import com.cleartax.app.resources.*;

import org.jdbi.v3.core.Jdbi;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DropWizardEventsApplication extends Application<DropWizardEventsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardEventsApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardEvents";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardEventsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropWizardEventsConfiguration configuration, final Environment environment) {

        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        EventResource eventResource = new EventResource(jdbi);
        environment.jersey().register(eventResource);
    }

}
