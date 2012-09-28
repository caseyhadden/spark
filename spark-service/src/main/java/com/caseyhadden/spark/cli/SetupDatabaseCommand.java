package com.caseyhadden.spark.cli;

import com.caseyhadden.spark.SparkConfiguration;
import com.caseyhadden.spark.db.SparkDao;
import com.yammer.dropwizard.AbstractService;
import com.yammer.dropwizard.cli.ConfiguredCommand;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;
import com.yammer.dropwizard.logging.Log;
import org.apache.commons.cli.CommandLine;

public class SetupDatabaseCommand extends ConfiguredCommand<SparkConfiguration> {

    public SetupDatabaseCommand() {
        super("setup", "Setup the database.");
    }

    @Override
    public void run(AbstractService<SparkConfiguration> service,
                    SparkConfiguration configuration, CommandLine params) throws Exception {
        Log log = Log.forClass(SetupDatabaseCommand.class);
        Environment environment = new Environment(service, configuration);
        DatabaseFactory factory = new DatabaseFactory(environment);
        Database db = factory.build(configuration.getDatabaseConfiguration(), "h2");
        SparkDao dao = db.onDemand(SparkDao.class);

        log.info("Creating tables...");
        dao.createTable();
    }

}
