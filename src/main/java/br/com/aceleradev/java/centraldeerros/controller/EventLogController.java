package br.com.aceleradev.java.centraldeerros.controller;

import br.com.aceleradev.java.centraldeerros.dto.EventLogDTO;
import br.com.aceleradev.java.centraldeerros.exceptions.ResourceNotFoundException;
import br.com.aceleradev.java.centraldeerros.mapper.EventLogMapper;
import br.com.aceleradev.java.centraldeerros.model.EventLog;
import br.com.aceleradev.java.centraldeerros.service.EventLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventLogController {

    @Autowired
    private EventLogService eventLogService;

    private EventLogMapper eventLogMapper = Mappers.getMapper(EventLogMapper.class);

    @PostMapping
    @ApiOperation("Cria um registro de evento")
    @ApiResponses(value = {@ApiResponse(code = 201, message= "Evento criado com sucesso")})
    public ResponseEntity<EventLog> create(@Valid @RequestBody EventLog eventLog){
        return new ResponseEntity<EventLog>(this.eventLogService.save(eventLog), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Atualiza um registro de evento")
    public ResponseEntity<EventLog> update(@Valid @RequestBody EventLog eventLog) {
        return new ResponseEntity<EventLog>(this.eventLogService.save(eventLog), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta um registro de evento")
    public void delete(@PathVariable("id") Long id) {
        this.eventLogService.deleteById(id);
    }

    @GetMapping
    @ApiOperation("Lista todos os eventos")
    public List<EventLogDTO> findAll(Pageable pageable) {
        return eventLogMapper.map(eventLogService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation("Lista um evento por id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não localizado"), @ApiResponse(code = 200, message = "Evento localizado")})
    public ResponseEntity<EventLog> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<EventLog>(this.eventLogService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log de evento")), HttpStatus.OK);
    }

    @GetMapping("/byDescription/{description}")
    @ApiOperation("Filtra os eventos por descricao")
    public List<EventLogDTO> findByDescription(@PathVariable("description") String description, Pageable pageable) {
        return eventLogMapper.map(eventLogService.findByDescription(description,pageable));
    }

    @GetMapping("/byLevel/{level}")
    @ApiOperation("Filtra os eventos por level")
    public List<EventLogDTO> findByLevel(@PathVariable("level") String level, Pageable pageable) {
        return eventLogMapper.map(eventLogService.findByLevel(level,pageable));
    }

    @GetMapping("/byOrigin/{origin}")
    @ApiOperation("Filtra os eventos pela origem")
    public List<EventLogDTO> findByOrigin(@PathVariable("origin") String origin, Pageable pageable) {
        return eventLogMapper.map(eventLogService.findByOrigin(origin,pageable));
    }

    @GetMapping("/byDate/{date}")
    @ApiOperation("Filtra os eventos pela data")
    public List<EventLogDTO> findByDate(@PathVariable("date") String date, Pageable pageable) {
        return eventLogMapper.map(eventLogService.findByDate(date,pageable));
    }

    @GetMapping("/byQuantity/{quantity}")
    @ApiOperation("Filtra os eventos pela quantidade")
    public List<EventLogDTO> findByQuantity(@PathVariable("quantity") Long quantity, Pageable pageable) {
        return eventLogMapper.map(eventLogService.findByQuantity(quantity,pageable));
    }










}
