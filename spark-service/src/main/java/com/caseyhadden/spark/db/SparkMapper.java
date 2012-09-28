package com.caseyhadden.spark.db;

import static com.google.common.base.Throwables.propagate;

import com.caseyhadden.spark.api.Spark;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yammer.dropwizard.json.Json;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class SparkMapper implements ResultSetMapper<Spark> {

    Json json = new Json();

    public Spark map(int i, ResultSet resultSet, StatementContext statementContext)
        throws SQLException {
        try {
            return json.readValue(resultSet.getString("json"), Spark.class);
        } catch (IOException e) {
            throw propagate(e);
        }
    }


}
