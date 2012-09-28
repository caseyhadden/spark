package com.caseyhadden.spark.db;

import com.caseyhadden.spark.api.Spark;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(SparkMapper.class)
public interface SparkDao {

    @SqlUpdate("create table if not exists sparks (id varchar(36) primary key, json text)")
    void createTable();

    @SqlQuery("select json from sparks")
    List<Spark> findALl();

    @SqlQuery("select json from sparks where id = :id")
    Spark findById(@Bind("id") String id);

    @SqlUpdate("insert into sparks (id, json) values (:id, :json)")
    void insert(@SparkBind Spark spark);

    @SqlUpdate("delete from sparks where id = :id")
    void delete(@Bind("id") String id);

    @SqlUpdate("delete from sparks")
    void deleteAll();
}

