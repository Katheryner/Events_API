package com.riwi.event.services;

import com.riwi.event.entities.Event;
import com.riwi.event.repositories.EventRepository;
import com.riwi.event.services.service_abstract.IEventService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    private final EventRepository eventRepository;
    @Override
    public Event save(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }
    
   @Override
    public Page<Event> getAllPaginated(int page, int size) {
        if (page<0 ) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
    
        return this. eventRepository.findAll(pagination);
    }

    @Override
    public Event findById(String id) {
        return this.eventRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public Event update(String id, Event event) {
        this.eventRepository.findById(id).orElseThrow();
        event.setId(id);

        return this.eventRepository.save(event);
    }

    @Override
    public Event findByName(String name) {
        return this.eventRepository.findByName(name);
    }
}
