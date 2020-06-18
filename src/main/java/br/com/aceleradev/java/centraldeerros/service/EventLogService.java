package br.com.aceleradev.java.centraldeerros.service;

import br.com.aceleradev.java.centraldeerros.model.EventLog;
import br.com.aceleradev.java.centraldeerros.model.Level;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventLogService {

    List<EventLog> findAll(Pageable pageable);

    Optional<EventLog> findById(Long id);

    EventLog save(EventLog event);

    List<EventLog> findByLevel(Level level, Pageable pageable);

    List<EventLog> findByDescription(String description, Pageable pageable);

    List<EventLog> findByLog(String log, Pageable pageable);

    List<EventLog> findByDate(Date date, Pageable pageable);

    List<EventLog> findByQuantity(Long qtd, Pageable pageable);



}
