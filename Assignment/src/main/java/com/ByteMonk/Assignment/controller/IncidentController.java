package com.ByteMonk.Assignment.controller;

import com.ByteMonk.Assignment.model.Incident;
import com.ByteMonk.Assignment.service.IncidentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/incidents")
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @PostMapping
    public ResponseEntity<Incident> createIncident(HttpServletRequest request,@RequestBody Incident incident){
        log.info("REQUEST from IP:{}, ENDPOINT:{}, METHOD:{} ",request.getRemoteAddr(),request.getRequestURI(),request.getMethod());
        return ResponseEntity.status(HttpStatus.CREATED).body(incidentService.createIncident(incident));
    }

    @GetMapping
    public ResponseEntity<List<Incident>> listIncidents(@RequestParam(required = false) String severity,
                                                        @RequestParam(required = false) LocalDate startDate,
                                                        @RequestParam(required = false) LocalDate endDate) {
        return ResponseEntity.ok(incidentService.listIncidents(severity, startDate, endDate));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Incident> updataIncident(@PathVariable Long id, @RequestBody Incident incident){
        return ResponseEntity.ok(incidentService.updateIncident(id,incident));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncident(@PathVariable Long id){
        return ResponseEntity.ok(incidentService.getIncident(id));
    }
}
