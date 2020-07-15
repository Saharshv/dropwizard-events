package com.cleartax.app.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private String location;
    @JsonProperty
    private Date date;

    public Event() {
        super();
    }

    public Event(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = new Date();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }
}