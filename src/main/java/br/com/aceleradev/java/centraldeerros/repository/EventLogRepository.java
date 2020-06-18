package br.com.aceleradev.java.centraldeerros.repository;

import br.com.aceleradev.java.centraldeerros.model.EventLog;
import br.com.aceleradev.java.centraldeerros.model.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface EventLogRepository extends CrudRepository<EventLog, Long> {

    @Query(value = "select id,level,description,origin,date,quantity from EVENTLOG", nativeQuery = true)
    Page<EventLog> findAll(Pageable pageable);

    Page<EventLog> findByLevel(Level level, Pageable pageable);

    Page<EventLog> findByDescription(String description, Pageable pageable);

    Page<EventLog> findByLog(String Log, Pageable pageable);

    Page<EventLog> findByDate(Date date, Pageable pageable);

    Page<EventLog> findByQuantity(Long qtd, Pageable pageable);




}
