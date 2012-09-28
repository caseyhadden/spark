package com.caseyhadden.spark.resources;

import com.caseyhadden.spark.api.Spark;
import com.caseyhadden.spark.db.SparkDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.*;

@Path("/sparks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SparkResource {

    @Context
    UriInfo context;
    SparkDao dao;

    public SparkResource(SparkDao dao) {
        this.dao = dao;
    }

    @GET
    public Collection<Spark> list() {
        return dao.findALl();
    }

    @GET
    @Path("{id}")
    public Spark get(@PathParam("id") String id) {
        Spark spark = dao.findById(id);
        if (null == spark)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        return spark;
    }

    @POST
    public Response create(Spark spark) {
        spark.setId(UUID.randomUUID().toString());
        spark.setDate(new Date());
        dao.insert(spark);
        return Response.created(URI.create(String.valueOf(spark.getId()))).build();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        dao.delete(id);
    }

    @DELETE
    public void deleteAll() {
        dao.deleteAll();
    }

}
