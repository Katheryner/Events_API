package com.riwi.event.services.service_abstract;

import com.riwi.event.entities.Event;

import java.util.List;

import org.springframework.data.domain.Page;


public interface IEventService {

    Event save(Event event);

    List<Event> getAll();

    Event findById(String id);

    void delete(String id);

    Event update(String id, Event event);

    Event findByName(String name);

    Page<Event> getAllPaginated(int page, int size);



}
