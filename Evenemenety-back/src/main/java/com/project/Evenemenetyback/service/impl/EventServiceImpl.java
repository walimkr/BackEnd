package com.project.Evenemenetyback.service.impl;

import com.project.Evenemenetyback.domain.Covoiturage;
import com.project.Evenemenetyback.domain.Event;
import com.project.Evenemenetyback.repository.CovoiturageRepository;
import com.project.Evenemenetyback.repository.EventRepository;

import com.project.Evenemenetyback.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



public class EventServiceImpl implements EventService {

    private final Logger log = LoggerFactory.getLogger(CovoiturageServiceImpl.class);

    private final EventRepository eventRepository;


    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Save a event.
     *
     * @param event the entity to save
     * @return the persisted entity
     */
    @Override
    public Event save(Event event) {
        log.debug("Request to save event : {}", event);
        Event result = eventRepository.save(event);
        return result;
    }

    /**
     * Get all the event.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Event> findAll() {
        log.debug("Request to get all events");
        return eventRepository.findAll();
    }


    /**
     * Get one event by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Event> findOne(Long id) {
        log.debug("Request to get event : {}", id);
        return eventRepository.findById(id);
    }

    /**
     * Delete the event by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Field : {}", id);
        eventRepository.deleteById(id);
    }


}