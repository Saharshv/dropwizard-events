package com.cleartax.app.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cleartax.app.api.Event;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class EventMapper implements RowMapper<Event> {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String LOCATION = "location";

    public Event map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Event event = new Event(resultSet.getString(NAME), resultSet.getString(DESCRIPTION),
                resultSet.getString(LOCATION));
        event.setId(resultSet.getInt(ID));
        return event;
    }
}