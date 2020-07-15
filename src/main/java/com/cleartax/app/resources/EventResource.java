package com.cleartax.app.resources;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cleartax.app.api.Event;
import com.cleartax.app.db.EventDAO;
import com.codahale.metrics.annotation.Timed;

import org.jdbi.v3.core.Jdbi;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    private final EventDAO eventDAO;

    public EventResource(Jdbi jdbi) {
        eventDAO = jdbi.onDemand(EventDAO.class);
    }

    @GET
    @Timed
    public Response allEvents() {
        return Response.ok(eventDAO.getEvents()).build();
    }

    @POST
    @Timed
    public Response createEmployee(@NotNull @Valid final Event event) {
        Event eventAdd = new Event(event.getName(), event.getDescription(), event.getLocation());
        return Response.ok(eventDAO.addEvent(eventAdd)).build();
    }
}