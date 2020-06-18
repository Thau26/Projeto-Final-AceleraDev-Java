package br.com.aceleradev.java.centraldeerros.controller;

import br.com.aceleradev.java.centraldeerros.exceptions.ResourceNotFoundException;
import br.com.aceleradev.java.centraldeerros.model.EventLog;
import br.com.aceleradev.java.centraldeerros.model.Level;
import br.com.aceleradev.java.centraldeerros.service.EventLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventLogController {

    @Autowired
    private EventLogService eventLogService;

    @PostMapping
    @ApiOperation("Cria um registro de evento")
    @ApiResponses(value = {@ApiResponse(code = 201, message= "Evento criado com sucesso")})
    public ResponseEntity<EventLog> create(@Valid @RequestBody EventLog eventLog){
        return new ResponseEntity<EventLog>(this.eventLogService.save(eventLog), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EventLog> update(@Valid @RequestBody EventLog eventLog) {
        return new ResponseEntity<EventLog>(this.eventLogService.save(eventLog), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista os registros de eventos")
    public Iterable<EventLog> findAll(Pageable pageable) {
        return this.eventLogService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não localizado"), @ApiResponse(code = 200, message = "Evento localizado")})
    public ResponseEntity<EventLog> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<EventLog>(this.eventLogService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log de evento")), HttpStatus.OK);
    }

    @GetMapping
    public List<EventLog> findByLevel(@RequestParam(required = false) Level level, Pageable pageable){
        return eventLogService.findByLevel(level, pageable);
    }

    @GetMapping
    public List<EventLog> findByDescription(@RequestParam(required = false) String description, Pageable pageable){
        return eventLogService.findByDescription(description, pageable);
    }








}
