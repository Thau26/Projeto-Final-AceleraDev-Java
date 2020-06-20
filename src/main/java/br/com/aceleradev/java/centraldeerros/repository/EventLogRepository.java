package br.com.aceleradev.java.centraldeerros.repository;

import br.com.aceleradev.java.centraldeerros.model.EventLog;
import br.com.aceleradev.java.centraldeerros.model.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface EventLogRepository extends CrudRepository<EventLog, Long> {


    Page<EventLog> findAll(Pageable pageable);

    Page<EventLog> findByLevel(String level, Pageable pageable);

    Page<EventLog> findByDescriptionContaining(String description, Pageable pageable);

    Page<EventLog> findByOrigin(String origin, Pageable pageable);

    Page<EventLog> findByDate(String date, Pageable pageable);

    Page<EventLog> findByQuantity(Long qtd, Pageable pageable);




}
