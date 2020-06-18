package br.com.aceleradev.java.centraldeerros.service;

import br.com.aceleradev.java.centraldeerros.model.EventLog;
import br.com.aceleradev.java.centraldeerros.model.Level;
import br.com.aceleradev.java.centraldeerros.repository.EventLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventLogServiceImpl implements EventLogService {

    @Autowired
    private EventLogRepository eventLogRepository;

    @Override
    public List<EventLog> findAll(Pageable pageable) {
        return this.eventLogRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<EventLog> findById(Long id) {
        return eventLogRepository.findById(id);
    }

    @Override
    public EventLog save(EventLog event) {
        return eventLogRepository.save(event);
    }

    @Override
    public List<EventLog> findByLevel(Level level, Pageable pageable) {
        return eventLogRepository.findByLevel(level, pageable).getContent();
    }

    @Override
    public List<EventLog> findByDescription(String description, Pageable pageable) {
        return eventLogRepository.findByDescription(description, pageable).getContent();
    }

    @Override
    public List<EventLog> findByLog(String log, Pageable pageable) {
        return eventLogRepository.findByLog(log, pageable).getContent();
    }

    @Override
    public List<EventLog> findByDate(LocalDateTime date, Pageable pageable) {
        return eventLogRepository.findByDate(date,pageable).getContent();
    }

    @Override
    public List<EventLog> findByQuantity(Long qtd, Pageable pageable) {
        return eventLogRepository.findByQuantity(qtd, pageable).getContent();
    }
}
