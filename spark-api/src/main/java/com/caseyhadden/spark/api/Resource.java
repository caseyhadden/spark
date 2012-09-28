package com.caseyhadden.spark.api;

import java.util.ArrayList;
import java.util.List;

public class Resource<T> {

    private T entity;
    private List<Link> links;

    public Resource(T entity)
    {
        this.entity = entity;
        links = new ArrayList<Link>();
    }

    public T getEntity() { return entity; }
    public void setEntity(T entity) { this.entity = entity; }

    public List<Link> getLinks() { return links; }
    public void setLinks(List<Link> links) { this.links = links; }

    public void addLink(Link link) {
        links.add(link);
    }

}
