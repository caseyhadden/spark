package com.caseyhadden.spark.db;

import com.caseyhadden.spark.api.Spark;

import com.yammer.dropwizard.json.Json;
import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import java.lang.annotation.*;

@BindingAnnotation(SparkBind.SparkBinderFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface SparkBind {

    static class SparkBinderFactory implements BinderFactory {
        static final Json json = new Json();

        @Override
        public Binder build(Annotation annotation) {
            return new Binder<SparkBind, Spark>() {
                @Override
                public void bind(SQLStatement<?> q, SparkBind bind, Spark spark) {
                    q.bind("id", spark.getId());
                    q.bind("json", json.writeValueAsString(spark));
                }
            };
        }
    }

}
