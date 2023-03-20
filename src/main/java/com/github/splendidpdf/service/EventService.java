package com.github.splendidpdf.service;

import com.github.splendidpdf.exception.EntityAlreadyExistsException;
import com.github.splendidpdf.model.BotUser;
import com.github.splendidpdf.model.Event;
import com.github.splendidpdf.model.Role;
import com.github.splendidpdf.model.TimeZone;
import com.github.splendidpdf.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Transactional
    public void create() throws EntityAlreadyExistsException {
        Event event = Event.builder()
                .name("name")
                .description("desc")
                .localDateTime(LocalDateTime.now())
                .linkMeet("link")
                .build();
        eventRepository.save(event);
    }

}
