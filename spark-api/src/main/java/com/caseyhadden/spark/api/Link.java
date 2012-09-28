package com.caseyhadden.spark.api;

import javax.ws.rs.HttpMethod;

public class Link {

    private String rel;
    private String href;
    private String method;

    public Link(String rel, String href, String method) {
        this.rel = rel;
        this.href = href;
        this.method = method;
    }

    public String getRel() { return rel; }
    public void setRel(String rel) { this.rel = rel; }

    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
}
