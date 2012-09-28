package com.caseyhadden.spark;

import com.caseyhadden.spark.cli.SetupDatabaseCommand;
import com.caseyhadden.spark.db.SparkDao;
import com.caseyhadden.spark.resources.RootResource;
import com.caseyhadden.spark.resources.SparkResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;

public class SparkService extends Service<SparkConfiguration> {

    public static void main(String[] args) throws Exception {
        new SparkService().run(args);
    }

    private SparkService() {
        super("spark");
        addCommand(new SetupDatabaseCommand());
    }

    @Override
    protected void initialize(SparkConfiguration configuration,
                              Environment environment) throws ClassNotFoundException {
        DatabaseFactory factory = new DatabaseFactory(environment);
        Database db = factory.build(configuration.getDatabaseConfiguration(), "h2");
        SparkDao dao = db.onDemand(SparkDao.class);

        environment.addResource(new RootResource());
        environment.addResource(new SparkResource(dao));
    }
}
