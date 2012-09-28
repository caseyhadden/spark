package com.caseyhadden.spark.api;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class Spark {
    String id;
    String text;
    Date date;

    public void setId(String id) { this.id = id; }
    public String getId() { return id; }

    public void setText(String text) { this.text = text; }
    public String getText() { return text; }

    public void setDate(Date date) { this.date = date; }
    public Date getDate() { return date; }
}
