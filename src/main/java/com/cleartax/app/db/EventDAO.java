package com.cleartax.app.db;

import java.util.List;

import com.cleartax.app.api.Event;
import com.cleartax.app.mappers.EventMapper;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterRowMapper(EventMapper.class)
public interface EventDAO {

    @SqlUpdate("insert into newevents (name, description, location) values (:name, :description, :location)")
    int addEvent(@BindBean final Event event);

    @SqlQuery("select * from newevents")
    List<Event> getEvents();

    @SqlQuery("select * from newevents where id = :id")
    public Event getEvent(@Bind("id") final int id);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();
}